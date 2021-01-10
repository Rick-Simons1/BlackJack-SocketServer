package blackjackgamesocketserver.controller;

import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class roundController {

    @Autowired
    roundService roundService;

    @MessageMapping("/hit")
    @SendTo("/client")
    public BlackJackGame hit(BlackJackGame blackJackGame) throws Exception{
        roundService.getCard(blackJackGame.getCurrentRound());
        return blackJackGame;
    }

    @MessageMapping("/hitDealer")
    @SendTo("/client")
    public BlackJackGame hitdealer(BlackJackGame blackJackGame) throws Exception{
        roundService.getCardDealer(blackJackGame.getCurrentRound());
        return blackJackGame;
    }

    @MessageMapping("/stand")
    @SendTo("/client")
    public BlackJackGame stand(BlackJackGame blackJackGame) throws Exception{
        roundService.stand(blackJackGame.getCurrentRound());
        return blackJackGame;
    }

    @MessageMapping("/split")
    @SendTo("/client")
    public BlackJackGame split(BlackJackGame blackJackGame) throws Exception{
        roundService.split(blackJackGame.getCurrentRound());
        return blackJackGame;
    }

    @MessageMapping("/double")
    @SendTo("/client")
    public BlackJackGame doubleBet(BlackJackGame blackJackGame) throws Exception{
        roundService.doubleBet(blackJackGame.getCurrentRound());
        return blackJackGame;
    }

    @MessageMapping("/checkWinner")
    @SendTo("/client")
    public HashMap<Integer, String> checkwinner(BlackJackGame blackJackGame) throws Exception{
        return roundService.checkWinner(blackJackGame.getCurrentRound());
    }

    /*@MessageMapping("/bet")
    @SendTo("/client")
    public Player bet(Player player, int bet) throws Exception{
        roundService.setInitialBet(player, bet);
        return player;
    }*/

    @MessageMapping("/deal")
    @SendTo("/client")
    public BlackJackGame dealInitialCards(BlackJackGame blackJackGame) throws Exception{
        roundService.addInitialCardsToPlayers(blackJackGame.getCurrentRound());
        roundService.addInitialCardsToDealer(blackJackGame.getCurrentRound());
        return blackJackGame;
    }

    @MessageMapping("/giveWinnings")
    @SendTo("/client")
    public Player giveWinnings(Player player) throws Exception{
        roundService.giveWinnings(player);
        return player;
    }
}
