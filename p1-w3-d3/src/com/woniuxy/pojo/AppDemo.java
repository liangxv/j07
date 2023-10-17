package com.woniuxy.pojo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppDemo {
    public static void main(String[] args) {
        try (InputStreamReader in = new InputStreamReader(Files.newInputStream(Paths.get("F:\\workspace\\j07\\textfile.txt")), StandardCharsets.UTF_8);
             OutputStreamWriter out = new OutputStreamWriter(Files.newOutputStream(Paths.get("F:\\workspace\\j07\\textfile_GBK.txt")), "GBK")) {
            char[] buff = new char[1024];
            int length;
            while ((length = in.read(buff)) != -1) {
                out.write(buff, 0, length);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
