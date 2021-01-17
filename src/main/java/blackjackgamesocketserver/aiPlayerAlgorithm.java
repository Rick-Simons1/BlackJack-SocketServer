package blackjackgamesocketserver;

import blackjackgamesocketserver.enums.Cardvalues;
import blackjackgamesocketserver.logic.blackjackGameService;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.*;

import java.util.ArrayList;
import java.util.List;

public class aiPlayerAlgorithm {

    private roundService roundService;
    private blackjackGameService blackjackGameService;
    public Player ai;
    public int steps = 0;


    public aiPlayerAlgorithm(blackjackgamesocketserver.logic.roundService roundService, blackjackgamesocketserver.logic.blackjackGameService blackjackGameService) {
        this.roundService = roundService;
        this.blackjackGameService = blackjackGameService;
    }



    public BlackJackGame runAiAlgorithm(BlackJackGame blackJackGame){
        for (Player player: blackJackGame.getCurrentRound().getPlayers()){
            if (player.getId() == 999){
                this.ai = player;
            }
        }
        splitAlgorithm(blackJackGame);
        while (blackJackGame.getCurrentRound().getCurrentPlayer().getId() == ai.getId() && !blackJackGame.getCurrentRound().isDealersTurn()){
            /*if (!ai.getContainsSplit()){
                aceAlgorithm(blackJackGame);
            }
            else {
                if (ai.getSplitCards().size() == 1){
                    this.roundService.getCard(blackJackGame.getCurrentRound());
                }
                aceAlgorithm(blackJackGame);
            }*/
            aceAlgorithm(blackJackGame);
            pointsAlgorithm(blackJackGame);
        }

        return blackJackGame;

    }

    public void splitAlgorithm(BlackJackGame blackJackGame){
        Dealer dealer = blackJackGame.getCurrentRound().getDealer();
        List<Card> playerCards = ai.getCards();
        Round currentRound = blackJackGame.getCurrentRound();
        Cardvalues firstCardValue = playerCards.get(0).getCardValue();

        steps++;
        if (this.roundService.checkSplit(playerCards) && ai.getSplitCards().size() == 0){
            steps++;
            if (firstCardValue == Cardvalues.two || firstCardValue == Cardvalues.three ){
                steps++;
                if (dealer.getVisibleCard().getCardValue() == Cardvalues.two || dealer.getVisibleCard().getCardValue() == Cardvalues.three || dealer.getVisibleCard().getCardValue() == Cardvalues.four || dealer.getVisibleCard().getCardValue() == Cardvalues.five || dealer.getVisibleCard().getCardValue() == Cardvalues.six || dealer.getVisibleCard().getCardValue() == Cardvalues.seven){
                    this.roundService.split(currentRound);
                    steps++;
                }
            }
            else if (firstCardValue == Cardvalues.four){
                steps++;
                if (dealer.getVisibleCard().getCardValue() == Cardvalues.five || dealer.getVisibleCard().getCardValue() == Cardvalues.six ||dealer.getVisibleCard().getCardValue() == Cardvalues.seven){
                    this.roundService.split(currentRound);
                    steps++;
                }
            }
            else if(firstCardValue == Cardvalues.six){
                steps++;
                if (dealer.getVisibleCard().getCardValue() == Cardvalues.two || dealer.getVisibleCard().getCardValue() == Cardvalues.three || dealer.getVisibleCard().getCardValue() == Cardvalues.four || dealer.getVisibleCard().getCardValue() == Cardvalues.five || dealer.getVisibleCard().getCardValue() == Cardvalues.six ){
                    this.roundService.split(currentRound);
                    steps++;
                }
            }
            else if (firstCardValue == Cardvalues.seven){
                steps++;
                if (dealer.getVisibleCard().getCardValue() == Cardvalues.two || dealer.getVisibleCard().getCardValue() == Cardvalues.three || dealer.getVisibleCard().getCardValue() == Cardvalues.four || dealer.getVisibleCard().getCardValue() == Cardvalues.five || dealer.getVisibleCard().getCardValue() == Cardvalues.six || dealer.getVisibleCard().getCardValue() == Cardvalues.seven){
                    this.roundService.split(currentRound);
                    steps++;
                }
            }
            else if (firstCardValue == Cardvalues.eight){
                steps++;
                steps++;
                this.roundService.split(currentRound);
            }
            else if (firstCardValue == Cardvalues.nine){
                steps++;
                if (dealer.getVisibleCard().getCardValue() == Cardvalues.seven || dealer.getVisibleCard().getCardValue() == Cardvalues.ten || dealer.getVisibleCard().getCardValue() == Cardvalues.jack || dealer.getVisibleCard().getCardValue() == Cardvalues.queen || dealer.getVisibleCard().getCardValue() == Cardvalues.king || dealer.getVisibleCard().getCardValue() == Cardvalues.ace){
                    this.roundService.split(currentRound);
                    steps++;
                }
            }else if (firstCardValue == Cardvalues.ace){
                steps++;
                steps++;
                this.roundService.split(currentRound);
            }
        }



    }

