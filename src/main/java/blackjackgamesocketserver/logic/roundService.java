package blackjackgamesocketserver.logic;

import blackjackgamesocketserver.enums.Cardvalues;
import blackjackgamesocketserver.enums.Suits;
import blackjackgamesocketserver.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class roundService {



    public Deck buildDeck(){
        List<Card> deckList = new ArrayList<Card>();

        Arrays.asList(Suits.values()).forEach(suit ->
                Arrays.asList(Cardvalues.values()).forEach(cardValue -> {
                            if (cardValue == Cardvalues.two){
                                deckList.add(new Card(suit, cardValue, 2));
                            }
                            else if (cardValue == Cardvalues.three){
                                deckList.add(new Card(suit, cardValue, 3));
                            }
                            else if (cardValue == Cardvalues.four){
                                deckList.add(new Card(suit, cardValue, 4));
                            }
                            else if (cardValue == Cardvalues.five){
                                deckList.add(new Card(suit, cardValue, 5));
                            }
                            else if (cardValue == Cardvalues.six){
                                deckList.add(new Card(suit, cardValue, 6));
                            }
                            else if (cardValue == Cardvalues.seven){
                                deckList.add(new Card(suit, cardValue, 7));
                            }
                            else if (cardValue == Cardvalues.eight){
                                deckList.add(new Card(suit, cardValue, 8));
                            }
                            else if (cardValue == Cardvalues.nine){
                                deckList.add(new Card(suit, cardValue, 9));
                            }
                            else if (cardValue == Cardvalues.ten || cardValue == Cardvalues.jack || cardValue == Cardvalues.queen || cardValue == Cardvalues.king ){
                                deckList.add(new Card(suit, cardValue, 10));
                            }
                            else if (cardValue == Cardvalues.ace){
                                deckList.add(new Card(suit, cardValue, 1));
                            }
                        }

                )
        );

        return new Deck(deckList);

    }

    public Deck shuffleDeck(){
        Deck deck = buildDeck();
        Collections.shuffle(deck.getDeck());
        return deck;
    }

    public void addInitialCardsToPlayers(Round currentRound){
        Deck deck = currentRound.getDeck();
        currentRound.getPlayers().forEach(player -> {
                    for (int i = 0; i < 2; i++) {
                        player.addCardToPlayer(deck.getDeck().get(0));
                        deck.getDeck().remove(0);
                        currentRound.setDeck(deck);
                    }
                    if (player.getContainsAce()){
                        if (player.getCards().get(0).getCardPoints() == 10 || player.getCards().get(1).getCardPoints() == 10){
                            player.setBlackjack(true);
                        }
                        else {
                            player.setBlackjack(false);
                        }
                    }
        });

    }

    public void addInitialCardsToDealer(Round currentRound){
        Deck deck = currentRound.getDeck();
        Dealer dealer = currentRound.getDealer();

        for (int i = 0; i < 2; i++) {
            dealer.addCardToDealer(deck.getDeck().get(0));
            deck.getDeck().remove(0);
            currentRound.setDeck(deck);
        }
        if (dealer.getContainsAce()){
            if (dealer.getCards().get(0).getCardPoints() == 10 || dealer.getCards().get(1).getCardPoints() == 10){
                dealer.setBlackjack(true);
            }
            else {
                dealer.setBlackjack(false);
            }
        }

    }

    public void getCard(Round currentRound){
        Deck deck = currentRound.getDeck();
        Player player = currentRound.getCurrentPlayer();

        if (player.getContainsSplit()){
            player.addCardToSplitCards(deck.getDeck().get(0));
        }else{
            player.addCardToPlayer(deck.getDeck().get(0));
        }

        deck.getDeck().remove(0);
        currentRound.setDeck(deck);
    }

    public void stand(Round currentRound){
        Player player = currentRound.getCurrentPlayer();
        if (player.getContainsSplit()){
            player.setContainsSplit(false);
        }else{
            currentRound.nextPlayer();
        }

    }

    public void doubleBet(Round currentRound){
        if (currentRound.getCurrentPlayer().getContainsSplit()){
            int bet = currentRound.getCurrentPlayer().getCurrentSplitBet();
            getCard(currentRound);
            bet = bet * 2;
            currentRound.getCurrentPlayer().setCurrentSplitBet(bet);
        }else{
            int bet = currentRound.getCurrentPlayer().getCurrentBet();
            getCard(currentRound);
            bet = bet * 2;
            currentRound.getCurrentPlayer().setCurrentBet(bet);
        }
        stand(currentRound);
    }

    public void setInitialBet(Player player, int bet){
        player.setCurrentBet(bet);
    }

    public void split(Round currentRound){
        Player currentPlayer = currentRound.getCurrentPlayer();
        Boolean allowSplit = checkSplit(currentRound);

        if (allowSplit){
            currentPlayer.setSplitDeck();
            currentPlayer.setInitialSplitBet();
            currentPlayer.setContainsSplit(true);
        }

    }

    public Boolean checkSplit(Round currentRound){
        List<Card> cards = currentRound.getCurrentPlayer().getCards();
        if (cards.size() > 2){
            return false;
        }
        else {
            if (cards.get(0).getCardValue() == cards.get(1).getCardValue()) {
                return true;
            } else {
                return false;
            }
        }
    }


    public HashMap<Integer, String> CheckWinner(Round currentRound){
        HashMap<Integer, String> results = new HashMap<>();
        List<Player> players = currentRound.getPlayers();
        for (Player player: players) {
            Dealer dealer = currentRound.getDealer();
            int playerPoints = player.getTotalCardPoints();
            int playerSplitPoints;
            int dealerPoints = dealer.getTotalCardPoints();

            if (player.getContainsAce()){
                if (playerPoints + 10 <= 21){
                    playerPoints += 10;
                }
            }
            if (dealer.getContainsAce()){
                if (dealerPoints + 10 <= 21){
                    dealerPoints += 10;
                }
            }
            if (player.getContainsSplit()){
                playerSplitPoints = player.getTotalSplitCardPoints();
                if (player.getSplitContainsAce()){
                    if (playerSplitPoints + 10 <= 21){
                        playerSplitPoints += 10;
                    }
                }
                if (player.isSplitBlackjack() && player.isBlackjack()){
                    results.put(player.getId(), "playerAndSplitBlackjack");
                }
                else if (player.isBlackjack() && !player.isSplitBlackjack()){
                    if (playerSplitPoints > dealerPoints && playerSplitPoints <= 21){
                        results.put(player.getId(), "playerBlackJackAndSplitWin");
                    }
                    else if (playerSplitPoints == dealerPoints && playerSplitPoints <= 21){
                        results.put(player.getId(), "playerBlackJackAndSplitDraw");
                    }
                    else {
                        results.put(player.getId(), "playerBlackJackAndSplitLost");
                    }
                }
                else if (!player.isBlackjack() && player.isSplitBlackjack()){
                    if (playerPoints > dealerPoints && playerPoints <= 21){
                        results.put(player.getId(), "playerWinAndSplitBlackJack");
                    }
                    else if (playerPoints == dealerPoints && playerPoints <= 21){
                        results.put(player.getId(), "playerDrawAndSplitBlackJack");
                    }
                    else {
                        results.put(player.getId(), "playerLostAndSplitBlackJack");
                    }
                }
                else{
                    if (playerPoints > dealerPoints && playerPoints <= 21){
                        if (playerSplitPoints > dealerPoints && playerSplitPoints <= 21){
                            results.put(player.getId(), "playerWinAndSplitWin");
                        }
                        else if (playerSplitPoints == dealerPoints && playerSplitPoints <= 21){
                            results.put(player.getId(), "playerWinAndSplitDraw");
                        }
                        else {
                            results.put(player.getId(), "playerWinAndSplitLost");
                        }

                    }
                    else if (playerSplitPoints > dealerPoints && playerSplitPoints <=21){
                        if (playerPoints == dealerPoints && playerPoints <= 21){
                            results.put(player.getId(), "playerDrawAndSplitWin");
                        }
                        else {
                            results.put(player.getId(), "playerLostAndSplitWin");
                        }
                    }


                }
            }
            else {
                if (player.isBlackjack()){
                    results.put(player.getId(), "playerBlackJack");
                }
                else if (playerPoints > dealerPoints && playerPoints <= 21){
                    results.put(player.getId(), "playerWin");
                }
                else if( playerPoints == dealerPoints && playerPoints <=21){
                    results.put(player.getId(), "playerDraw");
                }
                else{
                    results.put(player.getId(), "playerLost");
                }
            }
        }
        return results;
    }

    public void giveWinnings(Player player){
        if (player.isBlackjack()){
            int winnings = (int) (player.getCurrentBet() * 2.5);
            player.addMoney(winnings);
        }
        else {
            int winnings = player.getCurrentBet() * 2;
            player.addMoney(winnings);
        }
        if (player.isSplitBlackjack()){
            int splitWinnings = (int) (player.getCurrentSplitBet() * 2.5);
            player.addMoney(splitWinnings);
        }
        else {
            int splitWinnings = player.getCurrentSplitBet() * 2;
            player.addMoney(splitWinnings);
        }
    }
    //todo
    //add check to see if current points exceed 21 and if it does it should bust the player and go to the next player.




}
