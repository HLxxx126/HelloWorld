package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Setmeal;

public interface SetmealService extends IService<Setmeal>{
	
	//新しいセットメニューを追加し、同時にそのセットメニューに対応する料理のデータを挿入します
	public void saveWithDish(SetmealDto setmealDto);

	//IDに基づいてセットメニュー情報とそのセットメニューに対応する料理を検索する
	public SetmealDto getWithDish(Long id);

	//セットメニュー情報とそのセットメニューに対応する料理を更新する
	public void updateWithDish(SetmealDto setmealDto);

	//セットメニューを削除する,同時にそのセットメニューに対応する料理も削除する
	public void deleteWithDish(Long[] ids);

}
