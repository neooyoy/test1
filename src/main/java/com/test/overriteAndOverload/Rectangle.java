package com.test.overriteAndOverload;

public class Rectangle extends Shape{
    //与父类继承的getSizes()方法构成重载
    public int getSides(int i){
        return i;
    }
}