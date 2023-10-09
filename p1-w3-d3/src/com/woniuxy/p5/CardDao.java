package com.woniuxy.p5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardDao {

    List<GameCarder> carders = new ArrayList<>();

    public CardDao() {

        //创建普通卡片
        for (CardRank rank : CardRank.values()) {
            for (CardSuit suit : CardSuit.values()) {
                carders.add(new GameCarder(rank, suit));
            }
        }

        //创建大小王
        for (Joker joker : Joker.values()) {
            carders.add(new GameCarder(joker));
        }
    }

    public List<GameCarder> getCarders() {
        return carders;
    }

    public void setCarders(List<GameCarder> carders) {
        this.carders = carders;
    }

    //洗牌
    public void shuffle(List<GameCarder> carders) {
        Collections.shuffle(carders);
    }


    // 排序玩家手牌
    public Comparator<GameCarder> getComparator() {
        return (o1, o2) -> {
            if ((o1.getJoker() != null) && (o2.getJoker() != null)) {
                return o1.getJoker().compareTo(o2.getJoker());
            } else if ((o1.getJoker() == null) && (o2.getJoker() == null)) {
                if (o1.getCardRank().compareTo(o2.getCardRank()) == 0) {
                    return o1.getCardSuit().compareTo(o2.getCardSuit());
                } else {
                    return o1.getCardRank().compareTo(o2.getCardRank());
                }
            } else if (o1.getJoker() != null && o2.getJoker() == null) {
                return 1;
            } else {
                return -1;
            }

        };
    }


}
