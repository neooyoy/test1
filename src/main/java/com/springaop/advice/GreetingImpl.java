package com.springaop.advice;

public class GreetingImpl implements Greeting {
    @Override
    public void say(String name) {
        System.out.println("hello! " + name);
    }
}