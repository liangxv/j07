package com.woniu.p1;

import java.util.Scanner;

public class AppDemo2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int startYear = 1900;
        int startMonth = 1;
        int startDay = 1;
        System.out.print("输入日期(yyyy-mm-dd): ");
        String date = scanner.next();
        String[] split = date.split("-");
        int endYear = Integer.parseInt(split[0]);
        int endMonth = Integer.parseInt(split[1]);
        int endDay = Integer.parseInt(split[2]);

        int daysBetween = calculateDaysBetween(startYear, startMonth, startDay, endYear, endMonth, endDay);


        int week = daysBetween % 7;

        System.out.println(endYear + "年" + endMonth + "月" + endDay + "日是星期" + week);


    }

    /**
     * 计算两个日期之间的天数。
     *
     * @param startYear  开始年份
     * @param startMonth 开始月份
     * @param startDay   开始日期
     * @param endYear    结束年份
     * @param endMonth   结束月份
     * @param endDay     结束日期
     * @return 两个日期之间的天数
     */
    public static int calculateDaysBetween(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        int days = 0;

        // 每个月的天数
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 计算整年的天数
        for (int year = startYear; year < endYear; year++) {
            days += isLeapYear(year) ? 366 : 365;
        }

        // 计算结束月份之前的天数
        for (int month = 1; month < endMonth; month++) {
            days += daysInMonth[month - 1];
            if (month == 2 && isLeapYear(endYear)) {
                days += 1; // 闰年的二月加一天
            }
        }

        // 打印结束月份的日历
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        int startWeek = (days + 1) % 7;
        for (int i = 0; i < startWeek; i++) {
            System.out.print(" \t");
        }
        for (int i = 0; i < daysInMonth[endMonth]; i++) {
            System.out.print(i + 1 + "\t");
            startWeek++;
            if ((startWeek % 7) == 0) {
                System.out.println();
            }

        }
        System.out.println();

        // 添加剩余的天数
        days += endDay;


        return days;
    }

    /**
     * 检查是否是闰年。
     *
     * @param year 要检查的年份
     * @return 如果是闰年则返回true，否则返回false
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
