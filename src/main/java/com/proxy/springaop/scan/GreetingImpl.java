package com.proxy.springaop.scan;

import com.proxy.springaop.Greeting;
import org.springframework.stereotype.Component;

//@Component
public class GreetingImpl implements Greeting {
    @Override
    public void say(String name) {
        System.out.println("hello! " + name);
    }
}