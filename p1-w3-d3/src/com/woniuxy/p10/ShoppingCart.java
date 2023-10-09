package com.woniuxy.p10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "商品编号: " + id + ", 商品名称: " + name + ", 单价: " + price + ", 数量: " + quantity + ", 总价: " + getTotalPrice();
    }
}

public class ShoppingCart {
    private List<Product> cart;
    private Scanner scanner;

    public ShoppingCart() {
        cart = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("购物车为空.");
        } else {
            for (Product product : cart) {
                System.out.println(product);
            }
        }
    }

    public void removeProduct(int productId) {
        Iterator<Product> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == productId) {
                iterator.remove();
                System.out.println("商品已移除: " + product.getName());
                return;
            }
        }
        System.out.println("找不到商品编号为 " + productId + " 的商品");
    }

    public void updateQuantity(int productId, int newQuantity) {
        for (Product product : cart) {
            if (product.getId() == productId) {
                product.setQuantity(newQuantity);
                System.out.println("商品数量已更新: " + product.getName());
                return;
            }
        }
        System.out.println("找不到商品编号为 " + productId + " 的商品");
    }

    public void clearCart() {
        if (cart.isEmpty()) {
            System.out.println("购物车已经是空的.");
        } else {
            cart.clear();
            System.out.println("购物车已清空");
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getTotalPrice();
        }
        return totalPrice;
    }

    public void updateProductInfo(int productId, String newName, double newPrice) {
        for (Product product : cart) {
            if (product.getId() == productId) {
                product.setName(newName);
                product.setPrice(newPrice);
                System.out.println("商品信息已更新: " + product.getName());
                return;
            }
        }
        System.out.println("找不到商品编号为 " + productId + " 的商品");
    }

    public void findProduct(String keyword) {
        for (Product product : cart) {
            if (product.getName().equalsIgnoreCase(keyword)) {
                System.out.println("找到匹配商品: " + product);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // 添加商品
        shoppingCart.addProduct(new Product(1, "手机", 599.99, 2));
        shoppingCart.addProduct(new Product(2, "电视", 899.99, 1));
        shoppingCart.addProduct(new Product(3, "笔记本电脑", 1299.99, 3));

        // 查看购物车
        System.out.println("购物车中的商品:");
        shoppingCart.viewCart();

        // 删除商品
        System.out.print("请输入要删除的商品编号: ");
        int productIdToRemove = shoppingCart.scanner.nextInt();
        shoppingCart.removeProduct(productIdToRemove);
        shoppingCart.viewCart();

        // 修改商品数量
        System.out.print("请输入要修改数量的商品编号: ");
        int productIdToUpdate = shoppingCart.scanner.nextInt();
        System.out.print("请输入新的数量: ");
        int newQuantity = shoppingCart.scanner.nextInt();
        shoppingCart.updateQuantity(productIdToUpdate, newQuantity);
        shoppingCart.viewCart();

        // 清空购物车
        System.out.print("是否清空购物车？(y/n): ");
        String clearChoice = shoppingCart.scanner.next().toLowerCase();
        if (clearChoice.equals("y")) {
            shoppingCart.clearCart();
        }

        // 结算购物车
        double total = shoppingCart.calculateTotalPrice();
        System.out.println("购物车总价: $" + total);

        // 修改商品信息
        System.out.print("请输入要修改信息的商品编号: ");
        int productIdToUpdateInfo = shoppingCart.scanner.nextInt();
        System.out.print("请输入新的商品名称: ");
        String newName = shoppingCart.scanner.next();
        System.out.print("请输入新的商品价格: ");
        double newPrice = shoppingCart.scanner.nextDouble();
        shoppingCart.updateProductInfo(productIdToUpdateInfo, newName, newPrice);
        shoppingCart.viewCart();

        // 查找商品
        System.out.print("请输入要查找的商品名称或关键字: ");
        String keyword = shoppingCart.scanner.next();
        shoppingCart.findProduct(keyword);

        // 关闭输入
        shoppingCart.scanner.close();
    }
}

