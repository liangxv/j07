package com.woniu.view;

import com.woniu.dao.ProductDao;
import com.woniu.dao.impl.ProductDaoImpl;
import com.woniu.pojo.Product;

import java.util.Scanner;

public class ProductView {
    private static final ProductDao productDao = new ProductDaoImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        operate();
    }

    // 产品菜单
    public static void menu() {
        System.out.println("-------------产品管理 -------------");
        System.out.println("按1.查询所有产品");
        System.out.println("按2.根据id查询产品");
        System.out.println("按3.新增产品");
        System.out.println("按4.根据id删除产品");
        System.out.println("按10.返回上一层");
    }

    // 操作
    public static void operate() {
        while (true) {
            menu();
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    getAllProduct();
                    break;
                case 2:
                    getAllProductById();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    deleteProduct();
                case 10:
                    return;
            }
        }
    }

    private static void deleteProduct() {
        int id = scanner.nextInt();
        productDao.deleteProduct(id);
    }

    private static void addProduct() {
        System.out.println("输入name");
        String name = scanner.next();
        System.out.println("输入描述");
        String describe = scanner.next();
        System.out.println("输入价格");
        double price = scanner.nextDouble();
        Product product = new Product(null,name,describe,price);
        productDao.addProduct(product);
    }

    private static void getAllProductById() {
        System.out.println("输入id");
        int id = scanner.nextInt();
        productDao.getAllProductById(id);
    }

    private static void getAllProduct() {
        productDao.findAll().forEach(System.out::println);

    }
}
