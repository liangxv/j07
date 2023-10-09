package com.woniuxy.p5;

public enum Joker {
    JOKER_BLACK("🃏"), // 大小王中的黑色 Joker
    JOKER_RED("👲");   // 大小王中的红色 Joker

    private final String symbol;

    private Joker(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

