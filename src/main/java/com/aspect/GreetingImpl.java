package com.aspect;

import com.annotation.MyTarget;
import com.springaop.advice.Greeting;

//@Component
public class GreetingImpl implements Greeting {

    @MyTarget
    @Override
    public void say(String name) {
        System.out.println("hello! " + name);
    }
}