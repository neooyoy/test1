package com.designPattern.patterns.proxy.simpleProxy;

public class Proxy implements Subject {
    private Subject subject = null;

    public Proxy() {
        this.subject = new Proxy();
    }

    public Proxy(Object... objects) {

    }

    public void request() {
        this.subject.request();
    }

    private void before() {

    }

    private void after() {

    }

}
