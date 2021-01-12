package blackjackgamesocketserver;

import blackjackgamesocketserver.enums.Cardvalues;
import blackjackgamesocketserver.logic.blackjackGameService;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.BlackJackGame;
import blackjackgamesocketserver.models.Card;
import blackjackgamesocketserver.models.Dealer;
import blackjackgamesocketserver.models.Player;

import java.util.ArrayList;
import java.util.List;

public class aiPlayerAlgorithm {

    private BlackJackGame blackJackGame;
    private roundService roundService;
    private blackjackGameService blackjackGameService;
    private Player ai;


    public aiPlayerAlgorithm(BlackJackGame blackJackGame, blackjackgamesocketserver.logic.roundService roundService, blackjackgamesocketserver.logic.blackjackGameService blackjackGameService) {
        this.blackJackGame = blackJackGame;
        this.roundService = roundService;
        this.blackjackGameService = blackjackGameService;
        for (Player player: blackJackGame.getCurrentRound().getPlayers()){
            if (player.getId() == 999){
                this.ai = player;
            }
        }
    }



    public BlackJackGame runAiAlgorithm(){

    }

    public void splitAlgorithm(){
        Dealer dealer = blackJackGame.getCurrentRound().getDealer();
        List<Card> playerCards = ai.getCards();


    }

    public void splitNoDoubleAlgorithm(){

    }

