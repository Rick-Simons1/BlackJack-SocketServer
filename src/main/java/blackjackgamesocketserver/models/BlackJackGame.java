package blackjackgamesocketserver.models;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {

    private int id;
    private List<Round> rounds;
    private Round currentRound;

    public BlackJackGame() {
        rounds = new ArrayList<Round>();
    }

    public void addRound(Round round){
        rounds.add(round);
    }

    public int getId() {
        return id;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Round currentRound) {
        this.currentRound = currentRound;
    }
}
