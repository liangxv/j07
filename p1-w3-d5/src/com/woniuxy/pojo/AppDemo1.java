package com.woniuxy.pojo;

public class AppDemo1 {
    public static void main(String[] args) {
        Payment<Integer> cash = new CashPayment();
        cash.process(200);

        Payment<String> creditCard= new CreditCardPayment<>();
        creditCard.process("200");

        Payment<Double> mobilePayment = new MobilePayment<>();
        mobilePayment.process(25.22);
    }
}

interface Payment<T> {
    void process(T amount);
}

class CashPayment implements Payment<Integer>{

    @Override
    public void process(Integer amount) {
        System.out.println("使用现金支付"+amount+"元");
    }
}

class CreditCardPayment<T> implements Payment<T> {

    @Override
    public void process(T amount) {
        System.out.println("使用信用卡支付: " +amount+"元");
    }
}

class MobilePayment<T extends Number> implements Payment<T> {

    @Override
    public void process(T amount) {
        System.out.println("使用移动支付:"+amount+"元");
    }
}