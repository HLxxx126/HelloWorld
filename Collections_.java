package com.hspedu.chapter14.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("tom");
        list.add("smithy");
        list.add("king");
        list.add("milan");
        //reverse(List):反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println("list = " + list);
        //shuffle(List):对List集合元素进行随机排序
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(list);
            System.out.println("list = " + list);
        }
        //sort(List):根据元素的自然顺序对指定List集合元素按升序排序
        Collections.sort(list);
        System.out.println("------自然排序后------");
        System.out.println("list = " + list);
        //sort(List.Comparator):根据指定的Comparator产生的顺序对指定List集合元素排序
        Collections.sort(list, new Comparator() {//按字符串长度排序
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("-------按字符串长度排序------");
        System.out.println("list = " + list);
        //swap（List,int,int)将指定list集合中的i处元素和j处元素进行交换
        Collections.swap(list,1,2);
        System.out.println("list = " + list);
        //Object max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println("自然顺序的最大元素 ： " + Collections.max(list));
        //Object max(Collection, Comparator):据指定的Comparator指定的顺序，返回给定集合中的最大元素
        //返回字符串长度最大的
        System.out.println("字符串长度最大的元素：" + Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        }));
        //Object min(Collection):根据元素的自然顺序，返回给定集合中的最小元素
        //Object max(Collection, Comparator):据指定的Comparator指定的顺序，返回给定集合中的最小元素

        //int frequency( Collection,Object):返回指定集合中指定元素的出现次数
        System.out.println("tom出现的次数 = " + Collections.frequency(list,"tom"));
        //void copy(List dest,List src):将src中的内容复制到dest中
        ArrayList dest = new ArrayList();
        //为了完成拷贝，需要先给dest赋值，大小和list一样
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
            
        }
        Collections.copy(dest,list);
        System.out.println("dest = " + dest);
        //boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换List对象的所有旧值
        //如果list中有tom就替换成汤姆
        Collections.replaceAll(list,"tom","汤姆");
        System.out.println("list替换后 = " + list);

    }
}
