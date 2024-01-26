package com.itheima.reggie.common;

import java.time.LocalDateTime;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * カスタムのメタデータオブジェクトハンドラー
 * @author dreammtank125
 *
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler{
	
/**
 * 挿入する時にフィールドを埋める
 * @param metaObject
 */
	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("共通フィールドの自動補完[insert]");
		log.info(metaObject.toString());
		metaObject.setValue("createTime",LocalDateTime.now());
		metaObject.setValue("updateTime",LocalDateTime.now());
	
		metaObject.setValue("createUser", BaseContext.getCurrentId());
		metaObject.setValue("updateUser", BaseContext.getCurrentId());
		
	}
	
	/**
	 * 更新する時にフィールドを埋める
	 * @param metaObject
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("共通フィールドの自動補完[update]");
		log.info(metaObject.toString());
		metaObject.setValue("updateTime",LocalDateTime.now());
		metaObject.setValue("updateUser", BaseContext.getCurrentId());
		
	}

}
