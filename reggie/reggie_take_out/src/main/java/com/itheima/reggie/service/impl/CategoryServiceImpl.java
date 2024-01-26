package com.itheima.reggie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.mapper.CategoryMapper;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.SetmealService;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
	@Autowired
	private DishService dishService;
	@Autowired
	private SetmealService setmealService;
	/**
	 * IDに基づいてカテゴリを削除する,削除する前に料理またはセットメニューに関連しているかどうかを判断する
	 * @param id
	 */

	@Override
	public void remove(Long id) {
		//只今のカテゴリは料理に関連しているかどうかを判断する、関連しているの場合はビジネス例外をスローする
		LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<Dish>();
		dishQueryWrapper.eq(Dish::getCategoryId, id);
		int count = dishService.count(dishQueryWrapper);
		if (count > 0) {
			//カテゴリは料理に関連している,ビジネス例外をスローする
			throw  new CustomException("只今のカカテゴリは料理に関連している,削除できません");
			
		}
		
		//只今のカテゴリはセットメニューに関連しているかどうかを判断する、関連しているの場合はビジネス例外をスローする
		LambdaQueryWrapper<Setmeal> setmeaLambdaQueryWrapper = new LambdaQueryWrapper<Setmeal>();
		setmeaLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
		int count2 = setmealService.count(setmeaLambdaQueryWrapper);
		if (count2 > 0) {
			//カテゴリはセットメニューに関連している,ビジネス例外をスローする
			throw  new CustomException("只今のカカテゴリはセットメニューに関連している,削除できません");
		}
		
		//カテゴリを削除する
		super.removeById(id);
	}

}
