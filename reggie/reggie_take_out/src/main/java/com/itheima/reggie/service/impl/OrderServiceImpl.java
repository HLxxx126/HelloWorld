package com.itheima.reggie.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.entity.AddressBook;
import com.itheima.reggie.entity.OrderDetail;
import com.itheima.reggie.entity.Orders;
import com.itheima.reggie.entity.ShoppingCart;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.mapper.OrderMapper;
import com.itheima.reggie.service.AddressBookService;
import com.itheima.reggie.service.OrderDetailService;
import com.itheima.reggie.service.OrderService;
import com.itheima.reggie.service.ShoppingCartService;
import com.itheima.reggie.service.UserService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private UserService userService;
	@Autowired
	private AddressBookService addressBookService;
	@Autowired
	private OrderDetailService orderDetailService;

	/**
	 * ユーザーが注文する
	 */
	@Override
	@Transactional
	public void submit(Orders orders) {
		// 現在のユーザーIDを取得する
		Long currentId = BaseContext.getCurrentId();

		// 在のユーザーのショッピングカートデータを検索する
		LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<ShoppingCart>();
		queryWrapper.eq(ShoppingCart::getUserId, currentId);
		List<ShoppingCart> shoppingCarts = shoppingCartService.list(queryWrapper);
		if (shoppingCarts == null || shoppingCarts.size() == 0) {
			throw new CustomException("ショッピングカートが空のため、注文できません");

		}
		// ユーザー情報を検索します
		User user = userService.getById(currentId);

		// アドレスを検索します

		Long addressBookId = orders.getAddressBookId();
		long orderId = IdWorker.getId();
		AddressBook addressBook = addressBookService.getById(addressBookId);
		if (addressBook == null) {
			throw new CustomException("ユーザーの住所情報が正しくありません。注文できません。");
		}
		AtomicInteger amount = new AtomicInteger(0);

		List<OrderDetail> orderDetails = shoppingCarts.stream().map((item) -> {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(orderId);
			orderDetail.setNumber(item.getNumber());
			orderDetail.setDishFlavor(item.getDishFlavor());
			orderDetail.setDishId(item.getDishId());
			orderDetail.setSetmealId(item.getSetmealId());
			orderDetail.setName(item.getName());
			orderDetail.setImage(item.getImage());
			orderDetail.setAmount(item.getAmount());
			amount.addAndGet(item.getAmount().multiply(new BigDecimal(item.getNumber())).intValue());
			return orderDetail;

		}).collect(Collectors.toList());

		
		orders.setNumber(String.valueOf(orderId));
		orders.setId(orderId);
		orders.setOrderTime(LocalDateTime.now());
		orders.setCheckoutTime(LocalDateTime.now());
		orders.setStatus(2);
		orders.setAmount(new BigDecimal(amount.get()));
		orders.setUserId(currentId);
		orders.setUserName(user.getName());
		orders.setConsignee(addressBook.getConsignee());// 收货人
		orders.setPhone(addressBook.getPhone());
		orders.setAddress((addressBook.getProvinceName() == null ? "" : addressBook.getProvinceName())
				+ (addressBook.getCityName() == null ? "" : addressBook.getCityName())
				+ (addressBook.getDistrictName() == null ? "" : addressBook.getDistrictName())
				+ (addressBook.getDetail() == null ? "" : addressBook.getDetail()));

		// 注文テーブルにデータを挿入する
		this.save(orders);

		// "注文明細テーブルにデータを挿入する"
		orderDetailService.saveBatch(orderDetails);
		// ショッピングカートを空にする
		shoppingCartService.remove(queryWrapper);
	}

}
