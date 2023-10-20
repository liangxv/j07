package com.woniuxy.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppDemo3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Callable<Client>> orders =new ArrayList<>();
        orders.add(new OrderProcessingTasks("张三"));
        orders.add(new OrderProcessingTasks("李四"));
        orders.add(new OrderProcessingTasks("王五"));
        for (Callable<Client> order : orders) {
            Future<Client> future = service.submit(order);
            try {
                Client client = future.get();
                String clientString = client.toString();
                System.out.println("订单处理完成"+clientString);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        service.shutdown();
    }
}

class OrderProcessingTasks implements Callable<Client> {
    private String name;

    public OrderProcessingTasks(String name) {
        this.name = name;
    }

    @Override
    public Client call() throws Exception {
        String orderNumber= UUID.randomUUID().toString().replace("-", "");
        Client client = new Client(name,orderNumber,1);
        Thread.sleep(10);
        return client;
    }
}

class Client{
    private String name;
    private String orderNumber;
    private Integer orderStatus=0;

    public Client() {
    }

    public Client(String name, String orderNumber, Integer orderStatus) {
        this.name = name;
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return orderNumber
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置
     * @param orderNumber
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取
     * @return orderStatus
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置
     * @param orderStatus
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
