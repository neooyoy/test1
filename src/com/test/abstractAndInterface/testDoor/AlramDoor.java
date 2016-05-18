package com.test.abstractAndInterface.testDoor;

/**
 * open() 、close()和alarm()根本就属于两个不同范畴内的行为，
 * open()和close()属于门本身固有的行为特性，而alarm()属于延伸的附加行为
 */
public class AlramDoor extends AbstractDoor implements Alram{
    //实现父类的抽象方法
    public void open(){
        //....
    }

    public void close(){
        //...
    }

    //.................
    //实现的接口方法
    public void alram(){

    }
}