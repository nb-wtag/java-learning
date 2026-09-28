package com.sathat.model;

import java.util.ArrayList;
import java.util.List;

import com.sathat.enums.Suit;

public class Hand {

    private final Player leader;
    private final Suit troop;
    private final List<PlayedCard> playedCards;

    public Hand(Player leader, Suit troop){
        this.leader = leader;
        this.troop = troop;
        this.playedCards = new ArrayList<>();
    }

    public void addPlayedCards(Player player, Card card){
        playedCards.add(new PlayedCard(player, card));
    }

    public Player getLeader() {
        return leader;
    }

    public Suit getTroop() {
        return troop;
    }

    public List<PlayedCard> getPlayedCards() {
        return playedCards;
    }
    
    public Card getLeadingCard(){
        return playedCards.stream()
                .findFirst()
                .map(PlayedCard::getCard) //Optional .map method
                .orElse(null);
    }

    public Suit getLeadingSuit(){
        return playedCards.stream()
                .findFirst()
                .map(PlayedCard::getCard)
                .map(Card::getSuit)
                .orElse(null);
    }

    public boolean isComplete(){
        return playedCards.size() == 4;
    }
}
