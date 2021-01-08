package blackjackgamesocketserver.controller;

import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.Card;
import blackjackgamesocketserver.models.Deck;
import blackjackgamesocketserver.models.Player;
import blackjackgamesocketserver.models.Round;
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
    public Round hit(Round currentRound) throws Exception{
        roundService.getCard(currentRound);
        return currentRound;
    }

    @MessageMapping("/stand")
    @SendTo("/client")
    public Round stand(Round currentRound) throws Exception{
        roundService.stand(currentRound);
        return currentRound;
    }

    @MessageMapping("/split")
    @SendTo("/client")
    public Round split(Round currentRound) throws Exception{
        roundService.split(currentRound);
        return currentRound;
    }

    @MessageMapping("/double")
    @SendTo("/client")
    public Round doubleBet(Round currentRound) throws Exception{
        roundService.doubleBet(currentRound);
        return currentRound;
    }

    @MessageMapping("/checkWinner")
    @SendTo("/client")
    public HashMap<Integer, String> checkwinner(Round currentRound) throws Exception{
        return roundService.checkWinner(currentRound);
    }

    /*@MessageMapping("/bet")
    @SendTo("/client")
    public Player bet(Player player, int bet) throws Exception{
        roundService.setInitialBet(player, bet);
        return player;
    }*/

    @MessageMapping("/dealCards")
    @SendTo("/client")
    public Round dealInitialCards(Round currentRound) throws Exception{
        roundService.addInitialCardsToPlayers(currentRound);
        roundService.addInitialCardsToDealer(currentRound);
        return currentRound;
    }

    @MessageMapping("/giveWinnings")
    @SendTo("/client")
    public Player giveWinnings(Player player) throws Exception{
        roundService.giveWinnings(player);
        return player;
    }
}
