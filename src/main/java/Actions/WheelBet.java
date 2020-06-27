package Actions;

import Game.Roulette;
import Game.RouletteWheel;

public abstract class WheelBet implements PayMechanic{
    private final int betAmount;
    public static final int BASE_X_BET_WIN_ON_ONE_NUMBER = RouletteWheel.MAX_VALUE_ON_WHEEL;

    public WheelBet(int betAmount) {
        this.betAmount = betAmount;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public abstract int[] getNumbersBetOn();

    public final int getWinAmount(){
        return betAmount*BASE_X_BET_WIN_ON_ONE_NUMBER/getNumbersBetOn().length;
    }

}
