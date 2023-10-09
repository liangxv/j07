package com.woniuxy.p4;

import java.util.ArrayList;
import java.util.Iterator;

public class AppDemo1 {
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(60);
        list.add(5);
        list.add(30);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            next*=2;
            System.out.println("next = " + next);
            if (next>50){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
