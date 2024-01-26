package com.itheima.reggie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.SetmealDishService;
import com.itheima.reggie.service.SetmealService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {
	@Autowired
	private SetmealDishService setmealDishService;
	@Autowired
	private SetmealService setmealService;
	@Autowired
	private CategoryService categoryService;

	/**
	 * セットメニューが追加する
	 * 
	 * @param setmealDto
	 * @return
	 */
	@PostMapping
	public R<String> save(@RequestBody SetmealDto setmealDto) {
		log.info("セットメニューの情報は:{}", setmealDto);
		setmealService.saveWithDish(setmealDto);
		return R.success("追加成功しました〜");
	}

	/**
	 * セットメニュー情報のページネーション検索
	 * 
	 * @param page
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@GetMapping("/page")
	public R<Page> page(int page, int pageSize, String name) {
		Page pageInfo = new Page<Setmeal>(page, pageSize);
		Page<SetmealDto> pageDto = new Page<>();
		LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.like(name != null, Setmeal::getName, name);
		lambdaQueryWrapper.orderByDesc(Setmeal::getUpdateTime);
		setmealService.page(pageInfo, lambdaQueryWrapper);
		BeanUtils.copyProperties(pageInfo, pageDto, "records");
		List<Setmeal> records = pageInfo.getRecords();
		List<SetmealDto> list = records.stream().map((item) -> {
			SetmealDto setmealDto = new SetmealDto();
			BeanUtils.copyProperties(item, setmealDto);
			Long categoryId = item.getCategoryId();
			Category category = categoryService.getById(categoryId);
			if (category != null) {
				String categoryName = category.getName();
				setmealDto.setCategoryName(categoryName);
			}
			return setmealDto;
		}).collect(Collectors.toList());
		pageDto.setRecords(list);

		return R.success(pageDto);
	}

	/**
	 * 複数のセットメニューのステータスを一括変更する
	 * 
	 * @param status
	 * @param ids
	 * @return
	 */
	@PostMapping("/status/{status}")
	public R<String> status(@PathVariable Integer status, Long[] ids) {
		for (Long id : ids) {
			Setmeal setmeal = setmealService.getById(id);
			setmeal.setStatus(status);
			setmealService.updateById(setmeal);
		}
		return R.success("ステータスを更新成功しました〜");
	}

	/**
	 * IDに基づいてセットメニュー情報とそのセットメニューに対応する料理を検索する
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	public R<SetmealDto> getById(@PathVariable Long id) {
		SetmealDto setmealDto = setmealService.getWithDish(id);

		return R.success(setmealDto);
	}
	/**
	 * セットメニュー情報とそのセットメニューに対応する料理を更新する
	 * @param setmealDto
	 * @return
	 */
	@PutMapping
	public R<String> update(@RequestBody SetmealDto setmealDto){
		setmealService.updateWithDish(setmealDto);
		return R.success("更新成功しました〜");
	}
	
	/**
	 * セットメニューを削除する,同時にそのセットメニューに対応する料理も削除する,ただしセットメニューのステータスは販売中たら削除できません
	 * @param ids
	 * @return
	 */
	@DeleteMapping
	public R<String> deleteById(Long[] ids){
		setmealService.deleteWithDish(ids);
		return R.success("削除成功しました〜");
	}
	
	
	@GetMapping("/list")
	@Cacheable(value = "setmealCache" , key = "#setmeal.categoryId + '_' + #setmeal.status")
	public R<List<Setmeal>>list(Setmeal setmeal){
		LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<Setmeal>();
		queryWrapper.eq(setmeal.getCategoryId()!=null,Setmeal::getCategoryId,setmeal.getCategoryId());
		queryWrapper.eq(setmeal.getStatus()!=null,Setmeal::getStatus,setmeal.getStatus());
		queryWrapper.orderByDesc(Setmeal::getUpdateTime);
		List<Setmeal> list = setmealService.list(queryWrapper);
		return R.success(list);
		
	}
}
