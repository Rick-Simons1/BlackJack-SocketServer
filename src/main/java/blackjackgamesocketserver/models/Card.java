package blackjackgamesocketserver.models;

import blackjackgamesocketserver.enums.Cardvalues;
import blackjackgamesocketserver.enums.Suits;

public class Card {

    private Suits cardSuit;
    private Cardvalues cardValue;
    private int cardPoints;


    public Card(Suits suit, Cardvalues cardvalues, int cardPoints) {
        this.cardSuit = suit;
        this.cardValue = cardvalues;
        this.cardPoints = cardPoints;

    }

    public Suits getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(Suits cardSuit) {
        this.cardSuit = cardSuit;
    }

    public Cardvalues getCardValue() {
        return cardValue;
    }

    public void setCardValue(Cardvalues cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardPoints() {
        return cardPoints;
    }

    public void setCardPoints(int cardPoints) {
        this.cardPoints = cardPoints;
    }
}
