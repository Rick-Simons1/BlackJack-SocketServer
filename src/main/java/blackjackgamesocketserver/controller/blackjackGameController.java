package blackjackgamesocketserver.controller;

import blackjackgamesocketserver.aiPlayerAlgorithm;
import blackjackgamesocketserver.logic.blackjackGameService;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.BetDTO;
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
        BlackJackGame blackJackGame = blackjackGameService.createNewGame();
        blackjackGameService.addInitialPlayer(player);
        blackjackGameService.nextRound(roundService.shuffleDeck(), blackJackGame);
        return blackJackGame;
    }

    @MessageMapping("/nextRound")
    @SendTo("/client")
    public BlackJackGame nextRound(BlackJackGame blackJackGame){
        blackjackGameService.nextRound(roundService.shuffleDeck(), blackJackGame);
        return blackJackGame;
    }

    @MessageMapping("/addPlayer")
    @SendTo("/client")
    public void addPlayer(Player player){
        blackjackGameService.addPlayer(player);
/*
        return blackjackGameService.getPlayersWaitingTojoin();
*/
    }

    @MessageMapping("/removePlayer")
    @SendTo("/client")
    public BlackJackGame removePlayer(BetDTO betDTO){
        blackjackGameService.removePlayer(betDTO.player, betDTO.blackjackgame);
        return betDTO.blackjackgame;
    }

    @MessageMapping("/aiStart")
    @SendTo("/client")
    public BlackJackGame aiStart(BlackJackGame blackJackGame) throws Exception{
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(this.roundService, this.blackjackGameService);
        aiPlayerAlgorithm.runAiAlgorithm(blackJackGame);
        blackJackGame.getCurrentRound().getCurrentPlayer().setId(0);
        return blackJackGame;
    }


}
