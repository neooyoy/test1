package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

//Spring + AspectJ

public class GreetingAspectNoInject {

    @DeclareParents(value = "com.aspect.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;

    //第一个 "*" 表示方法的返回值是任意的
    //第二个 "*" 表示匹配该类中所有的方法
    //(..)表示方法的参数是任意的
//    @Around("execution(* com.springaop.advisor.GreetingImpl.*(..))")
    @Around("@annotation(com.annotation.MyTarget)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();

        Object result = pjp.proceed();

        after();

        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}