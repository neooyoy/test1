package com.test;

/**
 * java 方法参数：采用值传递,及方法得到的是所有参数的一个拷贝，
 * 不能修改传递给它的任何参数变量的内容
 */

import com.test.initializationBlock.Employee;

/**
 * 1. 一个方法不能改变基本数据类型的参数（即数值型和布尔型）
 * 2. 一个方法可以改变一个对象参数的状态
 * 3. 一个方法不能让对象参数引用一个新的对象
 */
public class TestFunctionParams{
    public static void setValue(Integer x){
        x = x+3;
    }

    public static void raiseSalary(Employee x){
        System.out.println(x.getSalary());
        x.setSalary(x.getSalary() + 300);
    }

    /**
     * x和y为Employee对象引用的拷贝，此方法交换的是这两个拷贝，因此cj, zhangsan并没有改变
     * @param x
     * @param y
     */
    public static void swapEmpolyee(Employee x, Employee y){
        //x refers to cj, y refers to zhangsan
        Employee temp = x;
        x = y;
        y = temp;

        //now x refers to zhangsan, y refers to cj
        //方法结束时x和y被丢弃了
    }

    public static void main(String[] args){
        Integer x = 3;
        setValue(x);

        System.out.println(x);

        Employee cj = new Employee("cj", 10, 1000);
        Employee zhangsan = new Employee("zhangsan", 20, 5000);

        raiseSalary(cj);
        System.out.println(cj.getSalary());

        swapEmpolyee(cj, zhangsan);

        System.out.println(cj.getName() + "," + cj.getSalary());
        System.out.println(zhangsan.getName() + "," +zhangsan.getSalary());

        Employee test = new Employee(300);
        System.out.println(test.getName() + "," +test.getAge() + "," +test.getSalary() + "," +test.getId());

    }
}