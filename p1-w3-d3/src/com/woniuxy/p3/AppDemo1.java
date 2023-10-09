package com.woniuxy.p3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class AppDemo1 {

    public static void main(String[] args) throws IOException {
        Properties info =new Properties();
        System.out.println(info);

        InputStream inputStream =AppDemo1.class.getResourceAsStream("/book.properties");

        info.load(inputStream);

        System.out.println(info);

        info.setProperty("name","12345678");
        System.out.println(info.getProperty("price"));
        Set<String> keys =info.stringPropertyNames();
        for (String key : keys) {
            System.out.println("作者:"+key+",值:"+info.getProperty(key));
        }

        info.store(new FileWriter("book.properties"),"\u8fd9\u662f\u6ce8\u91ca");
    }
}
