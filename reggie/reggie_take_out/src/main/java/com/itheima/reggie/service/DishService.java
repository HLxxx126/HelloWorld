package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;

public interface DishService extends IService<Dish>{
	//新しい料理を追加し、同時にその料理に対応する味のデータを挿入します
	public void saveWithFlavor(DishDto dishDto);
	
	//IDに基づいて料理情報とその料理に対応する味を検索する
	public DishDto getByIdWithFlavor(Long id) ;
	
	//料理情報とその料理に対応する味を更新する
	public void updateWithFlavor(DishDto dishDto);
	
	//料理を削除する,同時にその料理に対応する味も削除する、ただし料理はセットメニューに関連している場合は削除できません。
	public void removeDish(Long[] ids);

	public void status(Integer status, Long[] ids);
	

}
