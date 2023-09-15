package com.hspedu.chapter23.Homework23;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> fileCls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File的构造器 = " + declaredConstructor);
        }
        Constructor<?> declaredConstructor = fileCls.getDeclaredConstructor(String.class);
        String fileAllPath = "src/com/hspedu/chapter23/mynew.txt";
        Object file = declaredConstructor.newInstance(fileAllPath);//创建file对象

        Method createNewFile = fileCls.getMethod("createNewFile");
        createNewFile.invoke(file);
        //file的运行类型就是file
        System.out.println(file.getClass());
        System.out.println("创建文件成功" + fileAllPath);
    }
}
