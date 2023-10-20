package com.woniuxy.p1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AppDemo2 {
    public static void main(String[] args) {
        ComputationalOperations computationalOperations = new ComputationalOperations();
        FutureTask<Integer> add = new FutureTask<>(computationalOperations);
        Thread thread = new Thread(add);
        thread.start();
        try {
            Integer i = add.get();
            System.out.println("结果是:" + i);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class ComputationalOperations implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        Long start = System.currentTimeMillis();
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
            Thread.sleep(10);

        }
        Long end = System.currentTimeMillis();
        System.out.println("运行了" + (end - start) + "毫秒");
        return sum;
    }
}