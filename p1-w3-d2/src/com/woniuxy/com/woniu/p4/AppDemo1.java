package com.woniuxy.com.woniu.p4;

import java.util.ArrayList;
import java.util.Comparator;

public class AppDemo1 {
    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(1, "苹果", 5.0, "中国"));
        fruits.add(new Fruit(2, "香蕉", 3.0, "菲律宾"));
        fruits.add(new Fruit(3, "橙子", 4.0, "中国"));
        fruits.add(new Fruit(4, "草莓", 10.0, "美国"));
        fruits.add(new Fruit(5, "葡萄", 8.0, "意大利"));
        fruits.add(new Fruit(6, "西瓜", 12.0, "中国"));

        //查询价格最高的水果,并输出
        Fruit lastFruit = fruits.stream()
                .max(Comparator
                .comparingDouble(Fruit::getPrice))
                .orElse(null);
        System.out.println(lastFruit + "\n");

        //计算所有中国产水果的总价格
        double sumChinese = fruits.stream()
                .filter(fruit -> fruit.getOrigin().equals("中国"))
                .mapToDouble(Fruit::getPrice)
                .sum();
        System.out.println("中国产水果的总价格" + sumChinese + "\n");

        //查找所有低于8元的水果,并输出
        System.out.println("低于8元的水果");
        fruits.stream()
                .filter(fruit -> fruit.getPrice() < 8)
                .forEach(System.out::println);
        System.out.println();

        //将名称包含"瓜的水果价格增加10%"
        fruits.stream()
                .filter(fruit -> fruit.getName().contains("瓜"))
                .forEach(fruit -> {
                    double price = fruit.getPrice() * 1.1;
                    fruit.setPrice(price);
        });
        fruits.forEach(System.out::println);
        System.out.println();

        //删除价格高于9元的水
        fruits.removeIf(fruit -> fruit.getPrice() > 9);
        fruits.forEach(System.out::println);
        System.out.println();

        //列表按照价格升序排序
        fruits.stream()
                .sorted(Comparator.comparingDouble(Fruit::getPrice))
                .forEach(System.out::println);
        System.out.println();

        //查询所有美国产的水果
        fruits.stream()
                .filter(fruit -> fruit.getOrigin().equals("美国"))
                .forEach(System.out::println);
        System.out.println();

        //增加一个水果"梨子",价格为6元,并输出水果列表
        int id=7;
        String name="梨子";
        double price =6d;
        String origin="中国";
        fruits.add(new Fruit(id,name,price,origin));
        fruits.forEach(System.out::println);
        System.out.println();

        //查询名称是"香蕉"的水果价格
        fruits.stream()
                .filter(fruit -> fruit.getName().equals("香蕉"))
                .forEach(fruit -> {
                    System.out.println(fruit.getName()+"的价格是:"+fruit.getPrice());
        });

        //找到价格最近的水果
        Fruit firstFruit = fruits.stream()
                .min(Comparator.comparingDouble(Fruit::getPrice))
                .orElse(null);
        System.out.println(firstFruit);

    }
}