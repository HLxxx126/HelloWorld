package com.itheima.reggie.controller;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.EmployeeService;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 员工登录
	 * 
	 * @param request
	 * @param employee
	 * @return
	 */
	@PostMapping("/login")
	public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {

		// 1、将页面提交的密码password进行md5加密处理
		String password = employee.getPassword();
		password = DigestUtils.md5DigestAsHex(password.getBytes());

		// 2、根据页面提交的用户名username查询数据库
		LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(Employee::getUsername, employee.getUsername());
		Employee emp = employeeService.getOne(queryWrapper);

		// 3、如果没有查询到则返回登录失败结果
		if (emp == null) {
			return R.error("登录失败");
		}

		// 4、密码比对，如果不一致则返回登录失败结果
		if (!emp.getPassword().equals(password)) {
			return R.error("登录失败");
		}

		// 5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
		if (emp.getStatus() == 0) {
			return R.error("账号已禁用");
		}

		// 6、登录成功，将员工id存入Session并返回登录成功结果
		request.getSession().setAttribute("employee", emp.getId());
		return R.success(emp);
	}

	/**
	 * 员工退出
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/logout")
	public R<String> logout(HttpServletRequest request) {
		// 清理Session中保存的当前登录员工的id
		request.getSession().removeAttribute("employee");
		return R.success("退出成功");
	}

	/**
	 * 社員を追加する
	 * 
	 * @param employee
	 * @param request
	 * @return
	 */
	@PostMapping
	public R<String> saveEmployee(@RequestBody Employee employee, HttpServletRequest request) {
		log.info("社員を追加する,社員の情報は{}", employee.toString());
		// 初期パスワードを123456に設定し、MD5ハッシュ処理を行います。
		employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
		//employee.setCreateTime(LocalDateTime.now());
		//employee.setUpdateTime(LocalDateTime.now());
		//employee.setCreateUser((Long) request.getSession().getAttribute("employee"));
		//employee.setUpdateUser((Long) request.getSession().getAttribute("employee"));
		employeeService.save(employee);
		return R.success("社員の追加を成功しました");
	}

	/**
	 * 社員情報のページネーション検索
	 * 
	 * @param page
	 * @param pageSize
	 * @param name
	 * @return
	 */

	@GetMapping("/page")
	public R<Page> page(int page, int pageSize, String name) {
		log.info("page = {},pageSize = {}, name = {}", page, pageSize, name);
		//ページングビルダーを構築する
		
		Page pageInfo = new  Page(page,pageSize);
		//条件ビルダーを構築する
		LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
		//フィルタ条件を追加する
		queryWrapper.like(!StringUtils.isEmpty(name),Employee::getName,name);
		//ソート条件を追加する
		queryWrapper.orderByDesc(Employee::getUpdateTime);
		
		employeeService.page(pageInfo,queryWrapper);
		return R.success(pageInfo);

	}
	
	/**
	 * 社員情報の更新
	 * @param employee
	 * @param request
	 * @return
	 */
	
	@PutMapping
	public R<String> update(@RequestBody Employee employee,HttpServletRequest request){
		log.info("employee:{}",employee);
		//現在ログインしているユーザーのIDを取得する。
		//Long id = (Long)request.getSession().getAttribute("employee");
		//employee.setUpdateUser(id);
		//employee.setUpdateTime(LocalDateTime.now());
		
		employeeService.updateById(employee);
		return R.success("更新成功しました");
	}
	
	/**
	 * idに基づいて社員の情報を検索する
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public R<Employee> getById(@PathVariable Long id){
		log.info("idに基づいて社員の情報を検索する");
		Employee employee = employeeService.getById(id);
		if (employee != null) {
			return R.success(employee);
		}
		return R.error("対応するの社員情報が見つかりませんでした");
		
	}
}
