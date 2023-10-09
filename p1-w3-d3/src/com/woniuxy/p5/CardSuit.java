package com.woniuxy.p5;

public enum CardSuit {
    DIAMONDS("♦"),
    CLUBS("♣"),
    HEARTS("♥"),
    SPADES("♠");

    private final String symbol;

    private CardSuit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
