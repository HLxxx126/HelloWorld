package com.itheima.reggie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * 分類管理
 * @author dreammtank125
 *
 */

@RestController
@RequestMapping("/category")
@Slf4j

public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	/**
	 *  分類を追加する
	 * @param category
	 * @return
	 */
	@PostMapping
	public R<String> save(@RequestBody Category category){
		log.info("category = {}",category);
		
		categoryService.save(category);
		return R.success("追加成功しました〜");
	}
	
	/**
	 * ページングクエリ
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/page")
	public R<Page> page(int page , int pageSize){
		Page<Category> pageInfo = new Page<Category>(page,pageSize);
		LambdaQueryWrapper<Category> queryMapper = new LambdaQueryWrapper<Category>();
		//検索条件を追加し、フィールド 'sort' に基づいて昇順で並べ替える
		queryMapper.orderByAsc(Category::getSort);
		categoryService.page(pageInfo, queryMapper);
		return R.success(pageInfo);
	}
	/**
	 * IDに基づいてカテゴリを削除する
	 * @param id
	 * @return
	 */
	@DeleteMapping
	public R<String> deleteById(Long id){
		log.info("id:{}のカテゴリを削除する",id);
		//categoryService.removeById(id);
		categoryService.remove(id);
		return R.success("削除成功しました〜");
	}
	
	/**
	 * IDに基づいてカテゴリ情報を更新する
	 * @param category
	 * @return
	 */
	
	@PutMapping
	public R<String> update(@RequestBody Category category){
		log.info("カテゴリ情報を更新する:{}",category);
		categoryService.updateById(category);
		return R.success("更新成功しました〜");
	}
	
	
	/**
	 * 条件に基づいてカテゴリデータを検索する。"
	 * @param category
	 * @return
	 */
	@GetMapping("/list")
	public R<List<Category>> list(Category category){
		LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.eq(category.getType() != null, Category::getType, category.getType());
		//ソート条件を追加する
		lambdaQueryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
		List<Category> list = categoryService.list();
		return R.success(list);
	}

}
