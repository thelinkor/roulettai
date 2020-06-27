package players.scoreexclusionAI;

import Actions.ActionGenerator;
import Actions.PlayerAction;
import Game.GameState;

import java.util.Arrays;
import java.util.Random;

public class ActionScoreHandler implements ActionGenerator {
    public static final int DEFAULT_LOWER_SCORE_BOUND = -1_000;

    private final PlayerAction[] allActions;
    private final int[] actionScores;
    private final int lowerScoreBound;

    private final Random random;

    private PlayerAction[] avalibleActions;
    private int lastActionIndex;

    public ActionScoreHandler(PlayerAction[] actions) {
        this.allActions = actions;
        this.actionScores = new int[actions.length];
        this.lowerScoreBound = DEFAULT_LOWER_SCORE_BOUND;
        this.avalibleActions = actions;
        this.random = new Random();
    }

    @Override
    public PlayerAction getAction(GameState gameState) {
        lastActionIndex = random.nextInt(avalibleActions.length);
        return avalibleActions[lastActionIndex];
    }

    public void updateLastActionsScore(int score){
        actionScores[lastActionIndex] += score;
        if(actionScores[lastActionIndex] < lowerScoreBound){
            removeFromAvalible(lastActionIndex);
        }
    }

    private void removeFromAvalible(int removeAction){
        if(avalibleActions.length > 1) {
            PlayerAction[] newAvalibleArray = new PlayerAction[avalibleActions.length-1];
            int addIndex = 0;
            for(int i = 0 ; i < avalibleActions.length; i++){
                if(i != removeAction){
                    newAvalibleArray[addIndex] = avalibleActions[i];
                    addIndex++;
                }
            }
            avalibleActions = newAvalibleArray;
        }
    }

    @Override
    public String toString() {
        return "ActionScoreHandler{" +
                "allActions=" + Arrays.toString(allActions) +
                ", actionScores=" + Arrays.toString(actionScores) +
                ", lowerScoreBound=" + lowerScoreBound +
                ", random=" + random +
                ", avalibleActions=" + Arrays.toString(avalibleActions) +
                ", lastActionIndex=" + lastActionIndex +
                '}';
    }
}
