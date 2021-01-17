package blackjackgamesocketserver.controller;

import blackjackgamesocketserver.aiPlayerAlgorithm;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

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
        blackJackGame.getCurrentRound().setDealersTurn(false);
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
    public BlackJackGame checkwinner(BlackJackGame blackJackGame) throws Exception{
        roundService.checkWinner(blackJackGame.getCurrentRound());
        blackJackGame.getCurrentRound().setDealersTurn(false);
        return blackJackGame;
    }

    @MessageMapping("/bet")
    @SendTo("/client")
    public BlackJackGame bet(BetDTO betDTO) throws Exception{
        for (Player playerIter: betDTO.blackjackgame.getCurrentRound().getPlayers()){
            if (playerIter.getId() == betDTO.player.getId()){
                roundService.setInitialBet(playerIter, betDTO.bet);
            }
        }
        return betDTO.blackjackgame;
    }

    @MessageMapping("/deal")
    @SendTo("/client")
    public BlackJackGame dealInitialCards(BlackJackGame blackJackGame) throws Exception{
        roundService.addInitialCardsToPlayers(blackJackGame.getCurrentRound());
        roundService.addInitialCardsToDealer(blackJackGame.getCurrentRound());
        return blackJackGame;
    }

   /* @MessageMapping("/giveWinnings")
    @SendTo("/client")
    public Player giveWinnings(Player player) throws Exception{
        roundService.giveWinnings(player);
        return player;
    }*/


}
