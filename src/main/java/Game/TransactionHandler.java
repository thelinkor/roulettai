package Game;

import Actions.WheelBet;
import Game.GameState;
import java.util.ArrayList;
import java.util.List;

class TransactionHandler {
    public static WheelBet[] payForBets(WheelBet[] bets, GameState state){
        List<WheelBet> acceptedBets = new ArrayList<WheelBet>();
        for(WheelBet bet : bets){
            if(bet.getBetAmount() <= state.getPlayerMoney()){
                state.addToPlayerMoney(-bet.getBetAmount());
                acceptedBets.add(bet);
            }
        }
        return acceptedBets.toArray(WheelBet[]::new);
    }

    public static void getWinningsFromBets(WheelBet[] bets, GameState state){
        for(WheelBet bet : bets){
            state.addToPlayerMoney(bet.getWinAmount());
        }
    }


}
