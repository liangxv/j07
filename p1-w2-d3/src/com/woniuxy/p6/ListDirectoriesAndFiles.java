package com.woniuxy.p6;

import java.io.File;

public class ListDirectoriesAndFiles {
    public static void main(String[] args) {
        String basePath = "E:\\Genshin Impact\\Genshin Impact Game";
        listDirectoriesAndFiles(new File(basePath), 0, "");
    }

    public static void listDirectoriesAndFiles(File directory, int depth, String prefix) {
        File[] files = directory.listFiles();

        if (files != null) {
            int count = 0;
            for (File file : files) {
                count++;
                for (int i = 0; i < depth - 1; i++) {
                    System.out.print("|  "); // 缩进两个空格
                }
                if (depth > 0) {
                    System.out.print("|--");
                }
                System.out.println(file.getName());

                if (file.isDirectory()) {
                    if (count == files.length) {
                        listDirectoriesAndFiles(file, depth + 1, prefix + "   ");
                    } else {
                        listDirectoriesAndFiles(file, depth + 1, prefix + "|  ");
                    }
                }
            }
        }
    }
}
