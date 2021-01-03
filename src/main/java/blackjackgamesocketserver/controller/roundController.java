package blackjackgamesocketserver.controller;

import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class roundController {

    @Autowired
    roundService roundService;

    @MessageMapping("/hit")
    @SendTo("/round")
    public Round hit(Round currentRound) throws Exception{
        roundService.getCard(currentRound);
        return currentRound;
    }

    @MessageMapping("/stand")
    @SendTo("/round")
    public Round stand(Round currentRound) throws Exception{
        roundService.stand(currentRound);
        return currentRound;
    }

    @MessageMapping("/split")
    @SendTo("/round")
    public Round split(Round currentRound) throws Exception{
        roundService.split(currentRound);
        return currentRound;
    }

    @MessageMapping("/double")
    @SendTo("/round")
    public Round doubleBet(Round currentRound) throws Exception{
        roundService.doubleBet(currentRound);
        return currentRound;
    }
}
