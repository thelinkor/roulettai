package Actions;

import Actions.ResultObserver;
import Actions.WheelBet;

public class NoObservation implements ResultObserver {

    @Override
    public void getWins(WheelBet[] winningBets) {
        //Empty On purpose
    }
}
