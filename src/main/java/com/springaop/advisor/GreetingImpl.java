package com.springaop.advisor;

import com.springaop.advice.Greeting;
import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {

    @Override
    public void say(String name) {
        System.out.println("hello!" + name);

        //抛出一个异常，看是否被拦截
//        throw new RuntimeException("error");
    }

    public void goodMorning(String name) {
        System.out.println("Good moring! " + name);
    }

    public void goodNight(String name) {
        System.out.println("Good night! " + name);
    }
}