package players.TextPlay;

import Actions.*;
import Game.GameState;
import Game.RouletteWheel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static players.TextPlay.MainTextPlay.input;

public class TextInputPlayer implements ActionGenerator, ResultObserver {
    private static final int OPTION_QUIT = 0;
    private static final int OPTION_BET = 1;

    Map<Integer, PlayerAction> actionMap;

    public TextInputPlayer() {
    }

    public PlayerAction getAction(GameState gameState) {
        printStartText(gameState);
        return chooseAction();
    }

    private void printStartText(GameState gameState){
        printLastRoundResult(gameState);
        System.out.println("Your balance is " + gameState.getPlayerMoney() +".");
        System.out.println("How do you want to bet:");
        System.out.println("0 - Quit" );
        System.out.println("1 - Bet");
    }

    private void printLastRoundResult(GameState gameState){
        if(gameState.getLastWinningNumber()>=0){
            System.out.println("Ball lands on: " + gameState.getLastWinningNumber());
            System.out.println("-----------------");
        }
    }

    private PlayerAction chooseAction(){
        int number = input.nextInt();
        if(number ==OPTION_QUIT)
            return new Quit();
        else if(number == OPTION_BET)
            return betOptions();
        return chooseAction();
    }

    private PlayerAction betOptions(){
        ArrayList<WheelBet> bets = new ArrayList<WheelBet>();

        boolean doLoop = true;
        while(doLoop) {

            System.out.println("How much do you want to bet? ");
            int betSize = input.nextInt();
            System.out.println("What do you want to bet on? ");
            System.out.println("* Single number 0-36");
            System.out.println("* -1: Even numbers");
            System.out.println("* -2: Odd numbers");
            int betNumber = input.nextInt();
            if (betSize < 0 || betNumber < -2 || betNumber > RouletteWheel.MAX_VALUE_ON_WHEEL) {
                doLoop = false;
            } else if (betNumber == -1){
                bets.add(new EvenBet(betSize));
            } else if (betNumber == -2){
                bets.add(new OddBet(betSize));
            } else{
                bets.add(new SingleNumberBet(betSize, betNumber));
            }
        }

        return new PlaceBets(bets.toArray(WheelBet[]::new));
    }

    @Override
    public void getWins(WheelBet[] winningBets) {
        System.out.println("Winning bets: ");
        for(WheelBet bet : winningBets){
            System.out.println(Arrays.toString(bet.getNumbersBetOn()) + " pays " + bet.getWinAmount());
        }
    }
}