    public void aceAlgorithm(){
        Dealer dealer = blackJackGame.getCurrentRound().getDealer();
        Card visibleDealerCard = dealer.getVisibleCard();
        List<Card> playerCards = ai.getCards();

        if (ai.getContainsSplit()){

        }
        else {
            if (ai.getContainsAce() && playerCards.size() == 2) {
                int notAceIndex = 0;
                for (Card card : playerCards) {
                    if (card.getCardValue() != Cardvalues.ace) {
                        notAceIndex = playerCards.indexOf(card);
                    }
                }
                if (playerCards.get(notAceIndex).getCardValue() == Cardvalues.two || playerCards.get(notAceIndex).getCardValue() == Cardvalues.three) {
                    if (visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(blackJackGame.getCurrentRound());
                    } else {
                        this.roundService.getCard(blackJackGame.getCurrentRound());
                    }
                } else if (playerCards.get(notAceIndex).getCardValue() == Cardvalues.four || playerCards.get(notAceIndex).getCardValue() == Cardvalues.five) {
                    if (visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(blackJackGame.getCurrentRound());
                    } else {
                        this.roundService.getCard(blackJackGame.getCurrentRound());
                    }
                } else if (playerCards.get(notAceIndex).getCardValue() == Cardvalues.six) {
                    if (visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(blackJackGame.getCurrentRound());
                    } else {
                        this.roundService.getCard(blackJackGame.getCurrentRound());
                    }
                } else if (playerCards.get(notAceIndex).getCardValue() == Cardvalues.seven) {
                    if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(blackJackGame.getCurrentRound());
                    } else if (visibleDealerCard.getCardValue() == Cardvalues.seven || visibleDealerCard.getCardValue() == Cardvalues.eight) {
                        this.roundService.stand(blackJackGame.getCurrentRound());
                    } else {
                        this.roundService.getCard(blackJackGame.getCurrentRound());
                    }
                } else {
                    this.roundService.stand(blackJackGame.getCurrentRound());
                }
            }
        }

    }


    public void pointsAlgorithm(){
        Dealer dealer = blackJackGame.getCurrentRound().getDealer();
        Card visibleDealerCard = dealer.getVisibleCard();
        int totalPoints = ai.getTotalCardPoints();

        if (ai.getContainsSplit()){
            int totalsplitPoints = ai.getTotalSplitCardPoints();
            if (ai.getSplitCards().size() == 1){
                this.roundService.getCard(blackJackGame.getCurrentRound());
            }
            else {
                if (ai.isSplitBlackjack()){
                    this.roundService.stand(blackJackGame.getCurrentRound());
                }
                else {
                    if(totalsplitPoints <= 8){
                        this.roundService.getCard(blackJackGame.getCurrentRound());
                    }
                    else if (totalsplitPoints == 9){
                        if (visibleDealerCard.getCardValue() == Cardvalues.two){
                            this.roundService.getCard(blackJackGame.getCurrentRound());
                        }
                        else if (visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six ){
                            this.roundService.doubleBet(blackJackGame.getCurrentRound());
                        }
                        else {
                            this.roundService.getCard(blackJackGame.getCurrentRound());
                        }
                    }
                    else if (totalsplitPoints == 10){
                        if (visibleDealerCard.getCardValue() != Cardvalues.jack && visibleDealerCard.getCardValue() != Cardvalues.queen && visibleDealerCard.getCardValue() != Cardvalues.king && visibleDealerCard.getCardValue() != Cardvalues.ace){
                            this.roundService.doubleBet(blackJackGame.getCurrentRound());
                        }
                        else {
                            this.roundService.getCard(blackJackGame.getCurrentRound());
                        }
                    }
                    else if (totalsplitPoints == 11){
                        this.roundService.doubleBet(blackJackGame.getCurrentRound());
                    }
                    else if (totalsplitPoints == 12){
                        if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three){
                            this.roundService.getCard(blackJackGame.getCurrentRound());
                        }
                        else if(visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six){
                            this.roundService.stand(blackJackGame.getCurrentRound());
                        }
                        else {
                            this.roundService.getCard(blackJackGame.getCurrentRound());
                        }
                    }
                    else if (totalsplitPoints == 13 || totalsplitPoints == 14 || totalsplitPoints == 15 || totalsplitPoints == 16){
                        if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six){
                            this.roundService.stand(blackJackGame.getCurrentRound());
                        }
                        else {
                            this.roundService.getCard(blackJackGame.getCurrentRound());
                        }
                    }
                    else{
                        this.roundService.stand(blackJackGame.getCurrentRound());
                    }
                }
            }
        }
        else {
            if(totalPoints <= 8){
                this.roundService.getCard(blackJackGame.getCurrentRound());
            }
            else if (totalPoints == 9){
                if (visibleDealerCard.getCardValue() == Cardvalues.two){
                    this.roundService.getCard(blackJackGame.getCurrentRound());
                }
                else if (visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six ){
                    this.roundService.doubleBet(blackJackGame.getCurrentRound());
                }
                else {
                    this.roundService.getCard(blackJackGame.getCurrentRound());
                }
            }
            else if (totalPoints == 10){
                if (visibleDealerCard.getCardValue() != Cardvalues.jack && visibleDealerCard.getCardValue() != Cardvalues.queen && visibleDealerCard.getCardValue() != Cardvalues.king && visibleDealerCard.getCardValue() != Cardvalues.ace){
                    this.roundService.doubleBet(blackJackGame.getCurrentRound());
                }
                else {
                    this.roundService.getCard(blackJackGame.getCurrentRound());
                }
            }
            else if (totalPoints == 11){
                this.roundService.doubleBet(blackJackGame.getCurrentRound());
            }
            else if (totalPoints == 12){
                if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three){
                    this.roundService.getCard(blackJackGame.getCurrentRound());
                }
                else if(visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six){
                    this.roundService.stand(blackJackGame.getCurrentRound());
                }
                else {
                    this.roundService.getCard(blackJackGame.getCurrentRound());
                }
            }
            else if (totalPoints == 13 || totalPoints == 14 || totalPoints == 15 || totalPoints == 16){
                if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six){
                    this.roundService.stand(blackJackGame.getCurrentRound());
                }
                else {
                    this.roundService.getCard(blackJackGame.getCurrentRound());
                }
            }
            else{
                this.roundService.stand(blackJackGame.getCurrentRound());
            }
        }
    }


}

