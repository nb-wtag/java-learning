package com.sathat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.sathat.enums.Suit;

public class Player {
    
    private int id;
    private String name;
    private Team team;
    private boolean isHuman;
    private List<Card> cards;

    public Player(int id, String name, Team team, boolean isHuman){
        this.id = id;
        this.name = name;
        this.team = team;
        this.isHuman = isHuman;
        cards = new ArrayList<>();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    public boolean hasCard(Card card){
        return cards.contains(card);
    }

    public boolean hasSuit(Suit suit){
        return cards.stream()
                .filter(Objects::nonNull)
                .anyMatch(card -> card.getSuit() == suit);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public boolean isHuman() {
        return isHuman;
    }

    @Override
    public String toString() {
        return name;
    }

}
