package com.noniuxy.p1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AppDemo4 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdt =new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String data1 = sdt.format(date);
        System.out.println(data1);

        String bor = "1998-01-03 12:11:21:21";
        Date date2 = sdt.parse(bor);
        System.out.println(date2);
    }
}
