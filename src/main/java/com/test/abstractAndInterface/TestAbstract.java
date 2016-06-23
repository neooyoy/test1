package com.test.abstractAndInterface;

/**
 * 1.抽象类不一定含有抽象方法
 * 2.抽象方法必须为public或者protected，且不能有static， final等
 * 3.一个类继承了抽象类，必须实现抽象方法或者该类也必须为抽象类
 * 4.抽象类不能创建对象
 */
abstract class TestAbstract {
    //默认为public
    private int value;

    public void setValue(int value){
        this.value = value;
    }

    protected abstract void setValue();

}