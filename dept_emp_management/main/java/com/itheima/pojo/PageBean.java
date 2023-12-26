package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 * ページング検索結果のラッパークラス
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;//総レコード数
    private List rows;//結果リスト
}
