package com.woniuxy.p1;

public class AppDemo {
    public static void main(String[] args) {
        String a=addString("reger","asdasd");
        System.out.println(a);

    }
    private static String addString(String... str){
        String stitchString="";
        for (String s : str) {
            stitchString+=s;
        }
        return stitchString;
    }
}
