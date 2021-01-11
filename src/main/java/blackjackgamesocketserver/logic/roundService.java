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
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 2, "2H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 2, "2C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 2, "2D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 2, "2S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.three){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 3, "3H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 3, "3C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 3, "3D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 3, "3S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.four){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 4, "4H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 4, "4C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 4, "4D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 4, "4S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.five){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 5, "5H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 5, "5C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 5, "5D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 5, "5S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.six){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 6, "6H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 6, "6C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 6, "6D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 6, "6S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.seven){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 7, "7H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 7, "7C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 7, "7D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 7, "7S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.eight){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 8, "8H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 8, "8C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 8, "8D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 8, "8S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.nine){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 9, "9H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 9, "9C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 9, "9D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 9, "9S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.ten){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 10, "10H"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 10, "10C"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 10, "10D"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 10, "10S"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.jack){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 10, "JH"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 10, "JC"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 10, "JD"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 10, "JS"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.queen){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 10, "QH"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 10, "QC"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 10, "QD"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 10, "QS"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.king){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 10, "KH"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 10, "KC"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 10, "KD"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 10, "KS"));
                                        break;
                                }
                            }
                            else if (cardValue == Cardvalues.ace){
                                switch (suit) {
                                    case heart:
                                        deckList.add(new Card(suit, cardValue, 1, "AH"));
                                        break;
                                    case club:
                                        deckList.add(new Card(suit, cardValue, 1, "AC"));
                                        break;
                                    case diamond:
                                        deckList.add(new Card(suit, cardValue, 1, "AD"));
                                        break;
                                    case spade:
                                        deckList.add(new Card(suit, cardValue, 1, "AS"));
                                        break;
                                }
                            }
                        }

                )
        );
        Deck deck = new Deck();
        deck.setDeck(deckList);
        return deck;

    }

    public Deck shuffleDeck(){
        Deck deck = buildDeck();
        Collections.shuffle(deck.getDeck());
        return deck;
    }

    public void addInitialCardsToPlayers(Round currentRound){
        Deck deck = currentRound.getDeck();
        for (Player player: currentRound.getPlayers()){
            player.resetPlayer();
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
        }

    }

    public void addInitialCardsToDealer(Round currentRound){
        Deck deck = currentRound.getDeck();
        Dealer dealer = currentRound.getDealer();
        dealer.resetCards();
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
        Player currentPlayer = currentRound.getCurrentPlayer();
        for (Player player: currentRound.getPlayers()){
            if (currentPlayer.getId() == player.getId()){
                if (player.getContainsSplit()){
                    player.addCardToSplitCards(deck.getDeck().get(0));
                    checkIfBust(currentRound);
                }else{
                    player.addCardToPlayer(deck.getDeck().get(0));
                    checkIfBust(currentRound);
                }
                deck.getDeck().remove(0);
            }
        }
        currentRound.setDeck(deck);
    }

    public void getCardDealer(Round currentRound){
        Deck deck = currentRound.getDeck();
        Dealer dealer = currentRound.getDealer();
        dealer.addCardToDealer(deck.getDeck().get(0));
        deck.getDeck().remove(0);
        currentRound.setDeck(deck);
        checkIfBust(currentRound);
    }

    public void stand(Round currentRound){
        for (Player player: currentRound.getPlayers()){
            if (currentRound.getCurrentPlayer().getId() == player.getId()){
                if (player.getContainsSplit()){
                    player.setContainsSplit(false);
                    player.setSplitBust(false);
                    player.setSplitBlackjack(false);
                }else{
                    currentRound.nextPlayer();
                    break;
                }
            }
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
        for (Player player: currentRound.getPlayers()){
            if (currentPlayer.getId() == player.getId()){
                Boolean allowSplit = checkSplit(player.getCards());
                if (allowSplit){
                    player.setSplitDeck();
                    player.setInitialSplitBet();
                    player.setContainsSplit(true);
                }
            }
        }


    }

    public Boolean checkSplit(List<Card> listOfCards){
        if (listOfCards.size() > 2){
            return false;
        }
        else {
            if (listOfCards.get(0).getCardValue() == listOfCards.get(1).getCardValue()) {
                return true;
            } else {
                return false;
            }
        }
    }


    public HashMap<Integer, String> checkWinner(Round currentRound){
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

    private void checkIfBust(Round currentRound){
        Player currentplayer = currentRound.getCurrentPlayer();
        Dealer dealer = currentRound.getDealer();
        for (Player player: currentRound.getPlayers()){
            if (currentplayer.getId() == player.getId()){
                if (player.getContainsSplit()){
                    int totalsplitPoints = player.getTotalSplitCardPoints();
                    if (totalsplitPoints > 21){
                        player.setSplitBust(true);
                    }
                    else{
                        player.setSplitBust(false);
                    }
                }
                else{
                    int totalPoints = player.getTotalCardPoints();
                    if (totalPoints > 21) {
                        player.setBust(true);
                    }
                    else{
                        player.setBust(false);
                    }
                }
            }
        }

        int totalDealerCardPoints = dealer.getTotalCardPoints();
        if (totalDealerCardPoints > 21) {
            dealer.setBust(true);
        }
        else {
            dealer.setBust(false);
        }
    }




}
