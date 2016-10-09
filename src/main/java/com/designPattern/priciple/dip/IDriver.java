package com.designPattern.priciple.dip;

//模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生的
//接口和抽象不依赖实现类
//实现类依赖接口或抽象类

//司机接口类依赖接口类车
public interface IDriver {
    public void drive(ICar iCar);
}