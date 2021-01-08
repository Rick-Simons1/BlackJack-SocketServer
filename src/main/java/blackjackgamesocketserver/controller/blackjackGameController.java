package blackjackgamesocketserver.controller;

import blackjackgamesocketserver.logic.blackjackGameService;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.BlackJackGame;
import blackjackgamesocketserver.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class blackjackGameController {

    @Autowired
    blackjackGameService blackjackGameService;
    @Autowired
    roundService roundService;

    @MessageMapping("/createGame")
    @SendTo("/client")
    public BlackJackGame createNewGame(Player player){
        blackjackGameService.createNewGame();
        blackjackGameService.addPlayer(player);
        blackjackGameService.nextRound(roundService.shuffleDeck());
        return blackjackGameService.getBlackJackGame();
    }

    @MessageMapping("/nextRound")
    @SendTo("/client")
    public BlackJackGame nextRound(){
        blackjackGameService.nextRound(roundService.shuffleDeck());
        return blackjackGameService.getBlackJackGame();
    }

    @MessageMapping("/addPlayer")
    @SendTo("/client")
    public List<Player> addPlayer(Player player){
        blackjackGameService.addPlayer(player);
        return blackjackGameService.getPlayersWaitingTojoin();
    }


}