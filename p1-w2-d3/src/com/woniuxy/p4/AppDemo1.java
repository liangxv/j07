package com.woniuxy.p4;

//在主类中创建Animal、Cat和Dog的对象，分别调用它们的各自方法，以及输出其属性信息
public class AppDemo1 {
    public static void main(String[] args) {
        Cat cat = new Cat(5, "黑色");
        Dog dog = new Dog(6, 20);
        cat.eat();
        cat.catchMouse();
        System.out.println("猫的年龄"+cat.getAge()+","+"猫的颜色"+cat.getColor());

        dog.eat();
        dog.bark();
        System.out.println("狗的年龄"+dog.getAge()+","+"狗的体重"+dog.getWeight());


    }
}

//创建一个父类Animal（动物），其中包含一个方法eat()（吃东西）
//在Animal类中添加一个名为age的整型属性，用于表示动物的年龄。

class Animal {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal(int age) {
        this.age = age;
    }

    void eat() {
        System.out.println("动物吃");
    }
}

//创建两个子类：Cat（猫）和Dog（狗），它们分别继承自Animal类。
//在Cat类中添加一个名为color的字符串属性，用于表示猫的颜色。
//在Cat类中新增一个方法catchMouse()（抓老鼠）
class Cat extends Animal {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(int age, String color) {
        super(age);
        this.color = color;
    }

    void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}

//在Dog类中添加一个名为weight的浮点型属性，用于表示狗的体重。
//在Dog类中新增一个方法bark()（叫）。
class Dog extends Animal {
    private double weight;

    public Dog(int age, double weight) {
        super(age);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    void bark() {
        System.out.println("狗叫");
    }
}



