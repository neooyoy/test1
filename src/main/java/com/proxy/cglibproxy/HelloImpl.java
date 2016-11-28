package com.proxy.cglibproxy;

import com.proxy.Hello;

public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("hello! " + name);
    }

    @Override
    public void good(String name) {
        System.out.println("good moring! " + name);
    }
}