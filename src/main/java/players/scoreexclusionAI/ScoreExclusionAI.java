package players.scoreexclusionAI;

import Actions.NoObservation;
import Actions.PlayerAction;
import Game.Roulette;

public class ScoreExclusionAI {
    public static final int DEFAULT_NUMBER_OF_GENERATIONS = 1_000_000;

    private final int numberOfGenerations;
    private final ActionScoreHandler actionScoreHandler;

    public ScoreExclusionAI(PlayerAction[] actions) {
        this.numberOfGenerations = DEFAULT_NUMBER_OF_GENERATIONS;
        this.actionScoreHandler = new ActionScoreHandler(actions);
    }

    public void doScoreExclusionLoop(){
        for(int i = 0 ; i < numberOfGenerations ; i++){
            playGameOnce();
        }
        System.out.println(actionScoreHandler);
    }

    private void playGameOnce(){
        Roulette game = new Roulette(actionScoreHandler, new NoObservation());
        game.runGame();
        actionScoreHandler.updateLastActionsScore(game.getScore()-1000);
        //System.out.println(game.getScore()-1000);
    }
}
