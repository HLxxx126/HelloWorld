package com.itheima.reggie.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.sound.midi.MidiDevice.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.ShoppingCart;
import com.itheima.reggie.service.ShoppingCartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/shoppingCart")
@Slf4j
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	/**
	 * カートに追加
	 * @param shoppingCart
	 * @return
	 */
	@PostMapping("/add")
	public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart) {
		log.info("ショッピングカートのデータ:{}",shoppingCart);
		//ユーザーIDを設定し、現在どのユーザーのショッピングカートデータかを指定します。
		Long currentId = BaseContext.getCurrentId();
		shoppingCart.setUserId(currentId);
		
		//現在の料理またはセットがショッピングカートに含まれているかどうかを検索します
		Long dishId = shoppingCart.getDishId();
		
		LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<ShoppingCart>();
		queryWrapper.eq(ShoppingCart::getUserId,currentId);
		if (dishId != null) {
			//カートに追加されるのは料理です。
			queryWrapper.eq(ShoppingCart::getDishId, dishId);
			
			
		}else {
			//カートに追加されるのはセットメニューです。
			queryWrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
		}
		 ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);
		 if (cartServiceOne!=null) {
			//既に存在している場合、数量を元の数量に加算します
		Integer number = cartServiceOne.getNumber();
		cartServiceOne.setNumber(number+1);
		shoppingCartService.updateById(cartServiceOne);
		}else {
			//存在しない場合、カートに追加し、数量はデフォルトで1となります。
			shoppingCart.setNumber(1);
			shoppingCart.setCreateTime(LocalDateTime.now());
			shoppingCartService.save(shoppingCart);
			cartServiceOne = shoppingCart;
		}
		return R.success(cartServiceOne);

	}
	
	/**
	 * ショッピングカートを確認します
	 * @return
	 */
	
	@GetMapping("/list")
	public R<List<ShoppingCart>> list(){
		LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<ShoppingCart>();
		queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());
		queryWrapper.orderByAsc(ShoppingCart::getCreateTime);
		List<ShoppingCart> list = shoppingCartService.list(queryWrapper);
		
		return R.success(list);
	}
	
	/**
	 * ショッピングカートを空にする
	 * @return
	 */
	@DeleteMapping("clean")
	public R<String> clean(){
		LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<ShoppingCart>();
		queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());
		shoppingCartService.remove(queryWrapper);
		return R.success("ショッピングカートがクリアしました");
	}
	
	
	/**
	 * ショッピングカート内の商品の数量を減らす
	 * @param shoppingCart
	 * @return
	 */

	@PostMapping("/sub")
	public R<ShoppingCart> sub(@RequestBody ShoppingCart shoppingCart) {
		log.info("ショッピングカートのデータ:{}",shoppingCart);
		//ユーザーIDを設定し、現在どのユーザーのショッピングカートデータかを指定します。
		Long currentId = BaseContext.getCurrentId();
		shoppingCart.setUserId(currentId);
		
		//現在の料理またはセットがショッピングカートに含まれているかどうかを検索します
		Long dishId = shoppingCart.getDishId();
		
		LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<ShoppingCart>();
		queryWrapper.eq(ShoppingCart::getUserId,currentId);
		if (dishId != null) {
			//カートに追加されるのは料理です。
			queryWrapper.eq(ShoppingCart::getDishId, dishId);
			
			
		}else {
			//カートに追加されるのはセットメニューです。
			queryWrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
		}
		 ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);
		 
		Integer number = cartServiceOne.getNumber();
		if (number>1) {
			cartServiceOne.setNumber(number-1);
			
		}else {
			cartServiceOne.setNumber(number-1);
		shoppingCartService.removeById(cartServiceOne.getId());
		}
		shoppingCartService.updateById(cartServiceOne);
	
		return R.success(cartServiceOne);

	}
	
}
