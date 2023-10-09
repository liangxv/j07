package com.woniuxy.p1;

public class AppDemo3 {
    public static void main(String[] args) {
        int i = 1;
        i++;
        System.out.println(i); //i=i+1;
        i--;
        System.out.println(i); //i=i-1;

        int m = 8;

        System.out.println("m=" + (m++)); //先用后加 m=m+1
        System.out.println(m);

        System.out.println("m=" + (++m)); //先加后用 m=m+1
        System.out.println(m);
    }
}
