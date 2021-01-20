package blackjackgamesocketserver.logic;

import blackjackgamesocketserver.models.BlackJackGame;
import blackjackgamesocketserver.models.Deck;
import blackjackgamesocketserver.models.Player;
import blackjackgamesocketserver.models.Round;

public interface IBlackjackGameService {
    void nextRound(Deck deck, BlackJackGame blackJackGame);
    void addWaitingPlayersToGame(Round round);
    void addPlayer(Player player);
    void addInitialPlayer(Player player);
    void removePlayer(Player player, BlackJackGame blackJackGame);
    BlackJackGame createNewGame();
    String generateCode();
}
