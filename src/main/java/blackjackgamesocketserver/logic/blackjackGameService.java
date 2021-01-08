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

    private BlackJackGame blackJackGame;
    private List<Player> playersWaitingTojoin = new ArrayList<Player>();


    public void nextRound(Deck deck){
        if (blackJackGame.getCurrentRound() != null){
            blackJackGame.addRound(blackJackGame.getCurrentRound());
        }

        Round round = new Round(deck);

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
        blackJackGame.setCurrentRound(round);
    }

    public void addPlayer(Player player){
        playersWaitingTojoin.add(player);
    }

    public BlackJackGame getBlackJackGame() {
        return blackJackGame;
    }

    public void createNewGame(){
        blackJackGame = new BlackJackGame();
    }

    public List<Player> getPlayersWaitingTojoin() {
        return playersWaitingTojoin;
    }
}
