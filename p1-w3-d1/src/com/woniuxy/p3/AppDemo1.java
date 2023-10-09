package com.woniuxy.p3;

public class AppDemo1 {

    public static void main(String[] args) {

        seasonalActivity p1 = new seasonalActivity(Season.SPRING, "春游");
        System.out.println(p1.getSeason() + "我喜欢" + p1.getActivity());

        seasonalActivity p2 = new seasonalActivity(Season.SUMMER, "游泳");
        System.out.println(p2.getSeason() + "我喜欢" + p2.getActivity());

        seasonalActivity p3 = new seasonalActivity(Season.AUTUMN, "晨跑");
        System.out.println(p3.getSeason() + "我喜欢" + p3.getActivity());

        seasonalActivity p4 = new seasonalActivity(Season.WINTER, "瑜伽");
        System.out.println(p4.getSeason() + "我喜欢" + p4.getActivity());

    }
}

enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}

class seasonalActivity {
    private Season season;
    private String activity;

    public seasonalActivity(Season season, String activity) {
        this.season = season;
        this.activity = activity;
    }

    public Season getSeason() {
        return season;
    }

    public String getActivity() {
        return activity;
    }
}