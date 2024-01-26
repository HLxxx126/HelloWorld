package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Orders;

public interface OrderService extends IService<Orders>{

	/**
	 * 
	 * @param order
	 */
	void submit(Orders orders);

}
