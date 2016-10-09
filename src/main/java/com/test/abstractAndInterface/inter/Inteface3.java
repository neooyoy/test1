package com.test.abstractAndInterface.inter;

//重载：函数名相同，参数不同，仅此而已。
//重写（覆盖）:
//重写（覆盖）的规则：
//
//        1、重写方法的参数列表必须完全与被重写的方法的相同,否则不能称其为重写而是重载.
//
//        2、重写方法的访问修饰符一定要大于被重写方法的访问修饰符（public>protected>default>private）。
//
//        3、重写的方法的返回值必须和被重写的方法的返回一致；
//
//        4、重写的方法所抛出的异常必须和被重写方法的所抛出的异常一致，或者是其子类；
//
//        5、被重写的方法不能为private，否则在其子类中只是新定义了一个方法，并没s有对其进行重写。
//
//        6、静态方法不能被重写为非静态的方法（会编译出错）。
public class Inteface3 extends Class1 implements Inteface1, Inteface2 {
    @Override
    public void test1() {
        System.out.println("test1 !");
    }

    @Override
    public void test2() {
        System.out.println("test2 !");
    }

    //与上面的test构成重载
    public int test2(int x) {
        return 1;
    }

    //与父类Class1的show()构成重载
    public void show(String str) {
        System.out.println(str + "hello !");
    }
}