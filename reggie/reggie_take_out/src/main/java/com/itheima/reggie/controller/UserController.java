package com.itheima.reggie.controller;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.service.UserService;
import com.itheima.reggie.utils.SMSUtils;
import com.itheima.reggie.utils.ValidateCodeUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 短信認証コードを送信する
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/sendMsg")
	public R<String> sendMsg(@RequestBody User user, HttpSession session) {
		// 電話番号を獲得する
		String phone = user.getPhone();
		if (StringUtils.isNotEmpty(phone)) {
			// 長さ4のランダム認証コードを生成する
			
			String code = ValidateCodeUtils.generateValidateCode(4).toString();
			
			log.info("code = {}", code);
			// メッセージサービスのAPIを利用し、メッセージを送る
			// SMSUtils.sendMessage(signName, templateCode, phone, code);
			// 生成した認証コードをSessionに保存する
			
			//session.setAttribute(phone, code);
			
			//生成した認証コードをRedisにキャッシュする,有効期間を5分に設定する
			redisTemplate.opsForValue().set(phone, code,5,TimeUnit.MINUTES);
			log.info("Saved code {} for phone {} in session", code, phone);
			return R.success("認証コードを送信しました");

		}

		return R.error("認証コードを送信失敗しました");

	}

	/**
	 * 移动端ユーザーログイン
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	public R<User> login(@RequestBody Map map, HttpSession session) {
		log.info(map.toString());
		// 電話番号を獲得する
		String phone = map.get("phone").toString();
		log.info(phone);

		// ユーザが入力した認証コードを獲得する
		String code = map.get("code").toString();
		log.info(code);

		// Sessionから保存されたコードを獲得する
		//Object codeInSession = session.getAttribute(phone);
		//Redisからキャッシュされたコードを獲得する
		Object codeInSession = redisTemplate.opsForValue().get(phone);
		// 二つのコードを引き合わせる
		if (codeInSession != null && codeInSession.equals(code)) {
			// 同じの場合、ログインが成功
			LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
			queryWrapper.eq(User::getPhone, phone);
			User user = userService.getOne(queryWrapper);
			if (user == null) {
				// ただいまの電話番号は新しいユーザかどうかを判断する、新しいユーザの場合自動的に登録します
				user = new User();
				user.setPhone(phone);
				user.setStatus(1);
				userService.save(user);
			}
			session.setAttribute("user",user.getId());
			//ユーザーがログインに成功した場合、Redis キャッシュした検証コードを削除します
			redisTemplate.delete(phone);
			return R.success(user);
		}
		// 違いの場合、ログインが失敗

		return R.error("ログイン失敗しました");

	}

}
