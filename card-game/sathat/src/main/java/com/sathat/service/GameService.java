package com.sathat.service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sathat.enums.GameStatus;
import com.sathat.enums.Suit;
import com.sathat.model.Deck;
import com.sathat.model.Game;
import com.sathat.model.Player;
import com.sathat.model.Team;

public class GameService {

        private final DealService dealService;
        private final HandService handService;

        private final Random random;
        private final Scanner scanner;

        public GameService(DealService dealService, HandService handService, Scanner scanner) {
                this.dealService = dealService;
                this.handService = handService;
                this.scanner = scanner;
                this.random = new Random();
        }

        public void startGame(Game game) {

                game.setStatus(GameStatus.DEALING);

                printWelcome();

                game.createDeck(new Deck());
                Player troopChooser = chooseTroopPlayer(game.getPlayers());

                game.setTroopChooser(troopChooser);

                System.out.println(troopChooser.getName() + " will choose the troop.");

                dealService.dealInitialFive(game.getPlayers(), game.getDeck());

                System.out.println();
                System.out.println("First five cards dealt.");

                Suit troop = chooseTroop(troopChooser);

                game.setTroop(troop);
                System.out.println();
                System.out.println("Troop: " + troop.getDisplayName() + " " + troop.getSymbol());

                dealService.dealRemainingCards(game.getPlayers(), game.getDeck());
                dealService.sortCards(game.getPlayers());

                System.out.println();
                System.out.println("All cards have been dealt.");

        
                game.setCurrentPlayer(troopChooser);
                game.setStatus(GameStatus.IN_PROGRESS);
                playGame(game);
                game.setStatus(GameStatus.FINISHED);
                printFinalResult(game);
        }

        private void playGame(Game game) {

                while (!game.isFinished()) {
                        Player leader = game.getCurrentPlayer();
                        Player winner = handService.playHand(leader, game.getPlayers(), game.getTroop());

                        winner.getTeam().winHand();
                        printScore(game);
                        game.setCurrentPlayer(winner);
                }
        }

        private Player chooseTroopPlayer(List<Player> players) {
                int index = random.nextInt(players.size());
                return players.get(index);
        }

        private Suit chooseTroop(Player player) {
                Suit[] suits = Suit.values();

                if (player.isHuman()) {
                        printPlayerCards(player);
                        System.out.println();
                        System.out.println("Choose your troop:");

                        for (int i = 0; i < suits.length; i++) {
                                System.out.println(i + ": " + suits[i].getDisplayName() + " " + suits[i].getSymbol());
                        }

                        System.out.print("Choose suit: ");

                        int choice = scanner.nextInt();

                        while (choice < 0 || choice >= suits.length) {
                                System.out.println("Invalid suit.");
                                System.out.print( "Choose suit: ");
                                choice = scanner.nextInt();
                        }

                        return suits[choice];
                }

                Suit selectedSuit = suits[random.nextInt(suits.length)];

                System.out.println();
                System.out.println(player.getName() + " chose " + selectedSuit.getDisplayName() + " as troop.");

                return selectedSuit;
        }

        private void printPlayerCards(Player player) {

                System.out.println();
                System.out.println("Your first five cards:");

                for (int i = 0; i < player.getCards().size(); i++) {
                        System.out.println(i + ": " + player.getCards().get(i));
                }
        }

        private void printScore(Game game) {

                System.out.println("------------------------------");
                System.out.println("           SCORE");
                System.out.println("------------------------------");

                for (Team team : game.getTeams()) {
                        System.out.println(team + ": " + team.getHandsWon());
                }

                System.out.println("------------------------------");
        }

        private void printWelcome() {

                System.out.println("================================");
                System.out.println("    SATHAT");
                System.out.println("================================");
                System.out.println("You: Player 1");
                System.out.println("Team 1: Player 1 + Player 3");
                System.out.println("Team 2: Player 2 + Player 4");
                System.out.println("Winning score: 7 hands");
                System.out.println("================================");
        }

        private void printFinalResult(Game game) {

                Team winningTeam = game.getWinningTeam();

                System.out.println();
                System.out.println("================================");
                System.out.println("           GAME OVER");
                System.out.println("================================");
                System.out.println();
                System.out.println(winningTeam + " WINS!");

                printScore(game);
        }
}
