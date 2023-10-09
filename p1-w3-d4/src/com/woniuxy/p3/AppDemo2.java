package com.woniuxy.p3;

import java.lang.reflect.Field;

public class AppDemo2 {
    public static void main(String[] args) throws Exception {
        Class<Car> c1 = Car.class;
        Car car = c1.getConstructor().newInstance();

        Field[] declaredField = c1.getDeclaredFields();

        for (Field field : declaredField) {
            System.out.println(field);
        }
        Field year = c1.getDeclaredField("year");
        year.setAccessible(true);
        year.set(car,2001);
        System.out.println(car);
    }
}
