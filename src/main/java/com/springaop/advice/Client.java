package com.springaop.advice;


import org.springframework.aop.framework.ProxyFactory;

public class Client {

    /*public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();//创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());//射入目标类对象
        proxyFactory.addAdvice(new GreetingBeforeAdvice());//添加前置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());//添加后知增强

        //从代理工厂中获取代理
        Greeting greeting = (Greeting) proxyFactory.getProxy();

        greeting.say("jack");
    }*/

    /*public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();//创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());//射入目标类对象
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());//添加前置增强

        //从代理工厂中获取代理
        Greeting greeting = (Greeting) proxyFactory.getProxy();

        greeting.say("jack");
    }*/

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();//创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());//射入目标类对象
        proxyFactory.addAdvice(new GreetingAroundAdvice());//添加前置增强

        //从代理工厂中获取代理
        Greeting greeting = (Greeting) proxyFactory.getProxy();

        greeting.say("jack");
    }


}