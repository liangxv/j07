package com.woniuxy.pojo;

import java.util.*;


public class AppDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random =new Random();
        for (int i = 0; i < 10; i++) {
            int s = random.nextInt(12)+1;
            list.add(s);
        }

        Collections.sort(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);;

        int frequency = Collections.frequency(list, 6);
        System.out.println("frequency = " + frequency);

        List<Integer> newline = new ArrayList<>();
        newline.add(0);
        newline.add(0);
        newline.add(0);
        newline.add(0);
        newline.add(0);
        newline.add(0);
        newline.add(0);
        newline.add(0);
        newline.add(0);
        newline.add(0);



        Collections.copy(newline,list);

        System.out.println(newline);

        Collections.fill(list,2);
        System.out.println(list);

    }
}
