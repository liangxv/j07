package com.woniuxy.p7;

// Reptile类，表示爬行动物
public class Reptile extends AbstractAnimal {
    public Reptile(String name, int age, String food) {
        super(name, age, food);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " 正在嘶嘶地像爬行动物一样。");
    }

    @Override
    public void move() {
        System.out.println(getName() + " 正在爬行像爬行动物一样。");
    }
}
