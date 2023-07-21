package com.hspedu.chapter12.exception;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TryCatchExercise03 {
    public static int method(){
        int i = 1;
        try {
            i++;//2
            String[] names = new String[3];
            if (names[1].equals("tom")){
                System.out.println(names[1]);
            }else{
                names[3] = "hapedu";
            }
            return 1;
        }catch (ArrayIndexOutOfBoundsException e){
            return 2;
        }catch (NullPointerException e){
            return ++i;//3=>temp = 3 ;return
        }finally {
            ++i;//4
            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
