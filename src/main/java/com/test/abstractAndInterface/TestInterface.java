package com.test.abstractAndInterface;

/**
 * 抽象类是对一种事物的抽象，即对类抽象，而接口是对行为的抽象。
 * 抽象类是对整个类整体进行抽象，包括属性、行为，但是接口却是对类局部（行为）进行抽象。
 */

/**
 * 继承是一个 "是不是"的关系，而 接口 实现则是 "有没有"的关系。
 */

import com.test.abstractAndInterface.testDoor.TestFatherInterface;

/**
 * 1.接口中的方法必须都是抽象方法
 * 2.接口中的变量会被隐式的指定为public static final
 * 3.方法只能为public (abstract)，不能用private, static, final, protected关键字
 * 4.接口中不能有静态代码块和静态方法
 * 5.一个类只能继承一个抽象类，却可以实现多个接口
 */
public interface TestInterface extends TestFatherInterface{
     public static final String name = "testInterface";

     public abstract void setName();



}