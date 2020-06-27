package Game.Win;

import Actions.WheelBet;

import java.util.ArrayList;
import java.util.List;

public class WincheckerWheel {

    public WheelBet[] checkBets(int numberSpun, WheelBet[] bets){
        List<WheelBet> winningBets = new ArrayList<WheelBet>(bets.length);
        for(WheelBet bet : bets){
            if(betWins(numberSpun, bet))
                winningBets.add(bet);
        }
        return winningBets.toArray(WheelBet[]::new);
    }

    private boolean betWins(int numberSpun, WheelBet bet){
        for(int numberBetOn : bet.getNumbersBetOn()){
            if(numberBetOn == numberSpun)
                return true;
        }
        return false;
    }


}
