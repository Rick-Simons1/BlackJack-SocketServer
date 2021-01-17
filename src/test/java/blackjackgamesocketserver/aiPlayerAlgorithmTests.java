package blackjackgamesocketserver;

import blackjackgamesocketserver.enums.Cardvalues;
import blackjackgamesocketserver.enums.Suits;
import blackjackgamesocketserver.logic.blackjackGameService;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class aiPlayerAlgorithmTests {
    @Autowired
    roundService roundService;

    @Autowired
    blackjackGameService blackjackGameService;



    @Test
    void testSplitAlgorithm_ifplayerHandIsTwos_ifDealerVisibleCardIsTwo(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.two, 2, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.two, 2, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.two, 2, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsTwos_ifDealerVisibleCardIsThree(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.three, 3, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.two, 2, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.two, 2, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsTwos_ifDealerVisibleCardIsFour(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.four, 4, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.two, 2, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.two, 2, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsTwos_ifDealerVisibleCardIsFive(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.five, 5, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.two, 2, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.two, 2, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsTwos_ifDealerVisibleCardIsSix(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.six, 6, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.two, 2, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.two, 2, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsTwos_ifDealerVisibleCardIsSeven(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.seven, 7, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.two, 2, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.two, 2, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsThrees_ifDealerVisibleCardIsTwo(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.two, 2, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.three, 3, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.three, 3, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsThrees_ifDealerVisibleCardIsThree(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.three, 3, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.three, 3, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.three, 3, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsThrees_ifDealerVisibleCardIsFour(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.four, 4, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.three, 3, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.three, 3, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsThrees_ifDealerVisibleCardIsFive(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.five, 5, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.three, 3, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.three, 3, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsThrees_ifDealerVisibleCardIsSix(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.six, 6, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.three, 3, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.three, 3, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testSplitAlgorithm_ifplayerHandIsThrees_ifDealerVisibleCardIsSeven(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);
        BlackJackGame blackJackGame = new BlackJackGame();
        Player ai = new Player(999, "aiPlayer", 10000);
        Dealer dealer = new Dealer();
        dealer.addCardToDealer(new Card(Suits.spade, Cardvalues.seven, 7, ""));
        List<Player> players = new ArrayList<>();

        ai.addCardToPlayer(new Card(Suits.club, Cardvalues.three, 3, ""));
        ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.three, 3, ""));

        players.add(ai);

        Deck deck = new Deck();

        Round round = new Round(deck, players);
        round.setDealer(dealer);
        blackJackGame.setCurrentRound(round);
        aiPlayerAlgorithm.ai = ai;
        aiPlayerAlgorithm.splitAlgorithm(blackJackGame);

        assertEquals(true, ai.getContainsSplit());
    }

    @Test
    void testAlgorithm(){
        List<String> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);

            Player ai = new Player(999, "aiPlayer", 10000);
            List<Player> players = new ArrayList<>();
            List<Card> cards;
            players.add(ai);
            Deck deck;
            blackjackGameService.addInitialPlayer(ai);
            BlackJackGame blackJackGame = new BlackJackGame();
            Round round;

            long startTime = System.currentTimeMillis();
            for (int j = 0; j < 10000; j++) {
                deck = roundService.shuffleDeck();
                cards = deck.getDeck();
                round = new Round(deck, players);
            /*ai.addCardToPlayer(cards.get(0));
            ai.addCardToPlayer(cards.get(1));*/
                round.getDealer().addCardToDealer(cards.get(1));
                round.getDealer().addCardToDealer(cards.get(2));
                ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.ace, 1, ""));
                ai.addCardToPlayer(new Card(Suits.club, Cardvalues.ace, 1, ""));
                round.setDeck(deck);
                blackJackGame.setCurrentRound(round);
                aiPlayerAlgorithm.runAiAlgorithm(blackJackGame);
                ai.resetPlayer();

            }
            long endTime = System.currentTimeMillis();
            long resulttime = endTime - startTime;
            String string = "ms:" + resulttime + "steps:" + aiPlayerAlgorithm.steps;
            results.add(string);
        }
        System.out.println(results);


    }

    @Test
    void testSplitAlgorithmMaxSteps(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);

        Player ai = new Player(999, "aiPlayer", 10000);
        List<Player> players = new ArrayList<>();
        List<Card> cards = new ArrayList<>();

        players.add(ai);
        Deck deck = new Deck();

        blackjackGameService.addInitialPlayer(ai);
        BlackJackGame blackJackGame = new BlackJackGame();
        Round round;
        aiPlayerAlgorithm.ai = ai;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            round = new Round(deck,players);
            ai.addCardToPlayer(new Card(Suits.club, Cardvalues.six, 6, ""));
            ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.six, 6, ""));
            round.getDealer().addCardToDealer(new Card(Suits.club, Cardvalues.five, 5, ""));
            round.getDealer().addCardToDealer(new Card(Suits.heart, Cardvalues.five, 5, ""));
            blackJackGame.setCurrentRound(round);
            aiPlayerAlgorithm.splitAlgorithm(blackJackGame);
            ai.resetPlayer();
        }
        System.out.println(aiPlayerAlgorithm.steps);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime );

    }

    @Test
    void testSplitAlgorithmMinSteps(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);

        Player ai = new Player(999, "aiPlayer", 10000);
        List<Player> players = new ArrayList<>();
        List<Card> cards = new ArrayList<>();

        players.add(ai);
        Deck deck = new Deck();

        blackjackGameService.addInitialPlayer(ai);
        BlackJackGame blackJackGame = new BlackJackGame();
        Round round;
        aiPlayerAlgorithm.ai = ai;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            round = new Round(deck,players);
            ai.addCardToPlayer(new Card(Suits.club, Cardvalues.six, 6, ""));
            ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.five, 5, ""));
            round.getDealer().addCardToDealer(new Card(Suits.club, Cardvalues.five, 5, ""));
            round.getDealer().addCardToDealer(new Card(Suits.heart, Cardvalues.five, 5, ""));
            blackJackGame.setCurrentRound(round);
            aiPlayerAlgorithm.splitAlgorithm(blackJackGame);
            ai.resetPlayer();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(aiPlayerAlgorithm.steps);
        System.out.println(endTime - startTime );

    }

    @Test
    void testsplitAlgorithmRandom(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);

        Player ai = new Player(999, "aiPlayer", 10000);
        List<Player> players = new ArrayList<>();
        List<Card> cards;
        players.add(ai);
        Deck deck = roundService.buildDeck();
        blackjackGameService.addInitialPlayer(ai);
        BlackJackGame blackJackGame = new BlackJackGame();
        Round round;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Collections.shuffle(deck.getDeck());
            cards = deck.getDeck();
            round = new Round(deck, players);
            ai.addCardToPlayer(cards.get(0));
            ai.addCardToPlayer(cards.get(1));
            round.getDealer().addCardToDealer(cards.get(2));
            round.getDealer().addCardToDealer(cards.get(3));

            deck.setDeck(cards);
            round.setDeck(deck);
            blackJackGame.setCurrentRound(round);
            aiPlayerAlgorithm.ai = ai;
            aiPlayerAlgorithm.splitAlgorithm(blackJackGame);
            ai.resetPlayer();

        }
        long endTime = System.currentTimeMillis();
        System.out.println(aiPlayerAlgorithm.steps);
        System.out.println(endTime - startTime );

    }

    @Test
    void testAceAlgorithmMaxSteps(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);

        Player ai = new Player(999, "aiPlayer", 10000);
        List<Player> players = new ArrayList<>();
        List<Card> cards = new ArrayList<>();

        players.add(ai);
        Deck deck = new Deck();

        blackjackGameService.addInitialPlayer(ai);
        BlackJackGame blackJackGame = new BlackJackGame();
        Round round;
        aiPlayerAlgorithm.ai = ai;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            round = new Round(deck,players);
            ai.addCardToPlayer(new Card(Suits.club, Cardvalues.ace, 1, ""));
            ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.seven, 7, ""));
            round.getDealer().addCardToDealer(new Card(Suits.club, Cardvalues.seven, 7, ""));
            round.getDealer().addCardToDealer(new Card(Suits.heart, Cardvalues.five, 5, ""));
            blackJackGame.setCurrentRound(round);
            aiPlayerAlgorithm.aceAlgorithm(blackJackGame);
            ai.resetPlayer();
        }
        System.out.println(aiPlayerAlgorithm.steps);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime );

    }

    @Test
    void testAceAlgorithMinSteps(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);

        Player ai = new Player(999, "aiPlayer", 10000);
        List<Player> players = new ArrayList<>();
        List<Card> cards = new ArrayList<>();

        players.add(ai);
        Deck deck = new Deck();

        blackjackGameService.addInitialPlayer(ai);
        BlackJackGame blackJackGame = new BlackJackGame();
        Round round;
        aiPlayerAlgorithm.ai = ai;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {

            round = new Round(deck,players);
            ai.addCardToPlayer(new Card(Suits.club, Cardvalues.eight, 8, ""));
            ai.addCardToPlayer(new Card(Suits.heart, Cardvalues.eight, 8, ""));
            round.getDealer().addCardToDealer(new Card(Suits.club, Cardvalues.five, 5, ""));
            round.getDealer().addCardToDealer(new Card(Suits.heart, Cardvalues.five, 5, ""));
            blackJackGame.setCurrentRound(round);
            aiPlayerAlgorithm.aceAlgorithm(blackJackGame);
            ai.resetPlayer();
        }
        System.out.println(aiPlayerAlgorithm.steps);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime );

    }

    @Test
    void testAceAlgorithmRandom(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);

        Player ai = new Player(999, "aiPlayer", 10000);
        List<Player> players = new ArrayList<>();
        List<Card> cards;
        players.add(ai);
        Deck deck = roundService.buildDeck();
        blackjackGameService.addInitialPlayer(ai);
        BlackJackGame blackJackGame = new BlackJackGame();
        Round round;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Collections.shuffle(deck.getDeck());
            cards = deck.getDeck();
            round = new Round(deck, players);
            ai.addCardToPlayer(cards.get(0));
            ai.addCardToPlayer(cards.get(1));
            round.getDealer().addCardToDealer(cards.get(2));
            round.getDealer().addCardToDealer(cards.get(3));

            deck.setDeck(cards);
            round.setDeck(deck);
            blackJackGame.setCurrentRound(round);
            aiPlayerAlgorithm.ai = ai;
            aiPlayerAlgorithm.aceAlgorithm(blackJackGame);
            ai.resetPlayer();

        }
        long endTime = System.currentTimeMillis();
        System.out.println(aiPlayerAlgorithm.steps);
        System.out.println(endTime - startTime );

    }

    @Test
    void testPointAlgorithmRandom(){
        aiPlayerAlgorithm aiPlayerAlgorithm = new aiPlayerAlgorithm(roundService, blackjackGameService);

        Player ai = new Player(999, "aiPlayer", 10000);
        List<Player> players = new ArrayList<>();
        List<Card> cards;
        players.add(ai);
        Deck deck = roundService.buildDeck();
        blackjackGameService.addInitialPlayer(ai);
        BlackJackGame blackJackGame = new BlackJackGame();
        Round round;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Collections.shuffle(deck.getDeck());
            cards = deck.getDeck();
            round = new Round(deck, players);
            ai.addCardToPlayer(cards.get(0));
            ai.addCardToPlayer(cards.get(1));
            round.getDealer().addCardToDealer(cards.get(2));
            round.getDealer().addCardToDealer(cards.get(3));

            deck.setDeck(cards);
            round.setDeck(deck);
            blackJackGame.setCurrentRound(round);
            aiPlayerAlgorithm.ai = ai;
            aiPlayerAlgorithm.pointsAlgorithm(blackJackGame);
            ai.resetPlayer();

        }
        long endTime = System.currentTimeMillis();
        System.out.println(aiPlayerAlgorithm.steps);
        System.out.println(endTime - startTime );

    }

}
