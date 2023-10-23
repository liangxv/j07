package com.woniuxy.p1;

import java.util.concurrent.atomic.AtomicInteger;

public class AppDemo1 {
    public static void main(String[] args) {
        Windows windows = new Windows();
        new Thread(windows, "窗口1").start();
        new Thread(windows, "窗口2").start();
        new Thread(windows, "窗口3").start();
    }
}

class Windows implements Runnable {

    AtomicInteger numberOfTickets = new AtomicInteger(10000);

    @Override
    public void run() {
        while (true) {
            int n = numberOfTickets.get();
            if (n > 0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (numberOfTickets.compareAndSet(n, n - 1)) {
                    System.out.println(Thread.currentThread().getName() + "卖了一张票,还剩" + numberOfTickets.get() + "张票");
                } else {
                    System.out.println("买票失败");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "卖完票了,还剩" + numberOfTickets.get() + "张票");
                break;
            }
        }

    }
}
