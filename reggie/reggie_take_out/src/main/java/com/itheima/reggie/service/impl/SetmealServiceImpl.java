package com.itheima.reggie.service.impl;

import java.lang.invoke.LambdaConversionException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.valves.LoadBalancerDrainingValve;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.entity.SetmealDish;
import com.itheima.reggie.mapper.SetmealMapper;
import com.itheima.reggie.service.SetmealDishService;
import com.itheima.reggie.service.SetmealService;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

	@Autowired
	private SetmealDishService setmealDishService;

	/**
	 * 新しいセットメニューを追加し、同時にそのセットメニューに対応する料理のデータを挿入します
	 */

	@Override
	public void saveWithDish(SetmealDto setmealDto) {
		this.save(setmealDto);
		Long setmealId = setmealDto.getId();

		List<SetmealDish> dishs = setmealDto.getSetmealDishes();
		dishs = dishs.stream().map((item) -> {
			item.setSetmealId(setmealId);
			return item;
		}).collect(Collectors.toList());
		setmealDishService.saveBatch(dishs);

	}

	/**
	 * IDに基づいてセットメニュー情報とそのセットメニューに対応する料理を検索する
	 */
	@Override
	public SetmealDto getWithDish(Long id) {
		Setmeal setmeal = this.getById(id);
		SetmealDto setmealDto = new SetmealDto();
		BeanUtils.copyProperties(setmeal, setmealDto);
		LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(SetmealDish::getSetmealId, setmeal.getId());
		List<SetmealDish> list = setmealDishService.list(queryWrapper);
		setmealDto.setSetmealDishes(list);
		return setmealDto;
	}

	/**
	 * セットメニュー情報とそのセットメニューに対応する料理を更新する
	 */
	@Override
	public void updateWithDish(SetmealDto setmealDto) {
		this.updateById(setmealDto);
		Long setmealId = setmealDto.getId();
		LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<SetmealDish>();
		queryWrapper.eq(SetmealDish::getSetmealId, setmealId);
		setmealDishService.remove(queryWrapper);
		List<SetmealDish> dishes = setmealDto.getSetmealDishes();
		dishes = dishes.stream().map((item) -> {
			item.setSetmealId(setmealId);
			return item;
		}).collect(Collectors.toList());
		setmealDishService.saveBatch(dishes);
	}

	/**
	 * セットメニューを削除する,同時にそのセットメニューに対応する料理も削除するただしセットメニュースは販売中たら削除できません
	 */
	@Transactional
	@Override
	public void deleteWithDish(Long[] ids) {
		
		for (Long id : ids) {
			Setmeal setmeal = this.getById(id);
			Integer status = setmeal.getStatus();
			if (status == 1) {
			 throw  new CustomException("このセットメニュースは販売中、削除できません");
			}
			this.removeById(id);
			LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<SetmealDish>();
			queryWrapper.eq(SetmealDish::getSetmealId, id);
			setmealDishService.remove(queryWrapper);
		}

	}

}
