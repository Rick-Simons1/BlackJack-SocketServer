package blackjackgamesocketserver.models;

import java.util.List;

public class Deck {

    private List<Card> deck;


    public Deck() {
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
}
