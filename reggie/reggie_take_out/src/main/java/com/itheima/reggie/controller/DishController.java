package com.itheima.reggie.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
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
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.entity.SetmealDish;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.DishFlavorService;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.SetmealDishService;
import com.itheima.reggie.service.SetmealService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {

	@Autowired
	private DishService dishService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private DishFlavorService dishFlavorService;
	
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 料理を追加する
	 * 
	 * @param dishDto
	 * @return
	 */

	@PostMapping
	public R<String> save(@RequestBody DishDto dishDto) {
		log.info(dishDto.toString());
		dishService.saveWithFlavor(dishDto);

		return R.success("料理追加成功しました〜");
	}

	/**
	 * 料理情報のページネーション検索
	 * 
	 * @param page
	 * @param pagesize
	 * @param name
	 * @return
	 */

	@GetMapping("/page")
	public R<Page> page(int page, int pageSize, String name) {
		Page<Dish> pageInfo = new Page<Dish>(page, pageSize);

		Page<DishDto> disDtoPage = new Page<>();

		LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(name != null, Dish::getName, name);
		queryWrapper.orderByDesc(Dish::getUpdateTime);
		dishService.page(pageInfo, queryWrapper);

		// オブジェクトをコピーする
		org.springframework.beans.BeanUtils.copyProperties(pageInfo, disDtoPage, "records");
		List<Dish> records = pageInfo.getRecords();
		List<DishDto> list = records.stream().map((item) -> {
			DishDto dishDto = new DishDto();
			BeanUtils.copyProperties(item, dishDto);
			Long categoryId = item.getCategoryId();
			Category category = categoryService.getById(categoryId);
			if (category != null) {
				String categoryName = category.getName();
				dishDto.setCategoryName(categoryName);
			}
			return dishDto;
		}).collect(Collectors.toList());

		disDtoPage.setRecords(list);

		return R.success(disDtoPage);
	}

	/**
	 * IDに基づいて料理情報とその料理に対応する味を検索する
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/{id}")
	public R<DishDto> getById(@PathVariable Long id) {
		DishDto dishDto = dishService.getByIdWithFlavor(id);
		return R.success(dishDto);

	}

	/**
	 * 料理情報とその料理に対応する味を更新する
	 * 
	 * @param dishDto
	 * @return
	 */
	@PutMapping
	public R<String> update(@RequestBody DishDto dishDto) {
		
		dishService.updateWithFlavor(dishDto);
		//すべての料理のキャッシュデータをクリアします
		//Set keys = redisTemplate.keys("dish_*");
		//redisTemplate.delete(keys);
		//特定のカテゴリーの料理のキャッシュデータをクリアします
		String key = "dish_"+ dishDto.getCategoryId()  + "_1";
		redisTemplate.delete(key);
		return R.success("更新成功しました〜");
	}

	/**
	 * 複数の料理のステータスを一括変更する/もし料理は販売終止、関連しているセットメニューも販売終止に設定する
	 * 
	 * @param status
	 * @param ids
	 * @return
	 */
	@Transactional
	@PostMapping("/status/{status}")
	public R<String> status(@PathVariable Integer status, Long[] ids) {

		dishService.status(status, ids);
		return R.success("ステータスを更新成功しました〜");
	}

	/**
	 * 料理を削除する
	 * 
	 * @param ids
	 * @return
	 */
	@DeleteMapping
	public R<String> delete(Long[] ids) {
		dishService.removeDish(ids);
		return R.success("削除成功しました〜");

	}

	/**
	 * 条件に基づいて料理情報とその料理に対応する味を検索する
	 * 
	 * @param dish
	 * @return
	 */
//	@GetMapping("/list")
//	public R<List<Dish>> list(Dish dish) {
//		LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
//		queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
//		queryWrapper.eq(Dish::getStatus, 1);
//		queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
//		List<Dish> list = dishService.list(queryWrapper);
//		return R.success(list);
//	}

	@GetMapping("/list")
	public R<List<DishDto>> list(Dish dish) {
		List<DishDto> dishDtoList = null;
		String key = "dish_" + dish.getCategoryId() + "_" + dish.getStatus(); 
		//まず、Redis からキャッシュデータを取得します
		dishDtoList = (List<DishDto>) redisTemplate.opsForValue().get(key);
		if (dishDtoList != null) {
			//存在する場合、直ちに返却し、データベースの検索は必要ありません。
			return R.success(dishDtoList);
		}
		//存在しない場合、データベースを検索し、検索された料理データをRedisにキャッシュします。
		LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
		queryWrapper.eq(Dish::getStatus, 1);
		queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
		List<Dish> list = dishService.list(queryWrapper);
		dishDtoList = list.stream().map((item) -> {
			DishDto dishDto = new DishDto();
			BeanUtils.copyProperties(item, dishDto);
			Long categoryId = item.getCategoryId();
			Category category = categoryService.getById(categoryId);
			if (category != null) {
				String cateoryName = category.getName();
				dishDto.setCategoryName(cateoryName);
			}
			Long dishId = item.getId();
			LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<DishFlavor>();
			lambdaQueryWrapper.eq(DishFlavor::getDishId, dishId);
			List<DishFlavor> dishFlavorList = dishFlavorService.list(lambdaQueryWrapper);
			dishDto.setFlavors(dishFlavorList);

			return dishDto;
		}).collect(Collectors.toList());
		redisTemplate.opsForValue().set(key, dishDtoList,60,TimeUnit.MINUTES);
		
		return R.success(dishDtoList);
	}

}
