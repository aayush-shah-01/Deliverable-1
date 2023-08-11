/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Authors: Aayush Shah and Priyansh Raval
 * Date: August 11, 2023
 */

package ca.sheridancollege.project;

// Represents a playing card with a rank and suit
public class Card {

    // Instance variables to store the rank and suit of the card
    private final String rank;
    private final String suit;

    // Constructor to initialize the card with a rank and suit
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Generates a human-readable representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // Getter method to retrieve the rank of the card
    public String getRank() {
        return rank;
    }
}
