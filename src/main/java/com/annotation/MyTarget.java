package com.annotation;

import java.lang.annotation.*;

//@Documented –注解是否将包含在JavaDoc中
//@Retention –什么时候使用该注解
//@Target? –注解用于什么地方
//@Inherited – 是否允许子类继承该注解

//Annotations只支持基本类型、String及枚举类型。

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyTarget{
    MyTargetEnum value() default MyTargetEnum.cj_test1;
    String name() default "";
}