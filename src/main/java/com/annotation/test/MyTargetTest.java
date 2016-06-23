package com.annotation.test;

import com.annotation.MyTarget;
import com.annotation.MyTargetEnum;

import java.lang.reflect.Method;

@MyTarget
public class MyTargetTest{

    @MyTarget(name="cj_test", value = MyTargetEnum.cj_test2)
    public void test(){
        System.out.println(MyTargetEnum.cj_test2);
    }

    public static void main(String[] args){
        try{
            Method method = MyTargetTest.class.getMethod("test");
            if (method.isAnnotationPresent(MyTarget.class)){
                System.out.println(method.getAnnotation(MyTarget.class));
                MyTarget myTarget = method.getAnnotation(MyTarget.class);
                System.out.println(myTarget.name());
                System.out.println(myTarget.value());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}