package com.woniuxy.p1;

import java.util.ArrayList;

public class MyList<T> {
    private ArrayList<T> list;

    public MyList() {
        list = new ArrayList<>();
    }

    public void add(T empty){
        list.add(empty);
    }

    public T get(int index){
        return list.get(index);
    }

    public int size(){
        return list.size();
    }
}
