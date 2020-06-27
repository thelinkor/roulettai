package Game;

import java.util.ArrayList;

public class GameState {
    public static final int PLAYER_START_MONEY = 1000;

    private int playerMoney;
    private boolean isRunning;
    private int lastWinningNumber;

    public GameState() {
        this.playerMoney = PLAYER_START_MONEY;
        this.isRunning = true;
        lastWinningNumber = -1;

    }

    public int getLastWinningNumber() {
        return lastWinningNumber;
    }

    public void setLastWinningNumber(int lastWinningNumber) {
        this.lastWinningNumber = lastWinningNumber;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void addToPlayerMoney(int toAdd){
        playerMoney += toAdd;
    }
}
