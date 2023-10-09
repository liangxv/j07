package com.woniuxy.p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AppDemo2 {
    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods(1, "手机", 2999.99, 28));
        goodsList.add(new Goods(2, "电视", 3999.99, 15));
        goodsList.add(new Goods(3, "电脑", 5999.99, 38));
        goodsList.add(new Goods(4, "耳机", 999.99, 18));
        goodsList.add(new Goods(5, "平板", 2999.99, 5));

        for (Goods goods : goodsList) {
            System.out.println(goods);
        }

        System.out.println();

        goodsList.sort((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
        System.out.println("按价格排序");
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
        System.out.println("价格最高的商品" + goodsList.get(goodsList.size() - 1));
        goodsList.sort(((o1, o2) -> o1.getStock() - o2.getStock()));
        System.out.println("商品库存最少的商品" + goodsList.get(0));

        System.out.print("请输入库存数量: ");
        Scanner scanner = new Scanner(System.in);
        int stock = scanner.nextInt();
        for (Goods goods : goodsList) {
            if (goods.getStock() <= stock) {
                System.out.println("库存小于" + stock + "的商品" + goods);
            }
        }
        int sum = 0;
        for (Goods goods : goodsList) {
            sum += goods.getStock();
        }
        System.out.println("总库存数量" + sum);
    }
}

class Goods {
    int id;
    String name;
    double price;
    int stock;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Goods() {
    }

    public Goods(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (Double.compare(goods.price, price) != 0) return false;
        if (stock != goods.stock) return false;
        return Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + stock;
        return result;
    }
}