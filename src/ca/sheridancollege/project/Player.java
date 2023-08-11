/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private GroupOfCards stack = new GroupOfCards();
    private int pilesWon = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GroupOfCards getStack() {
        return stack;
    }

public void addToStack(List<Card> cards) {
    stack.getCards().addAll(cards);
}

    public boolean hasMatchingCard(Card pileTopCard) {
        for (Card card : stack.getCards()) {
            if (card.getRank().equals(pileTopCard.getRank())) {
                return true;
            }
        }
        return false;
    }

    public Card playCard() {
        return stack.drawCard();
    }
     public void incrementPilesWon() {
        pilesWon++;
    }

    public int getPilesWon() {
        return pilesWon;
    }
}
