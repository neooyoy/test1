package com.springaop.advisor;

import com.springaop.introductionadvice.Apology;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

//@Component
public class GreetingAroundAdvice extends DelegatingIntroductionInterceptor implements MethodInterceptor, Apology {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        before();

        Object result = invocation.proceed();

        after();

        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    @Override
    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }
}