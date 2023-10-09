package com.woniuxy.p7;

public class ZooManagementSystem {
    public static void main(String[] args) {
        // 创建动物对象
        Animal lion = new Mammal("狮子", 5, "肉类");
        Animal parrot = new Bird("鹦鹉", 2, "种子");
        Animal snake = new Reptile("蛇", 3, "啮齿动物");

        // 创建管理员对象
        ZooKeeper zooKeeper = new ZooKeeper();

        // 管理员喂养和清理动物
        zooKeeper.feed(lion);
        zooKeeper.clean(lion);

        zooKeeper.feed(parrot);
        zooKeeper.clean(parrot);

        zooKeeper.feed(snake);
        zooKeeper.clean(snake);

        // 动物行为
        lion.makeSound();
        lion.move();

        parrot.makeSound();
        parrot.move();

        snake.makeSound();
        snake.move();
    }
}
