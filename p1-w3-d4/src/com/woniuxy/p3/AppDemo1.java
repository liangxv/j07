package com.woniuxy.p3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AppDemo1 {
    public static void main(String[] args) throws Exception {
        Class<Car> c1 = Car.class;
        Car car = new Car();
        Class<? extends Car> c2 = car.getClass();
        Class<?> c3 = Class.forName("com.woniuxy.p3.Car");

        Constructor<?>[] constructors = c1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor<?> constructor = c3.getConstructor(String.class, String.class, int.class);
        Car o = (Car) constructor.newInstance("奔驰", "黑色", 20011);
        System.out.println(o);
        o.stop("ds");
        Method[] methods = c3.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        Method[] m1 = c3.getDeclaredMethods();
        for (Method method : m1) {
            System.out.println(method);
        }

        Method stop = c3.getMethod("stop", String.class);

        Object o1 = stop.invoke(o, "我");

        Method startEngine = c3.getDeclaredMethod("startEngine");
        startEngine.setAccessible(true);

        String invoke = (String) startEngine.invoke(o);
        System.out.println(startEngine.getName()+"的值是"+invoke);
    }
}
