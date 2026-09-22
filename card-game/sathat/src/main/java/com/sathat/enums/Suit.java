package com.sathat.enums;

public enum Suit {
    
    HEARTS(1,"Hearts", "♥"),
    DIAMONDS(2,"Diamonds", "♦"),
    CLUBS(3,"Clubs", "♣"),
    SPADES(4,"Spades", "♠");

    private final int order;
    private final String displayName;
    private final String symbol;

    private Suit(int order, String displayName, String symbol){
        this.order = order;
        this.displayName = displayName;
        this.symbol = symbol;
    }

    public int getOrder(){ return order;}

    public String getDisplayName(){ return displayName;}

    public String getSymbol(){ return symbol;}

    @Override 
    public String toString(){
        return displayName;
    }
}
