package com.woniuxy.p7;

// AbstractAnimal类，作为Animal接口的抽象实现
public abstract class AbstractAnimal implements Animal {
    private String name;
    private int age;
    private String food;

    public AbstractAnimal(String name, int age, String food) {
        this.name = name;
        this.age = age;
        this.food = food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getFood() {
        return food;
    }
}
