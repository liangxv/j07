package com.woniuxy.p6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TravelPlan {
    String destination();
    String startDate();
    String endDate();
    String transportation() default "地铁";

}
