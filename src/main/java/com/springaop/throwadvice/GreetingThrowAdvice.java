package com.springaop.throwadvice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//抛出增强
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("------Throw Exception-----");
        System.out.println("target class: " + target.getClass().getName());
        System.out.println("method class: " + method.getName());
        System.out.println("Exception message: " + e.getMessage());
    }

}