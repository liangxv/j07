package com.woniuxy.p1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AppDemo1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("F:\\Arch\\rootfs.tar.gz"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("F:\\Arch\\rootfs.tar.gz1"))) {
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时: " + (end - start) + "毫秒");
    }
}
