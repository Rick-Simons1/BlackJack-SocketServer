package blackjackgamesocketserver.logic;


import blackjackgamesocketserver.enums.Cardvalues;
import blackjackgamesocketserver.enums.Suits;
import blackjackgamesocketserver.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class blackjackGameService {

    private List<Player> playersWaitingTojoin = new ArrayList<Player>();
    private Player initialplayer;


    public void nextRound(Deck deck, BlackJackGame blackJackGame){
        Round round = new Round(deck);

        if (blackJackGame.getCurrentRound() != null){
            blackJackGame.addRound(blackJackGame.getCurrentRound());
            round.setPlayers(blackJackGame.getCurrentRound().getPlayers());
        }
        else {
            round.addPlayer(initialplayer);
        }
        addWaitingPlayersToGame(round);
        round.setCurrentPlayer(round.getPlayers().get(0));
        blackJackGame.setCurrentRound(round);
    }

    public void addWaitingPlayersToGame(Round round){
        if (round.getPlayers().size() < 5){
            for (int i = round.getPlayers().size(); i < 5; i++) {
                if (playersWaitingTojoin.size() != 0){
                    round.addPlayer(playersWaitingTojoin.get(0));
                    playersWaitingTojoin.remove(0);
                }
                else {
                    break;
                }

            }
        }
    }

    public void addPlayer(Player player){
        playersWaitingTojoin.add(player);
    }

    public void addInitialPlayer(Player player){
        this.initialplayer = player;
    }



    public BlackJackGame createNewGame(){
        BlackJackGame blackJackGame = new BlackJackGame();
        return blackJackGame;
    }

    public List<Player> getPlayersWaitingTojoin() {
        return playersWaitingTojoin;
    }
}
