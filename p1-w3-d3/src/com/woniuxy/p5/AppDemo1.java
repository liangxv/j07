package com.woniuxy.p5;

import java.util.ArrayList;
import java.util.List;

public class AppDemo1 {
    public static void main(String[] args) {

        CardDao cardDao = new CardDao();
        List<GameCarder> carders = cardDao.getCarders();

        System.out.println(carders);

        System.out.println("洗牌");

        cardDao.shuffle(carders);
        System.out.println(carders);

        System.out.println("发牌");
        List<GameCarder> play1 = new ArrayList<>();
        List<GameCarder> play2 = new ArrayList<>();
        List<GameCarder> play3 = new ArrayList<>();

        for (int i = 0; i < (carders.size()-3); i++) {
            if (i % 3 == 0) {
                play1.add(carders.get(i));
            } else if (i % 3 == 1) {
                play2.add(carders.get(i));
            } else {
                play3.add(carders.get(i));
            }

        }
        //// 排序玩家手牌
        play1.sort(cardDao.getComparator());
        play2.sort(cardDao.getComparator());
        play3.sort(cardDao.getComparator());

        System.out.println("玩家一个的牌: " + play1);
        System.out.println("玩家二个的牌: " + play2);
        System.out.println("玩家三个的牌: " + play3);
    }
}
