package com.woniuxy.p7;

// ZooKeeper类，表示动物园管理员
public class ZooKeeper implements Worker {
    @Override
    public void feed(Animal animal) {
        System.out.println("动物园管理员正在喂食 " + animal.getName() + ".");
    }

    @Override
    public void clean(Animal animal) {
        System.out.println("动物园管理员正在清理 " + animal.getName() + ".");
    }
}
