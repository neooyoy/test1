package com.innerclass;

/*为什么需要内部类
典型的情况是，内部类继承自某个类或实现某个接口，内部类的代码操作创建其的外围类的对象。
所以你可以认为内部类提供了某种进入其外围类的窗口。使用内部类最吸引人的原因是：
每个内部类都能独立地继承自一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
如果没有内部类提供的可以继承多个具体的或抽象的类的能力，一些设计与编程问题就很难解决。
从这个角度看，内部类使得多重继承的解决方案变得完整。接口解决了部分问题，而内部类有效地实现了“多重继承”*/

public class TestInnerclass{
    private String name;
    protected Integer age;
    private String salary;

    class Innerclass1 {
        public void test(){
            name = "Innerclass1";
            System.out.println(name);
        }
    }

    static class Innerclass2{
        private String name;

        public void test(){
            name = "Innerclass2";
            System.out.println(name);
        }
    }

    public static void main(String[] args){
        TestInnerclass testInnerclass = new TestInnerclass();
        testInnerclass.name = "1";
        TestInnerclass.Innerclass1 inner = testInnerclass.new Innerclass1();
        inner.test();

        TestInnerclass.Innerclass2 innerclass2 = new TestInnerclass.Innerclass2();
        innerclass2.test();

        Outerclass1 outerclass1 = new Outerclass1();
        outerclass1.test();

        Outerclass1.Outerclass2 outerclass2 = new Outerclass1.Outerclass2();
        outerclass2.test();

        Outerclass1.Outerclass3 outerclass3 = outerclass1.new Outerclass3();
        outerclass3.test();
    }
}

class Outerclass1{
    private String name;

    public void test(){
        name = "Outerclass1";
        System.out.println(name);
    }

    class Outerclass3{
        public void test(){
            name = "Outerclass3";
            System.out.println(name);
        }
    }

    static class Outerclass2{
        static String name = "Outerclass2";

        public void test(){
            System.out.println(name);
        }
    }
}