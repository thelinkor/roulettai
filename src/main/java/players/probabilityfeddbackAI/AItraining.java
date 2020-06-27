package players.probabilityfeddbackAI;

import Actions.ResultObserver;
import Actions.WheelBet;

public class AItraining implements ResultObserver {
   // private final ProbabilityStorage[] actionProbabilityWeights;

    @Override
    public void getWins(WheelBet[] winningBets) {
        for(WheelBet bet : winningBets){
            for(int winningNumber : bet.getNumbersBetOn()){
                updateProbability(winningNumber, bet.getWinAmount()/bet.getBetAmount());
            }
        }
    }
    //TODO HOW DO WE EVALUATE QUIT ACTION HERE?
    private void updateProbability(int winnigNumber, int winAmountInXBet){

    }
}
