package blackjackgamesocketserver.logic;

import blackjackgamesocketserver.models.Card;
import blackjackgamesocketserver.models.Deck;
import blackjackgamesocketserver.models.Player;
import blackjackgamesocketserver.models.Round;

import java.util.List;

public interface IRoundService {
    Deck buildDeck();
    Deck shuffleDeck();
    void addInitialCardsToPlayers(Round currentRound);
    void addInitialCardsToDealer(Round currentRound);
    void getCard(Round currentRound);
    void getCardDealer(Round currentRound);
    void stand(Round currentRound);
    void doubleBet(Round currentRound);
    void setInitialBet(Player player, int bet);
    void split(Round currentRound);
    Boolean checkSplit(List<Card> listOfCards);
    void checkWinner(Round currentRound);
    void giveWinnings(Player player);
    void checkIfBust(Round currentRound);


}
