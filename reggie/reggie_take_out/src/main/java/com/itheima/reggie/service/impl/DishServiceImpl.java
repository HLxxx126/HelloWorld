package com.itheima.reggie.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ListableBeanFactoryExtensionsKt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.entity.SetmealDish;
import com.itheima.reggie.mapper.DishMapper;
import com.itheima.reggie.service.DishFlavorService;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.SetmealDishService;
import com.itheima.reggie.service.SetmealService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
	@Autowired
	private DishFlavorService dishFlavorService;

	@Autowired
	private SetmealDishService setmealDishService;

	@Autowired
	private SetmealService setmealService;

	/**
	 * 新しい料理を追加し、同時にその料理に対応する味のデータを挿入します
	 * 
	 * @param dishDto
	 */

	@Transactional
	public void saveWithFlavor(DishDto dishDto) {
		// 料理の基本情報を料理テーブルに保存する
		this.save(dishDto);
		Long dishId = dishDto.getId();
		List<DishFlavor> flavors = dishDto.getFlavors();
		flavors = flavors.stream().map((item) -> {
			item.setDishId(dishId);
			return item;
		}).collect(Collectors.toList());
		// 料理に対応する味のデータを料理味テーブルに保存する
		dishFlavorService.saveBatch(flavors);

	}

	/**
	 * IDに基づいて料理情報とその料理に対応する味を検索する
	 */
	@Override
	public DishDto getByIdWithFlavor(Long id) {
		Dish dish = this.getById(id);
		DishDto dishDto = new DishDto();
		BeanUtils.copyProperties(dish, dishDto);

		LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(DishFlavor::getDishId, id);
		List<DishFlavor> list = dishFlavorService.list(queryWrapper);
		dishDto.setFlavors(list);
		return dishDto;
	}

	@Override
	/**
	 * 料理情報とその料理に対応する味を更新する
	 */
	@Transactional
	public void updateWithFlavor(DishDto dishDto) {
		// 料理情報を更新する
		this.updateById(dishDto);
		// 現在の料理に対応する味をクリアして、再度追加する
		Long dishId = dishDto.getId();
		LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(DishFlavor::getDishId, dishId);
		dishFlavorService.remove(queryWrapper);
		List<DishFlavor> flavors = dishDto.getFlavors();
		flavors = flavors.stream().map((item) -> {
			item.setDishId(dishId);
			return item;
		}).collect(Collectors.toList());
		// 料理に対応する味のデータを料理味テーブルに保存する
		dishFlavorService.saveBatch(flavors);
	}

	/**
	 * 料理を削除する,同時にその料理に対応する味も削除する、ただし料理はセットメニューに関連している場合は削除できません。
	 */
	@Override
	@Transactional
	public void removeDish(Long[] ids) {

		for (Long id : ids) {
			LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<>();
			queryWrapper.eq(SetmealDish::getDishId, id);
			int count = setmealDishService.count(queryWrapper);
			if (count > 0) {
				throw new CustomException("只今の料理はセットメニューに関連している,削除できません");

			}
			this.removeById(id);
			LambdaQueryWrapper<DishFlavor> queryWrapper2 = new LambdaQueryWrapper<>();
			queryWrapper2.eq(DishFlavor::getDishId, id);
			// List<DishFlavor> list = dishFlavorService.list(queryWrapper2);
			dishFlavorService.remove(queryWrapper2);

		}
	}

	/**
	 * 菜品のステータスを変更する際に、同時にセットメニューのステータスも確認、更新する
	 */
	@Override
	@Transactional
	public void status(Integer status, Long[] ids) {
		for (Long id : ids) {
			Dish dish = this.getById(id);
			dish.setStatus(status);
			this.updateById(dish);
//			if(status == 0) {
//			LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<SetmealDish>();
//			queryWrapper.eq(SetmealDish::getDishId, id);
//			List<SetmealDish> list = setmealDishService.list(queryWrapper);
//			List<Long> setmealIds = new ArrayList<Long>();
//			for (SetmealDish setmealDish : list) {
//				Long setmealId = setmealDish.getSetmealId();
//				setmealIds.add(setmealId);
//			}
//			for (Long setmealId : setmealIds) {
//				Setmeal setmeal = setmealService.getById(setmealId);
//				setmeal.setStatus(0);
//				setmealService.updateById(setmeal);
//			}
//		}
			LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<SetmealDish>();
			queryWrapper.eq(SetmealDish::getDishId, id);
			List<SetmealDish> list = setmealDishService.list(queryWrapper);
			List<Long> setmealIds = list.stream().map(SetmealDish::getSetmealId).collect(Collectors.toList());
			if (!setmealIds.isEmpty()) {
				List<Setmeal> setmeals = setmealService.listByIds(setmealIds);
				for (Setmeal setmeal : setmeals) {
					setmeal.setStatus(status);
				}
				setmealService.updateBatchById(setmeals);
				if (status == 1) {
					int statusCount = 0;
					for (Long setmealId : setmealIds) {
						LambdaQueryWrapper<SetmealDish> queryWrapper2 = new LambdaQueryWrapper<SetmealDish>();
						queryWrapper2.eq(SetmealDish::getSetmealId, setmealId);
						List<SetmealDish> setmealDishes = setmealDishService.list(queryWrapper2);

						for (SetmealDish setmealDish : setmealDishes) {
							Long dishId = setmealDish.getDishId();
							Dish dish1 = this.getById(dishId);
							if (dish1.getStatus() == 0) {
								statusCount += 1;
							}
						}
						if (statusCount > 0) {
							Setmeal setmeal = setmealService.getById(setmealId);
							setmeal.setStatus(0);
							setmealService.updateById(setmeal);

						}
					}

				}

			}
		}
	}
}
