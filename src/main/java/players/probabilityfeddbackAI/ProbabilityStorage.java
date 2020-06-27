package players.probabilityfeddbackAI;

import java.util.Random;

public class ProbabilityStorage {
    private final Random random;
    private final double[] actionProbailityWeight;


    public static ProbabilityStorage getUniformWeights(int numberOfActions){
        return new ProbabilityStorage(numberOfActions);
    }

    private ProbabilityStorage(int numberOfActions) {
        random = new Random();
        actionProbailityWeight = new double[numberOfActions];
        for(int i = 0 ; i < numberOfActions ; i++){
            actionProbailityWeight[i] = 1/numberOfActions;
        }
    }

    public int getRandomIndex(){
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

    public void updateIndex(int indexToUpdate){
        
    }
}
