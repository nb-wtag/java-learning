package com.sathat.service;

import java.util.Comparator;
import java.util.List;

import com.sathat.model.Card;
import com.sathat.model.Deck;
import com.sathat.model.Player;

public class DealService {

    public void dealInitialFive(List<Player> players, Deck deck) {
        dealCards(players, deck, 5);
    }

    public void dealRemainingCards(List<Player> players, Deck deck) {
        dealCards(players, deck, 4);

        dealCards(players, deck, 4);
    }

    // Using lambdas to sort cards
    public void sortCards(List<Player> players) {

        players.forEach((player) -> {
            player.getCards().sort(
                    Comparator.comparingInt((Card card) -> card.getSuit().getOrder())
                            .thenComparingInt(card -> card.getRank().getValue()));
        });
    }

    private void dealCards(List<Player> players, Deck deck, int numberOfCards) {

        for (Player player : players) {
            for (int cardNumber = 0; cardNumber < numberOfCards; cardNumber++) {
                player.addCard(deck.draw());
            }
        }
    }
}
