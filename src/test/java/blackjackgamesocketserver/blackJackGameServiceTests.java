package blackjackgamesocketserver;

import blackjackgamesocketserver.logic.blackjackGameService;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.BlackJackGame;
import blackjackgamesocketserver.models.Player;
import blackjackgamesocketserver.models.Round;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class blackJackGameServiceTests {

    @Autowired
    blackjackGameService  blackjackGameService;

    @Autowired
    roundService roundService;


    @Test
    void test_addMoreThan5PlayersToGame(){
        Player player = new Player(1, "test1", 1000);
        Player player1 = new Player(2, "test2", 1000);
        Player player2 = new Player(3, "test3", 1000);
        Player player3= new Player(4, "test4", 1000);
        Player player4 = new Player(5, "test5", 1000);
        Player player5 = new Player(6, "test6", 1000);
        blackjackGameService.addInitialPlayer(player);
        blackjackGameService.addPlayer(player1);
        blackjackGameService.addPlayer(player2);
        blackjackGameService.addPlayer(player3);
        blackjackGameService.addPlayer(player4);
        blackjackGameService.addPlayer(player5);
        BlackJackGame blackJackGame = new BlackJackGame();

        blackjackGameService.nextRound(roundService.shuffleDeck(), blackJackGame);

        assertEquals(5, blackJackGame.getCurrentRound().getPlayers().size());
        assertEquals(1, blackjackGameService.getPlayersWaitingTojoin().size());

    }
}
