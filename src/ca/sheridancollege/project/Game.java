/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Authors: Aayush Shah and Priyansh Raval
 * Date: August 11, 2023
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections; // Import the Collections class
import java.util.Scanner;

public class Game {

    private String name;
    private List<Player> players = new ArrayList<>();
    private List<Card> pile = new ArrayList<>();

    public Game(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    // Deal cards from the deck to players
    public void dealCards(List<Card> deck) {
        Collections.shuffle(deck); // Shuffle the deck
        int playerIndex = 0;
        for (Card card : deck) {
            List<Card> cardList = new ArrayList<>();
            cardList.add(card);
            players.get(playerIndex).addToStack(cardList);
            playerIndex = (playerIndex + 1) % players.size();
        }
    }

    // Play the game
    public void play() {
        Scanner scanner = new Scanner(System.in);
        List<Player> playersToRemove = new ArrayList<>();

        // Continue the game until only one player remains
        while (players.size() > 1) {
            for (Player player : players) {
                System.out.println(player.getName() + ", press Enter to play your turn...");
                scanner.nextLine(); // Wait for the user to press Enter
                Card topCard = player.playCard();
                if (topCard != null) {
                    pile.add(topCard);
                    System.out.println(player.getName() + " plays " + topCard);
                    if (checkSnap()) {
                        System.out.println("SNAP! " + player.getName() + " claims the pile.");
                        player.getStack().shuffle();
                        player.addToStack(pile);
                        pile.clear();
                        player.incrementPilesWon(); // Increment piles won by the player
                    }
                } else {
                    System.out.println(player.getName() + " is out of cards.");
                    playersToRemove.add(player);
                }
                System.out.println("Number of cards left for " + player.getName() + ": " + player.getStack().getCards().size());
                System.out.println("Piles won by " + player.getName() + ": " + player.getPilesWon()+"\n\n");
            }

            // Remove players who are out of cards after the round
            players.removeAll(playersToRemove);
            playersToRemove.clear();
        }

        scanner.close();
    }

    // Declare the winner of the game
    public void declareWinner() {
        if (!players.isEmpty()) {
            Player winner = players.get(0);
            System.out.println("The winner is " + winner.getName() + "!");
        } else {
            System.out.println("No winner. All players are out of cards.");
        }
    }

    // Check if a snap (matching ranks of cards) has occurred
    private boolean checkSnap() {
        if (pile.size() >= 2) {
            Card topCard = pile.get(pile.size() - 1);
            Card secondTopCard = pile.get(pile.size() - 2);
            return topCard.getRank().equals(secondTopCard.getRank());
        }
        return false;
    }
}
