package blackjackgamesocketserver.models;

import blackjackgamesocketserver.enums.Cardvalues;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private List<Card> cards;
    private Card visibleCard;
    private int totalCardPoints;
    private boolean containsAce;
    private boolean blackjack;
    private boolean bust;

    public Dealer() {
        cards = new ArrayList<Card>();
        this.totalCardPoints = 0;
        this.blackjack = false;
        this.containsAce = false;
    }



    public void addCardToDealer(Card card){
        if (cards.size() == 0){
            this.visibleCard = card;
        }
        if (card.getCardValue() == Cardvalues.ace){
            this.containsAce = true;
            if (totalCardPoints + 11 <= 21){
                card.setCardPoints(11);
            }
        }

        cards.add(card);
        this.totalCardPoints += card.getCardPoints();
    }

    public void resetCards(){
        cards = new ArrayList<Card>();
        /*this.containsAce = false;
        this.blackjack = false;
        this.visibleCard = null;
        this.totalCardPoints = 0;*/
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card getVisibleCard() {
        return visibleCard;
    }

    public void setVisibleCard(Card visibleCard) {
        this.visibleCard = visibleCard;
    }

    public int getTotalCardPoints() {
        return totalCardPoints;
    }

    public void setTotalCardPoints(int totalCardPoints) {
        this.totalCardPoints = totalCardPoints;
    }

    public boolean getContainsAce() {
        return containsAce;
    }

    public void setContainsAce(boolean containsAce) {
        this.containsAce = containsAce;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isBust() {
        return bust;
    }

    public void setBust(boolean bust) {
        this.bust = bust;
    }
}
