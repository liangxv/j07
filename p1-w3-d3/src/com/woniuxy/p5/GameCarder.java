package com.woniuxy.p5;

public class GameCarder {
    CardRank cardRank;
    CardSuit cardSuit;
    Joker joker;

    public GameCarder(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public GameCarder(Joker joker) {
        this.joker = joker;
    }


    /**
     * 获取
     * @return cardRank
     */
    public CardRank getCardRank() {
        return cardRank;
    }

    /**
     * 设置
     * @param cardRank
     */
    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    /**
     * 获取
     * @return cardSuit
     */
    public CardSuit getCardSuit() {
        return cardSuit;
    }

    /**
     * 设置
     * @param cardSuit
     */
    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    /**
     * 获取
     * @return joker
     */
    public Joker getJoker() {
        return joker;
    }

    /**
     * 设置
     * @param joker
     */
    public void setJoker(Joker joker) {
        this.joker = joker;
    }

    public String toString() {
        if (joker != null){
            return joker.getSymbol();
        } else {
            return cardRank.getSymbol()+cardSuit.getSymbol();
        }
    }
}
