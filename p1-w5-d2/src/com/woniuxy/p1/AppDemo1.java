package com.woniuxy.p1;

public class AppDemo1 {
    public static void main(String[] args) {
        Windows windows = new Windows();
        new Thread(windows,"窗口1").start();
        new Thread(windows,"窗口2").start();
        new Thread(windows,"窗口3").start();
    }
}

class Windows implements Runnable{

    int numberOfTickets=100;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (numberOfTickets>0) {
                    numberOfTickets--;
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "卖了一张票,还剩"+numberOfTickets+"张票");
                }else {
                    System.out.println(Thread.currentThread().getName() + "卖完票了,还剩"+numberOfTickets+"张票");
                    break;
                }
            }
        }
    }
}
