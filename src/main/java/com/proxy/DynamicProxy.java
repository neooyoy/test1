package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();

        Object result = method.invoke(target, args);

        after();

        return result;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }


    public static void main(String[] args) {
        /*DynamicProxy dynamicProxy = new DynamicProxy(new Hello(){
            @Override
            public void say(String name) {
                System.out.println("hello! " + name);
            }
        });*/

        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());

        Hello helloProxy = dynamicProxy.getProxy();
        System.out.println(helloProxy.getClass().getName());

        helloProxy.say("jack");

        helloProxy.say("cj");
    }
}