package com.woniuxy.p1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class AppDemo2 {
    public static void main(String[] args) {
        //1. 创建一个空的HashSet集合，命名为 libraryInventory ，用于存储图书馆中的图书信息。
        Set<String> libraryInventory = new HashSet<>();
        //2. 向 libraryInventory 中添加以下图书：《Java编程入门》、《Python深入浅出》、《数据 结构与算法》、《人类简史》。
        libraryInventory.add("《Java编程入门》");
        libraryInventory.add("《Python深入浅出》");
        libraryInventory.add("《数据 结构与算法》");
        libraryInventory.add("《人类简史》");
        //3. 使用 contains() 方法检查是否存在《Java编程入门》这本图书，并打印输出结果。
        System.out.println( "《Java编程入门》"+"是否存在"+libraryInventory.contains("《Java编程入门》"));
        //4. 使用 size() 方法获取 libraryInventory 集合中的图书数量，并打印输出结果。
        System.out.println("有"+libraryInventory.size()+"本数");
        //TreeSet：
        TreeSet<String> sortedInventory =new TreeSet<>();
        sortedInventory.add("1");
        sortedInventory.add("0");
        sortedInventory.add("data");
        sortedInventory.add("kotori");
        sortedInventory.add("aaaa");
        //1. 创建一个空的TreeSet集合，命名为 sortedInventory ，用于存储按照图书名称排序的图书信
        //息。
        System.out.println(sortedInventory);
        //2. 将 libraryInventory 中的所有图书名称添加到 sortedInventory 集合中。
        sortedInventory.addAll(libraryInventory);
        //3. 使用 isEmpty() 方法检查 sortedInventory 集合是否为空，并打印输出结果。
        boolean empty = sortedInventory.isEmpty();
        System.out.println("是否为空"+empty);
        //4. 打印输出 sortedInventory 集合中的所有图书名称，按照顺序排序
        System.out.println(sortedInventory);
    }
}
