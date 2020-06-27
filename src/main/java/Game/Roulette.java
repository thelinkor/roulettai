package Game;

import Actions.ActionGenerator;
import Actions.PlayerAction;
import Actions.ResultObserver;
import Actions.WheelBet;
import Game.Win.WincheckerWheel;

public class Roulette {
    private final GameState gameState;
    private final WincheckerWheel winchecker;
    private final RouletteWheel wheel;

    private final ActionGenerator player;
    private final ResultObserver observer;

    public Roulette(ActionGenerator player, ResultObserver observer){
        this.player = player;
        this.observer = observer;

        gameState = new GameState();
        winchecker = new WincheckerWheel();
        wheel = new RouletteWheel();
    }


    public boolean runGame(){
        PlayerAction action = player.getAction(gameState);
        WheelBet[] acceptedBets = TransactionHandler.payForBets(action.getWheelBets(), gameState);
        gameState.setLastWinningNumber(wheel.spin());
        WheelBet[] winningBets = winchecker.checkBets(gameState.getLastWinningNumber(), acceptedBets);
        observer.getWins(winningBets);
        TransactionHandler.getWinningsFromBets(winningBets, gameState);
        return action.getPlayerContinues();
    }


    public int getScore(){
        return gameState.getPlayerMoney();
    }
}
