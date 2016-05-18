package com.test.overriteAndOverload;

public class Triangle extends Shape{
    //重写父类的getSizes方法
    @Override
    public int getSides(){
        return 3;
    }
}