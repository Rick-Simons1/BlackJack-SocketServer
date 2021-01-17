package blackjackgamesocketserver;

import blackjackgamesocketserver.enums.Cardvalues;
import blackjackgamesocketserver.enums.Suits;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.Card;
import blackjackgamesocketserver.models.Deck;
import blackjackgamesocketserver.models.Player;
import blackjackgamesocketserver.models.Round;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class roundServiceTests {

    roundService roundService = new roundService();


    @Test
    void test_addInitialCardsToPlayer_checkAceBoolean(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.five, 5, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);

        boolean actual = player.getContainsAce();

        assertEquals(true, actual);
    }

    @Test
    void test_addInitialCardsToPlayer_checkBlackjack(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8,""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);

        boolean actual = player.isBlackjack();

        assertEquals(true, actual);
    }

    @Test
    void test_addInitialCardsToDealer_checkAceBoolean(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToDealer(round);

        boolean actual = round.getDealer().getContainsAce();

        assertEquals(true, actual);
    }

    @Test
    void test_addInitialCardsToDealer_checkBlackJack(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToDealer(round);

        boolean actual = round.getDealer().isBlackjack();

        assertEquals(true, actual);
    }

    @Test
    void test_doubleBet_WithNoSplit(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.five, 5, ""));
        cards.add(new Card(Suits.club, Cardvalues.six, 6, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.setInitialBet(player, 10);
        roundService.doubleBet(round);


        int actual = round.getCurrentPlayer().getCurrentBet();

        assertEquals(20, actual);
    }

    @Test
    void test_doubleBet_WithSplit_CheckIfSplitBetIsDoubled(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.five, 5, ""));
        cards.add(new Card(Suits.club, Cardvalues.five, 5, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.heart, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.spade, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.setInitialBet(player, 10);
        roundService.split(round);
        roundService.doubleBet(round);


        int actual = round.getCurrentPlayer().getCurrentSplitBet();

        assertEquals(20, actual);
    }
    @Test
    void test_doubleBet_WithSplit_CheckIfSplitBetIsDoubledAndNormalBetDoubled(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.five, 5, ""));
        cards.add(new Card(Suits.club, Cardvalues.five, 5, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.heart, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.spade, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.setInitialBet(player, 10);
        roundService.split(round);
        roundService.doubleBet(round);
        roundService.doubleBet(round);


        int actualSplitBet = round.getCurrentPlayer().getCurrentSplitBet();
        int actualPlayerBet = round.getCurrentPlayer().getCurrentBet();

        assertEquals(20, actualSplitBet);
        assertEquals(20, actualPlayerBet);
    }

    @Test
    void test_CheckSplit_ReturnTrueRightCards(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);


        boolean actual = roundService.checkSplit(round.getCurrentPlayer().getCards());

        assertEquals(true, actual);
    }

    @Test
    void test_CheckSplit_ReturnFalseWrongCards(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);


        boolean actual = roundService.checkSplit(round.getCurrentPlayer().getCards());


        assertEquals(false, actual);
    }

    @Test
    void test_CheckSplit_ReturnFalseTooManyCards(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.getCard(round);


        boolean actual = roundService.checkSplit(round.getCurrentPlayer().getCards());


        assertEquals(false, actual);
    }

    @Test
    void test_Split_CheckIfSplitCardsHasCorrectCard(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.split(round);

        Card expected = new Card(Suits.club, Cardvalues.ace, 1, "");
        Card actual = player.getSplitCards().get(0);

        assertEquals(expected.getCardValue(), actual.getCardValue());
        assertEquals(expected.getCardSuit(), actual.getCardSuit());
    }

    @Test
    void test_Split_CheckIfSplitBetHasCorrectBet(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.setInitialBet(player, 10);
        roundService.split(round);

        int actual = player.getCurrentSplitBet();

        assertEquals(10, actual);
    }

    @Test
    void test_Split_CheckIfContainsSplitIsTrue(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.setInitialBet(player, 10);
        roundService.split(round);

        Boolean actual = player.getContainsSplit();

        assertEquals(true, actual);
    }

    @Test
    void test_setInitialBet_checkForCorrectBet(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.setInitialBet(player, 10);


        int actual = player.getCurrentBet();

        assertEquals(10, actual);
    }

    @Test
    void test_stand_withoutSplitCheckForNextPlayer(){
        Player player = new Player(1, "testuser", 100);
        Player player1 = new Player(2, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.stand(round);



        Player actual = round.getCurrentPlayer();

        assertEquals(player1.getId(), actual.getId());
    }

    @Test
    void test_stand_withSplitCheckIfSplitIsFalseAfterStand(){
        Player player = new Player(1, "testuser", 100);
        Player player1 = new Player(2, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.split(round);
        roundService.stand(round);



        Boolean actual = round.getCurrentPlayer().getContainsSplit();

        assertEquals(false, actual);
    }





    @Test
    void test_checkWinners_PlayerLostNoSplit(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.five, 5, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.checkWinner(round);

        assertEquals(false, player.getContainsSplit());
        assertEquals(false, player.isWin());
        assertEquals(false, player.isDraw());

    }

    @Test
    void test_checkWinners_PlayerDrawNoSplit(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.checkWinner(round);

        assertEquals(false, player.getContainsSplit());
        assertEquals(false, player.isWin());
        assertEquals(true, player.isDraw());
    }

    @Test
    void test_checkWinners_PlayerWinNoSplitnoBlackjack(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.checkWinner(round);

        assertEquals(false, player.getContainsSplit());
        assertEquals(false, player.isBlackjack());
        assertEquals(true, player.isWin());

    }

    @Test
    void test_checkWinners_PlayerWinWithBlackjackNoSplit(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.spade, Cardvalues.king, 10, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);


        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.checkWinner(round);

        assertEquals(false, player.getContainsSplit());
        assertEquals(true, player.isBlackjack());
        assertEquals(true, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerWinAndSplitWin(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.spade, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(true, player.isWin());

    }

    /*@Test
    void test_checkWinners_PlayerWinWithBlackJack(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.club, Cardvalues.eight, 8, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));
        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "playerBlackJack");

        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);

        assertEquals(hashMap, roundService.checkWinner(round));
    }*/

    @Test
    void test_checkWinners_PlayerWinAndSplitDraw(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.spade, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.eight, 8, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitDraw());
        assertEquals(true, player.isWin());
    }


    @Test
    void test_checkWinners_PlayerWinAndSplitLost(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.spade, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.seven, 7, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(false, player.isSplitDraw());
        assertEquals(false, player.isSplitwin());
        assertEquals(true, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerDrawAndSplitWin(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.spade, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.eight, 8, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(true, player.isDraw());
    }

    @Test
    void test_checkWinners_PlayerLostAndSplitWin(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.spade, Cardvalues.nine, 9, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.king, 10, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(false, player.isDraw());
        assertEquals(false, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerBlackJackAndSplitBlackjackFirstCardAce(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.king, 10, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.king, 10, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(true, player.isSplitBlackjack());
        assertEquals(true, player.isBlackjack());
        assertEquals(true, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerBlackJackAndSplitBlackjackFirstCardNotAce(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ten, 10, ""));
        cards.add(new Card(Suits.spade, Cardvalues.ten, 10, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.ace, 1, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(true, player.isSplitBlackjack());
        assertEquals(true, player.isBlackjack());
        assertEquals(true, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerBlackJackAndSplitWin(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.nine, 9, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.king, 10, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(false, player.isSplitBlackjack());
        assertEquals(true, player.isBlackjack());
        assertEquals(true, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerBlackJackAndSplitDraw(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.seven, 7, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.king, 10, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitDraw());
        assertEquals(true, player.isBlackjack());
        assertEquals(true, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerBlackJackAndSplitLose(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.six, 6, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.king, 10, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(false, player.isSplitDraw());
        assertEquals(false, player.isSplitwin());
        assertEquals(true, player.isBlackjack());
        assertEquals(true, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerwinAndSplitBlackJack(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.king, 10, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.nine, 9, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(true, player.isSplitBlackjack());
        assertEquals(false, player.isBlackjack());
        assertEquals(true, player.isWin());
    }

    @Test
    void test_checkWinners_PlayerDrawAndSplitBlackJack(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.king, 10, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(true, player.isSplitBlackjack());
        assertEquals(true, player.isDraw());
    }

    @Test
    void test_checkWinners_PlayerLostAndSplitBlackJack(){
        Player player = new Player(1, "testuser", 100);
        List<Player> players = new ArrayList<>();
        players.add(player);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.spade, Cardvalues.ace, 1, ""));
        cards.add(new Card(Suits.heart, Cardvalues.seven, 7, ""));
        cards.add(new Card(Suits.club, Cardvalues.ace, 1, ""));

        Deck deck = new Deck();
        deck.setDeck(cards);
        Round round = new Round(deck,players);



        roundService.addInitialCardsToPlayers(round);
        roundService.addInitialCardsToDealer(round);
        roundService.split(round);
        player.addCardToSplitCards(new Card(Suits.spade, Cardvalues.king, 10, ""));
        player.addCardToPlayer(new Card(Suits.heart, Cardvalues.six, 6, ""));
        roundService.checkWinner(round);

        assertEquals(true, player.getContainsSplit());
        assertEquals(true, player.isSplitwin());
        assertEquals(true, player.isSplitBlackjack());
        assertEquals(false, player.isDraw());
        assertEquals(false, player.isWin());
    }

    @Test
    void test_giveWinnings_withoutSplitWithBlackJack(){
        Player player = new Player(1, "testuser", 100);
        player.setBlackjack(true);
        player.setSplitBlackjack(false);
        player.setCurrentBet(10);

        roundService.giveWinnings(player);

        assertEquals(115 , player.getMoney());
    }

    @Test
    void test_giveWinnings_withoutSplit(){
        Player player = new Player(1, "testuser", 100);
        player.setBlackjack(false);
        player.setSplitBlackjack(false);
        player.setCurrentBet(10);

        roundService.giveWinnings(player);

        assertEquals(110 , player.getMoney());
    }

    @Test
    void test_giveWinnings_Split(){
        Player player = new Player(1, "testuser", 100);
        player.setBlackjack(false);
        player.setSplitBlackjack(false);
        player.setContainsSplit(true);
        player.setCurrentBet(10);
        player.setCurrentSplitBet(10);

        roundService.giveWinnings(player);

        assertEquals(120 , player.getMoney());
    }

    @Test
    void test_giveWinnings_playerAndSplitBlackJack(){
        Player player = new Player(1, "testuser", 100);
        player.setBlackjack(true);
        player.setSplitBlackjack(true);
        player.setContainsSplit(true);
        player.setWin(true);
        player.setSplitwin(true);
        player.setCurrentBet(10);
        player.setCurrentSplitBet(10);

        roundService.giveWinnings(player);

        assertEquals(130 , player.getMoney());
    }

    @Test
    void test_BuildDeck_checkIfDeckConsistsOf52Cards(){
        Deck deck = roundService.buildDeck();

        int expected = 52;

        assertEquals(expected, deck.getDeck().size());
    }

    @Test
    void test_BuildDeck_checkIfDeckisShuffeled(){
        Deck deck = roundService.shuffleDeck();
        Deck deck1 = roundService.buildDeck();


        assertNotEquals(deck,deck1);
    }




}
