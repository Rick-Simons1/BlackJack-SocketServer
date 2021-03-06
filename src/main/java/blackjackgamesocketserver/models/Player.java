package blackjackgamesocketserver.models;

import blackjackgamesocketserver.enums.Cardvalues;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private int id;
    private String username;
    private int money;
    private List<Card> cards;
    private List<Card> splitCards;
    private int currentBet;
    private int currentSplitBet;
    private Boolean containsSplit;
    private int totalCardPoints;
    private int totalSplitCardPoints;
    private boolean containsAce;
    private boolean splitContainsAce;
    private boolean blackjack;
    private boolean splitBlackjack;
    private boolean bust;
    private boolean splitBust;
    private boolean win;
    private boolean splitwin;
    private boolean draw;
    private boolean splitDraw;

    public Player(int id, String username, int money) {
        this.id = id;
        this.username = username;
        this.money = money;
        this.containsSplit = false;
        cards = new ArrayList<Card>();
        splitCards = new ArrayList<>();
        this.blackjack = false;
        this.splitBlackjack = false;
    }

    public void addCardToPlayer(Card card){
        if (card.getCardValue() == Cardvalues.ace){
            this.containsAce = true;
            if (this.cards.size() == 1){
                if (this.cards.get(0).getCardPoints() == 10){
                    this.blackjack = true;
                }
            }
            if (totalCardPoints + 11 <= 21){
                card.setCardPoints(11);
            }
            else {
                card.setCardPoints(1);
            }

        }
        else if (this.containsAce && this.cards.size() == 1 && card.getCardPoints() == 10){
            this.blackjack = true;
        }
        else if (this.containsAce && totalCardPoints + card.getCardPoints() > 21){
            for (Card cardIteration: this.cards){
                if (cardIteration.getCardValue() == Cardvalues.ace){
                    if (cardIteration.getCardPoints() == 11){
                        cardIteration.setCardPoints(1);
                        this.totalCardPoints -= 10;
                        break;
                    }

                }
            }
        }

        cards.add(card);
        this.totalCardPoints += card.getCardPoints();

    }

    public void addCardToSplitCards(Card card){
        if (card.getCardValue() == Cardvalues.ace){
            this.splitContainsAce = true;
            if (this.cards.size() == 1){
                if (this.splitCards.get(0).getCardPoints() == 10){
                    this.splitBlackjack = true;
                }
            }
            if (totalSplitCardPoints + 11 <= 21){
                card.setCardPoints(11);
            }
            else {
                card.setCardPoints(1);
            }
        }
        else if (this.splitContainsAce && this.splitCards.size() == 1 && card.getCardPoints() == 10){
            this.splitBlackjack = true;
        }
        else if (this.containsAce && totalSplitCardPoints + card.getCardPoints() > 21){
            for (Card cardIteration: this.splitCards){
                if (cardIteration.getCardValue() == Cardvalues.ace){
                    if (cardIteration.getCardPoints() == 11){
                        cardIteration.setCardPoints(1);
                        this.totalSplitCardPoints -= 10;
                        break;
                    }

                }
            }
        }
        splitCards.add(card);
        this.totalSplitCardPoints += card.getCardPoints();
    }

    public void resetPlayer(){
        cards = new ArrayList<>();
        splitCards = new ArrayList<>();
        this.containsSplit = false;
        this.containsAce = false;
        this.splitContainsAce = false;
        this.blackjack = false;
        this.splitBlackjack = false;
        this.bust = false;
        this.splitBust = false;
        this.win = false;
        this.splitwin = false;
        this.draw = false;
        this.splitDraw = false;
        this.totalSplitCardPoints = 0;
        this.totalCardPoints = 0;
        this.currentSplitBet = 0;
    }

    public void addMoney(int money){
        this.money += money;
    }

    public void removeMoney(int money){
        this.money -= money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int bet) {
        this.money = this.money -  bet ;
        this.currentBet = bet;

    }

    public void setSplitDeck(){
        splitCards.add(cards.get(0));
        totalCardPoints -= cards.get(0).getCardPoints();
        totalSplitCardPoints += cards.get(0).getCardPoints();
        cards.remove(cards.get(0));
        if (splitCards.get(0).getCardValue() == Cardvalues.ace){
            this.splitContainsAce = true;
        }

    }

    public Boolean getContainsSplit() {
        return containsSplit;
    }

    public void setContainsSplit(Boolean containsSplit) {
        this.containsSplit = containsSplit;
    }

    public int getCurrentSplitBet() {
        return currentSplitBet;
    }

    public void setCurrentSplitBet(int currentBet) {
        this.money -= currentBet;
        this.currentSplitBet = currentBet;
    }

    public void setInitialSplitBet() {
        this.money -= this.currentBet;
        this.currentSplitBet = this.currentBet;
    }

    public List<Card> getSplitCards() {
        return splitCards;
    }

    public void setSplitCards(List<Card> splitCards) {
        this.splitCards = splitCards;
    }

    public int getTotalCardPoints() {
        return totalCardPoints;
    }

    public void setTotalCardPoints(int totalCardPoints) {
        this.totalCardPoints = totalCardPoints;
    }

    public int getTotalSplitCardPoints() {
        return totalSplitCardPoints;
    }

    public void setTotalSplitCardPoints(int totalSplitCardPoints) {
        this.totalSplitCardPoints = totalSplitCardPoints;
    }

    public boolean getContainsAce() {
        return containsAce;
    }

    public void setContainsAce(boolean containsAce) {
        this.containsAce = containsAce;
    }

    public boolean getSplitContainsAce() {
        return splitContainsAce;
    }

    public void setSplitContainsAce(boolean splitContainsAce) {
        this.splitContainsAce = splitContainsAce;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isSplitBlackjack() {
        return splitBlackjack;
    }

    public void setSplitBlackjack(boolean splitBlackjack) {
        this.splitBlackjack = splitBlackjack;
    }

    public boolean isBust() {
        return bust;
    }

    public void setBust(boolean bust) {
        this.bust = bust;
    }

    public boolean isSplitBust() {
        return splitBust;
    }

    public void setSplitBust(boolean splitBust) {
        this.splitBust = splitBust;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isSplitwin() {
        return splitwin;
    }

    public void setSplitwin(boolean splitwin) {
        this.splitwin = splitwin;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public boolean isSplitDraw() {
        return splitDraw;
    }

    public void setSplitDraw(boolean splitDraw) {
        this.splitDraw = splitDraw;
    }
}
