package com.springaop.scan;

import com.springaop.advice.Greeting;

//@Component
public class GreetingImpl implements Greeting {
    @Override
    public void say(String name) {
        System.out.println("hello! " + name);
    }
}