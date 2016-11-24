package com.springaop.advisor;

import com.springaop.introductionadvice.Apology;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();//创建代理工厂


//        DefaultPointcutAdvisor 默认切面 可扩展自定义切面
//        NameMatchMethodPointcut 根据方法名称进行匹配
//        StaticMethodMatcherPointcutAdvisor 用于匹配静态方法

        RegexpMethodPointcutAdvisor greetingAdvisor = new RegexpMethodPointcutAdvisor();
        greetingAdvisor.setAdvice(new GreetingAroundAdvice());
        //正则匹配：GreetingImpl类中以good开头的方法
        greetingAdvisor.setPattern("com.springaop.advisor.GreetingImpl.good.*");

        proxyFactory.setInterfaces(Apology.class);
        proxyFactory.setTarget(new GreetingImpl());//射入目标类对象
        proxyFactory.addAdvisor(greetingAdvisor);//切面

        //表明是否代理目标类，默认为false，也就是代理接口，此时spring用JDK动态代理；
        //如果为true， 那么Spring就用CGLib动态代理
        proxyFactory.setProxyTargetClass(true);

        //从代理工厂中获取代理Apology
        GreetingImpl greetingImpl = (GreetingImpl) proxyFactory.getProxy();
        greetingImpl.say("jack");

        greetingImpl.goodMorning("cj");
        greetingImpl.goodNight("rose");

        //将目标类强制向上转型为Apology 接口（这是引入增强带来的特性，也就是“接口动态实现”功能）
//        Apology apology = (Apology) greetingImpl;
//        apology.saySorry("jack111");

    }


}