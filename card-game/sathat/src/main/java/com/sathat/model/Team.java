package com.sathat.model;

import java.util.ArrayList;
import java.util.List;

import com.sathat.enums.TeamId;

public class Team {
    
    private final TeamId id;
    private final List<Player> players;
    private int handsWon;

    public Team(TeamId id){
        this.id = id;
        this.players = new ArrayList<>();
        handsWon = 0; 
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void winHand(){
        handsWon++;
    }

    public boolean hasWonGame(){
        return handsWon == 7;
    }

    public TeamId getTeamId(){return id;}

    public List<Player> getPlayers(){return players;}

    public int getHandsWon(){return handsWon;}

    @Override 
    public String toString(){
        if(id == TeamId.TEAM_ONE){
            return "Team 1";
        } else{
            return "Team 2";
        }
    }
}
