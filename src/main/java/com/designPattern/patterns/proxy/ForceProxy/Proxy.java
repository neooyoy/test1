package com.designPattern.patterns.proxy.ForceProxy;

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

    public Subject getProxy(){
        return this;
    }

}
