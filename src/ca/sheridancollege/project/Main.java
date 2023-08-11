package ca.sheridancollege.project;

/**
 * This is the main class that starts the Snap card game.
 * Authors: Aayush Shah and Priyansh Raval
 * Date: August 11, 2023
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a deck of cards
        List<Card> deck = createDeck();

        // Create players for the game
        List<Player> players = createPlayers(scanner);

        // Initialize the game and play
        Game game = new Game("Snap Card Game", players);
        game.dealCards(deck);
        game.play();
        game.declareWinner();

        scanner.close();
    }

    // Create a standard deck of 52 playing cards
    private static List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Generate cards for each suit and rank combination
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }

    // Create players for the game based on user input
    private static List<Player> createPlayers(Scanner scanner) {
        List<Player> players = new ArrayList<>();
        System.out.print("Enter number of players (2-4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name of player " + i + ": ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }
        return players;
    }
}