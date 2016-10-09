package com.designPattern.patterns.proxy.ForceProxy;

public class RealSubject implements Subject {
    private Subject proxy = null;

    public Subject getProxy() {
        this.proxy = new Proxy("zhangsan");
        return this.proxy;
    }

    private boolean isProxy() {
        if (this.proxy != null) {
            return false;
        } else {
            return true;
        }
    }

    public void request() {
        if (isProxy()) {
            System.out.println("do something!");
        } else {
            System.out.println("请使用代理!");
        }
    }
}