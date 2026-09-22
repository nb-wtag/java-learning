package com.sathat.rules;

import java.util.ArrayList;
import java.util.List;

import com.sathat.enums.Suit;
import com.sathat.model.Card;
import com.sathat.model.Hand;
import com.sathat.model.Player;

public class CardPlayValidator {
    
    public boolean isValidPlay(Player player, Card card, Hand hand, Suit troop){
        //Playing card that isn't in hand
        if(!player.hasCard(card)){
            return false;
        }

        //First card of the game, all legal
        if(hand.getPlayedCards().isEmpty()){
            return true;
        }

        Card leadingCard = hand.getLeadingCard();
        Suit leadingSuit = hand.getLeadingSuit();

        //Playing 2 of hearts, player must play highest troop 
        //If doesn't have troop, can play anything
        if(leadingCard.isTwoOfHearts()){
            if(player.hasSuit(troop)){
                Card highestTroop = getHighestTroopCard(player, troop);

                return card.equals(highestTroop);
            }
            return true;
        }

        //Playing troop, players must play troop
        //If doesn't have troop, can play anything
        if(leadingSuit == troop){
            if(player.hasSuit(troop)){
                return card.getSuit() == troop;
            }
            return true;
        }

        //Normal card, must play leading suit
        if(player.hasSuit(leadingSuit)){
            return card.getSuit() == leadingSuit;
        }

        //Doesn't have leading suit, can play anything
        return true;
    }

    public List<Card> getLegalCards(Player player, Hand hand, Suit troop){
        List<Card> legalCards = new ArrayList<>();

        /**
        for(Card card : player.getCards()){
            if(isValidPlay(player, card, hand, troop)){
                legalCards.add(card);
            }
        }
         */

        //Using lambda
        player.getCards().forEach((card)->{
            if(isValidPlay(player, card, hand, troop)){
                legalCards.add(card);
            }
        });
        
        return legalCards;
    }


    public Card getHighestTroopCard(Player player, Suit troop) {

        Card highestTroop = null;

        for (Card card : player.getCards()) {

            if (card.getSuit() != troop) {
                continue;
            }

            if (highestTroop == null || card.getRank().getValue() > highestTroop.getRank().getValue()) {

                highestTroop = card;
            }
        }

        return highestTroop;
    }

    public Card getLowestCard(List<Card> cards) {

        Card lowest = null;

        for (Card card : cards) {

            if (lowest == null || card.getRank().getValue() < lowest.getRank().getValue()) {
                lowest = card;
            }
        }

        return lowest;
    }

}
