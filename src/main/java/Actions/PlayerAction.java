package Actions;

import Game.Roulette;

public interface PlayerAction {
    WheelBet[] getWheelBets();

    boolean getPlayerContinues();
}
