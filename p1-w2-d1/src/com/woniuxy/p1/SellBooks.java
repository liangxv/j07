package com.woniuxy.p1;

public class SellBooks {
    String title;
    String author;
    String price;

    public void sell (){
        System.out.println("卖出了"+title+"价格是："+price);
        System.out.println(author);
    }

    @Override
    public String toString() {
        return "书名:"+title+"\t作者:"+author+"\t价格:"+price;
    }
}
