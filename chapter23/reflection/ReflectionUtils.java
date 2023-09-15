package com.hspedu.chapter23.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author HLxxx
 * @version 1.0
 * 通过反射获取类的结构信息
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }
    @Test
    public void api_02() throws ClassNotFoundException {
        //得到Class对象
        Class<?> personCls = Class.forName("com.hspedu.chapter23.reflection.Person");

        //getDeclaredFields：获取本类中的所有属性
        //默认修饰符是0，public是1，private是2，protected是4，static是8，final是16，（public（1）+static（8）=9
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中的所有属性 = " + declaredField.getName() +
                    "该属性的修饰符值 = " + declaredField.getModifiers() +
                    "该属性的类型 = " + declaredField.getType());
        }
        //getDeclaredMethods：获取本类中的所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中的所有方法 = " + declaredMethod.getName() + "该方法的访问修饰符值 = " +
                    declaredMethod.getModifiers() + "该方法的返回类型 = " + declaredMethod.getReturnType());
            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型 = " + parameterType);
            }
        }
        //getDeclaredConstructors：获取本类中的所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("==========");
            System.out.println("本类中的所有构造器 = " + declaredConstructor.getName());
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型 = " + parameterType);
            }
        }
    }
    //第一组 API
    @Test
    public void api_01() throws ClassNotFoundException {
        //得到Class对象
        Class<?> personCls = Class.forName("com.hspedu.chapter23.reflection.Person");
        //getName:获取全类名
        System.out.println(personCls.getName());
        //getSimpleNAme:获取简单类名
        System.out.println(personCls.getSimpleName());
        //getFields：获取所有public修饰的属性，包含本类及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类的属性 = " + field.getName());
        }
        //getDeclaredFields：获取本类中的所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中的所有属性 = " + declaredField.getName());
        }
        //getMethods：获取所有public修饰的方法，包含本类及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类的方法 = " + method.getName());
        }
        //getDeclaredMethods：获取本类中的所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中的所有方法 = " + declaredMethod.getName());
        }
        //getConstructors：获取所有public修饰的构造器
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类的构造器 = " + constructor.getName());
        }
        //getDeclaredConstructors：获取本类中的所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中的所有构造器 = " + declaredConstructor.getName());
        }
        //getPackage：以Package形式返回包信息
        Package aPackage = personCls.getPackage();//com.hspedu.chapter23.reflection
        System.out.println(aPackage);
        //getSuperClass：以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的class对象 = " + superclass);
        //getInterfaces：以Class【】形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("所有接口 = " + anInterface);
        }
        //getAnnotations：以Annotation【】形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息 = " + annotation);
        }
    }

}
class A{
    public String hobby;
    public void hi(){}
    public A(){}
}
interface IA{}
interface IB{}
@Deprecated
class Person extends A implements IA,IB{
    //属性
    public String name;
    protected int age;
    String job;
    private double sal;
    //构造器
    public Person(){}
    public Person(String name){}
    private Person(String name,int age){}
    //方法
    public void m1(String name,int age,double sal){}
    protected void m2(){}
    void m3(){}
    private void m4(){}
}