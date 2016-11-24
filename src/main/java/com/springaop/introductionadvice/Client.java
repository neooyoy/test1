package com.springaop.introductionadvice;


import com.springaop.advice.Greeting;
import com.springaop.advice.GreetingAroundAdvice;
import com.springaop.advice.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;

public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();//创建代理工厂

        proxyFactory.setInterfaces(Apology.class);
        proxyFactory.setTarget(new GreetingImpl());//射入目标类对象
        proxyFactory.addAdvice(new GreetingIntroAdvice());//引入增强

        //表明是否代理目标类，默认为false，也就是代理接口，此时spring用JDK动态代理；
        //如果为true， 那么Spring就用CGLib动态代理
        proxyFactory.setProxyTargetClass(true);

        //从代理工厂中获取代理Apology
        GreetingImpl greetingImpl = (GreetingImpl) proxyFactory.getProxy();
        greetingImpl.say("jack");

        //将目标类强制向上转型为Apology 接口（这是引入增强带来的特性，也就是“接口动态实现”功能）
        Apology apology = (Apology) greetingImpl;
        apology.saySorry("jack");

    }


}