package com.sathat.rules;

import com.sathat.enums.Suit;
import com.sathat.model.Card;
import com.sathat.model.Hand;
import com.sathat.model.PlayedCard;
import com.sathat.model.Player;

public class HandWinnerCalculator {

    public Player determineWinner(Hand hand, Suit troop) {
        return determineWinningPlayedCard(hand, troop).getPlayer();
    }

    public PlayedCard determineWinningPlayedCard(Hand hand, Suit troop) {

        if (!hand.isComplete()) {
            throw new IllegalStateException("Cannot determine winner until all four players have played.");
        }

        return findWinningPlayedCard(hand, troop);
    }

    public PlayedCard determineCurrentWinner(Hand hand, Suit troop) {

        if (hand.getPlayedCards().isEmpty()) {
            return null;
        }

        return findWinningPlayedCard(hand, troop);
    }

    private PlayedCard findWinningPlayedCard(Hand hand, Suit troop) {

        PlayedCard winner = hand.getPlayedCards().get(0);

        for (int i = 1; i < hand.getPlayedCards().size(); i++) {

            PlayedCard challenger = hand.getPlayedCards().get(i);

            if (beats(challenger.getCard(), winner.getCard(), troop, hand.getLeadingSuit())) {
                winner = challenger;
            }
        }

        return winner;
    }
    
    public boolean beats(Card challenger, Card currentWinner, Suit troop, Suit leadingSuit){
        //2 of hearts beats everything
        if(challenger.isTwoOfHearts()){
            return !currentWinner.isTwoOfHearts();
        }

        if(currentWinner.isTwoOfHearts()){
            return false;
        }

        boolean challengerIsTroop = challenger.getSuit() == troop;
        boolean winnerIsTroop = currentWinner.getSuit() == troop;

        //Troop beats normal
        if(challengerIsTroop && !winnerIsTroop){
            return true;
        }

        if(!challengerIsTroop && winnerIsTroop){
            return false;
        }

        //Both troop
        if(challengerIsTroop && winnerIsTroop){
            return challenger.getRank().getValue() > currentWinner.getRank().getValue();
        }

        //Neither troop
        boolean challengerHasLeadingSuit = challenger.getSuit() == leadingSuit;
        boolean winnerHasLeadingSuit = currentWinner.getSuit() == leadingSuit;

        if(challengerHasLeadingSuit && !winnerHasLeadingSuit){
            return true;
        }

        if(!challengerHasLeadingSuit && winnerHasLeadingSuit){
            return false;
        }

        //Both have suit
        if(challengerHasLeadingSuit && winnerHasLeadingSuit){
            return challenger.getRank().getValue() > currentWinner.getRank().getValue();
        }

        return false;
    }

}
