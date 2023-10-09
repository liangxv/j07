package com.woniuxy.p7;

// Bird类，表示鸟类
public class Bird extends AbstractAnimal {
    public Bird(String name, int age, String food) {
        super(name, age, food);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " 正在像鸟一样唧唧喳喳");
    }

    @Override
    public void move() {
        System.out.println(getName() + " 正在像鸟一样飞翔。");
    }
}
