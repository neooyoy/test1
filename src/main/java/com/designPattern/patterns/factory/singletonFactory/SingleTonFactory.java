package com.designPattern.patterns.factory.singletonFactory;

import java.lang.reflect.Constructor;

public class SingleTonFactory {
    public static SingleTon singleTon;

    static {
        try{
            Class<?> c1 = Class.forName(SingleTon.class.getName());
            Constructor constructor = c1.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleTon = (SingleTon) constructor.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}