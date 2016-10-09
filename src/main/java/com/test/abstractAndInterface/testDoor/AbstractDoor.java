package com.test.abstractAndInterface.testDoor;

/**
 * open()和close()属于门本身固有的行为特性
 */
public abstract class AbstractDoor{
    public abstract void open();

    public abstract void close();

    /* wrong : public static void main(String[] agrs){
        AbstractDoor abstractDoor = new AbstractDoor();
    }*/
}