package com.designPattern.priciple.dip;

//依賴的三种写法
//1.构造函数传递依赖对象
//2.setter方法
//3.接口声明依赖对象

public class Driver implements IDriver {

    public void drive(ICar iCar) {
        iCar.run();
    }
}