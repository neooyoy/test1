package com.springaop.scan;


import com.springaop.advice.Greeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/spring.xml");

        //从代理工厂中获取代理
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.say("jack");
    }

}