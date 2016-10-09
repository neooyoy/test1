package com.designPattern.priciple.dip;

//场景类
public class Client {
    public static void main(String[] args) {
        IDriver zhangsan = new Driver();

        //wrong
//      ICar car = new ICar();

        //right , 以下实现了接口类ICar
        ICar car = new ICar() {
            @Override
            public void run() {
                System.out.println("自定义车启动，开始。。。");
            }
        };
        zhangsan.drive(car);

        ICar bmw = new BMW();

        //张三开宝马车
        zhangsan.drive(bmw);
    }
}