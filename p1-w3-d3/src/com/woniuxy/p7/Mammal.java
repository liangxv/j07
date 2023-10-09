package com.woniuxy.p7;

// Mammal类，表示哺乳动物
public class Mammal extends AbstractAnimal {
    public Mammal(String name, int age, String food) {
        super(name, age, food);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " 正在发出哺乳动物的声音。");
    }

    @Override
    public void move() {
        System.out.println(getName() + " 正在发出哺乳动物的声音。");
    }
}
