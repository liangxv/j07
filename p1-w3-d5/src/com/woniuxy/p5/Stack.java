package com.woniuxy.p5;

import java.util.LinkedList;

public class Stack <T>{
    LinkedList<T> list ;

    public Stack() {
        list =new LinkedList<>();
    }

    public void push(T element){
        list.add(element);
    }

    public T pop(){
        T pop = list.pop();
        return pop;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