    public void splitNoDoubleAlgorithm(){

    }

    public void aceAlgorithm(BlackJackGame blackJackGame){
        Dealer dealer = blackJackGame.getCurrentRound().getDealer();
        Card visibleDealerCard = dealer.getVisibleCard();
        List<Card> playerCards = ai.getCards();
        List<Card> playerSplitCards = ai.getSplitCards();
        Round currentRound = blackJackGame.getCurrentRound();
        int notAceIndex = 0;


        if (!ai.getContainsSplit()){
            steps++;
            if (ai.getContainsAce() && playerCards.size() == 2) {
                steps++;
                for (Card card : playerCards) {
                    if (card.getCardValue() != Cardvalues.ace) {
                        notAceIndex = playerCards.indexOf(card);
                    }
                }
                if (playerCards.get(notAceIndex).getCardValue() == Cardvalues.two || playerCards.get(notAceIndex).getCardValue() == Cardvalues.three) {
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    } else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                } else if (playerCards.get(notAceIndex).getCardValue() == Cardvalues.four || playerCards.get(notAceIndex).getCardValue() == Cardvalues.five) {
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    } else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                } else if (playerCards.get(notAceIndex).getCardValue() == Cardvalues.six) {
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    } else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                } else if (playerCards.get(notAceIndex).getCardValue() == Cardvalues.seven) {
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    } else if (visibleDealerCard.getCardValue() == Cardvalues.seven || visibleDealerCard.getCardValue() == Cardvalues.eight) {
                        this.roundService.stand(currentRound);
                        steps++;
                    } else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                } else {
                    this.roundService.stand(currentRound);
                    steps++;
                    steps++;
                }
            }
        }else {
            steps++;
            if (ai.getSplitContainsAce() && playerSplitCards.size() == 2) {
                steps++;
                for (Card card : playerSplitCards) {
                    if (card.getCardValue() != Cardvalues.ace) {
                        notAceIndex = playerSplitCards.indexOf(card);
                    }
                }
                if (playerSplitCards.get(notAceIndex).getCardValue() == Cardvalues.two || playerSplitCards.get(notAceIndex).getCardValue() == Cardvalues.three) {
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    } else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                } else if (playerSplitCards.get(notAceIndex).getCardValue() == Cardvalues.four || playerSplitCards.get(notAceIndex).getCardValue() == Cardvalues.five) {
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    } else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                } else if (playerSplitCards.get(notAceIndex).getCardValue() == Cardvalues.six) {
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    } else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                } else if (playerSplitCards.get(notAceIndex).getCardValue() == Cardvalues.seven) {
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six) {
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    } else if (visibleDealerCard.getCardValue() == Cardvalues.seven || visibleDealerCard.getCardValue() == Cardvalues.eight) {
                        this.roundService.stand(currentRound);
                        steps++;
                    } else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                } else {
                    this.roundService.stand(currentRound);
                    steps++;
                    steps++;
                }
            }
        }



    }


    public void pointsAlgorithm(BlackJackGame blackJackGame){
        Dealer dealer = blackJackGame.getCurrentRound().getDealer();
        Card visibleDealerCard = dealer.getVisibleCard();
        Round currentRound = blackJackGame.getCurrentRound();
        int totalPoints = ai.getTotalCardPoints();

        if (ai.getId() == currentRound.getCurrentPlayer().getId() && !currentRound.isDealersTurn()){
            if (ai.getContainsSplit()){
                steps++;
                int totalsplitPoints = ai.getTotalSplitCardPoints();
                /*if (ai.getSplitCards().size() == 1){
                    this.roundService.getCard(currentRound);
                }
                else {*/
                    if (ai.isSplitBlackjack()){
                        this.roundService.stand(currentRound);
                    }
                    else {
                        if(totalsplitPoints <= 8){
                            this.roundService.getCard(currentRound);
                            steps++;
                            steps++;
                        }
                        else if (totalsplitPoints == 9){
                            steps++;
                            if (visibleDealerCard.getCardValue() == Cardvalues.two){
                                this.roundService.getCard(currentRound);
                                steps++;
                            }
                            else if (visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six ){
                                this.roundService.doubleBet(currentRound);
                                steps++;
                            }
                            else {
                                this.roundService.getCard(currentRound);
                                steps++;
                            }
                        }
                        else if (totalsplitPoints == 10){
                            steps++;
                            if (visibleDealerCard.getCardValue() != Cardvalues.jack && visibleDealerCard.getCardValue() != Cardvalues.queen && visibleDealerCard.getCardValue() != Cardvalues.king && visibleDealerCard.getCardValue() != Cardvalues.ace){
                                this.roundService.doubleBet(currentRound);
                                steps++;
                            }
                            else {
                                this.roundService.getCard(currentRound);
                                steps++;
                            }
                        }
                        else if (totalsplitPoints == 11){
                            steps++;
                            steps++;
                            this.roundService.doubleBet(currentRound);
                        }
                        else if (totalsplitPoints == 12){
                            steps++;
                            if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three){
                                this.roundService.getCard(currentRound);
                                steps++;
                            }
                            else if(visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six){
                                this.roundService.stand(currentRound);
                                steps++;
                            }
                            else {
                                this.roundService.getCard(currentRound);
                                steps++;
                            }
                        }
                        else if (totalsplitPoints == 13 || totalsplitPoints == 14 || totalsplitPoints == 15 || totalsplitPoints == 16){
                            steps++;
                            if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six){
                                this.roundService.stand(currentRound);
                                steps++;
                            }
                            else {
                                this.roundService.getCard(currentRound);
                                steps++;
                            }
                        }
                        else{
                            this.roundService.stand(currentRound);
                            steps++;
                            steps++;
                        }
                    }
                /*}*/
            }
            else {
                steps++;
                if(totalPoints <= 8){
                    steps++;
                    steps++;
                    this.roundService.getCard(currentRound);
                }
                else if (totalPoints == 9){
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.two){
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                    else if (visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six ){
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    }
                    else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                }
                else if (totalPoints == 10){
                    steps++;
                    if (visibleDealerCard.getCardValue() != Cardvalues.jack && visibleDealerCard.getCardValue() != Cardvalues.queen && visibleDealerCard.getCardValue() != Cardvalues.king && visibleDealerCard.getCardValue() != Cardvalues.ace){
                        this.roundService.doubleBet(currentRound);
                        steps++;
                    }
                    else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                }
                else if (totalPoints == 11){
                    steps++;
                    steps++;
                    this.roundService.doubleBet(currentRound);
                }
                else if (totalPoints == 12){
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three){
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                    else if(visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six){
                        this.roundService.stand(currentRound);
                        steps++;
                    }
                    else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                }
                else if (totalPoints == 13 || totalPoints == 14 || totalPoints == 15 || totalPoints == 16){
                    steps++;
                    if (visibleDealerCard.getCardValue() == Cardvalues.two || visibleDealerCard.getCardValue() == Cardvalues.three || visibleDealerCard.getCardValue() == Cardvalues.four || visibleDealerCard.getCardValue() == Cardvalues.five || visibleDealerCard.getCardValue() == Cardvalues.six){
                        this.roundService.stand(currentRound);
                        steps++;
                    }
                    else {
                        this.roundService.getCard(currentRound);
                        steps++;
                    }
                }
                else{
                    this.roundService.stand(currentRound);
                    steps++;
                    steps++;
                }
            }
        }

    }


}

