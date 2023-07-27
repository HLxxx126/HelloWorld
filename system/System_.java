package com.hspedu.chapter13.system;

import java.util.Arrays;

/**
 * @author HLxxx
 * @version 1.0
 */
public class System_ {
    public static void main(String[] args) {
        //exit 退出当前程序
        System.out.println("ok1");
        //System.exit(0);//参数代表状态，0表示正常状态
        System.out.println("ok2");

        //arraycopy，复制数组元素，比较适合底层调用
        //一般使用Arrays.copyOf完成复制数组

        int[] src = {1, 2, 3};
        int[] dest = new int[3];
        System.arraycopy(src,0,dest,0,3);//(源数组，从源数组哪个索引开始拷贝，目标数组，拷贝到目标数组哪个位置，
        //从源数组拷贝多少个数据到目标数组）
        System.out.println(Arrays.toString(dest));

        //currentTimeMillis:返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());
    }
}
