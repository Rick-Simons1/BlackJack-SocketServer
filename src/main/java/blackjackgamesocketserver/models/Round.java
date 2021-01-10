    package blackjackgamesocketserver.models;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private List<Player> players;
    private Deck deck;
    private Player currentPlayer;
    private Dealer dealer;
    private boolean dealersTurn;

    public Round(Deck deck) {
        this.players = new ArrayList<>();
        this.deck = deck;
        dealer = new Dealer();
        this.dealersTurn = false;
    }

    public Round(Deck deck, List<Player> players) {
        this.players = players;
        this.deck = deck;
        currentPlayer = players.get(0);
        dealer = new Dealer();
        this.dealersTurn = false;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public void nextPlayer(){
        int currentPlayerIndex = players.indexOf(currentPlayer);

        if (players.size() > 1){
            if (players.size() == currentPlayerIndex + 1){
                this.dealersTurn = true;
            }
            else {
                if (players.get(currentPlayerIndex + 1).isBlackjack()){
                    if (players.size() == currentPlayerIndex + 2){
                        this.dealersTurn = true;
                    }
                    else {
                        this.currentPlayer = players.get(currentPlayerIndex + 2);
                    }
                }
                else {
                    this.currentPlayer = players.get(currentPlayerIndex + 1);
                }
            }
        }
        else {
            this.dealersTurn = true;
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public boolean isDealersTurn() {
        return dealersTurn;
    }

    public void setDealersTurn(boolean dealersTurn) {
        this.dealersTurn = dealersTurn;
    }
}
