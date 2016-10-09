package com.designPattern.patterns.proxy.simpleProxy;

public class RealSubject implements Subject {
    public void request() {
        System.out.println("do something!");
    }
}