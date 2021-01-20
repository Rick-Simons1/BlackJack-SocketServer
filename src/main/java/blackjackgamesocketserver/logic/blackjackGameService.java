package blackjackgamesocketserver.logic;


import blackjackgamesocketserver.enums.Cardvalues;
import blackjackgamesocketserver.enums.Suits;
import blackjackgamesocketserver.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.*;

@Service
public class blackjackGameService implements IBlackjackGameService{

    private List<Player> playersWaitingTojoin = new ArrayList<Player>();
    private Player initialplayer;


    public void nextRound(Deck deck, BlackJackGame blackJackGame){
        Round round = new Round(deck);

        if (blackJackGame.getCurrentRound() != null){
            //blackJackGame.addRound(blackJackGame.getCurrentRound());
            for (Player player: blackJackGame.getCurrentRound().getPlayers()){
                player.resetPlayer();
            }
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

    public List<Player> getPlayersWaitingTojoin() {
        return playersWaitingTojoin;
    }

    public void addPlayer(Player player){
        playersWaitingTojoin.add(player);
    }

    public void addInitialPlayer(Player player){
        this.initialplayer = player;
    }

    public void removePlayer(Player player, BlackJackGame blackJackGame){
        if (blackJackGame.getCurrentRound().getCurrentPlayer().getId() != player.getId()){
            for (int i = 0; i < blackJackGame.getCurrentRound().getPlayers().size(); i++) {
                Player playerx = blackJackGame.getCurrentRound().getPlayers().get(i);
                if (playerx.getId() == player.getId()){
                    blackJackGame.getCurrentRound().removePlayer(playerx);
                }
            }
        }
    }

    public BlackJackGame createNewGame(){
        BlackJackGame blackJackGame = new BlackJackGame();
        blackJackGame.setId(generateCode());
        return blackJackGame;
    }

    public String generateCode(){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder(4);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }


}
