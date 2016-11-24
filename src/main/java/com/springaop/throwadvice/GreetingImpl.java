package com.springaop.throwadvice;

import com.springaop.advice.Greeting;
import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {

    @Override
    public void say(String name) {
        System.out.println("hello!" + name);

        //抛出一个异常，看是否被拦截
        throw new RuntimeException("error");
    }
}