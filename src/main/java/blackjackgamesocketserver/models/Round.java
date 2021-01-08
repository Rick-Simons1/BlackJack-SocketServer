    package blackjackgamesocketserver.models;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private List<Player> players;
    private Deck deck;
    private Player currentPlayer;
    private Dealer dealer;

    public Round(Deck deck) {
        this.players = new ArrayList<>();
        this.deck = deck;
        dealer = new Dealer();
    }

    public Round(Deck deck, List<Player> players) {
        this.players = players;
        this.deck = deck;
        currentPlayer = players.get(0);
        dealer = new Dealer();
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
            Player nextPlayer = players.get(currentPlayerIndex + 1);
            currentPlayer = nextPlayer;
        }
        else {
            currentPlayer = players.get(0);
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
}
