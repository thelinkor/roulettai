package players.probabilityfeddbackAI;

import Actions.ActionGenerator;
import Actions.PlayerAction;
import Game.GameState;

import java.util.Random;

public class ProbabilityAI implements ActionGenerator {
    private final Random random;
    private final double[] actionProbailityWeight;
    private final PlayerAction[] actions;

    public ProbabilityAI(Random random, double[] actionProbailityWeight, PlayerAction[] actions) {
        this.random = random;
        this.actionProbailityWeight = actionProbailityWeight;
        this.actions = actions;
    }

    @Override
    public PlayerAction getAction(GameState gameState) {
        return actions[getRandomIndex()];
    }

    private int getRandomIndex(){
        double randomDouble = random.nextDouble();
        double sumOfWeightsSoFar = 0 ;
        for(int i = 0 ; i < actionProbailityWeight.length ; i++){
            sumOfWeightsSoFar += actionProbailityWeight[i];
            if(sumOfWeightsSoFar < randomDouble){
                return i;
            }
        }
        return -1;
    }
}
