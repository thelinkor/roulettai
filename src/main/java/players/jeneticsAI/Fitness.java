package players.jeneticsAI;

import Actions.BetForXRoundsGenerator;
import Actions.IdentityActionGenerator;
import Actions.NoObservation;
import Actions.PlayerAction;
import Game.Roulette;
import players.scoreexclusionAI.ScoreExlusionQuitOrBet0;

public class Fitness {
    public static final int DEFAULT_NUMBER_OF_ITERATIONS = 70_000;
    private static final PlayerAction[] possibleActions
            = {ScoreExlusionQuitOrBet0.placeBet0,
            ScoreExlusionQuitOrBet0.justQuit};


    public static Integer maxOneBet(int index) {
        Roulette game = new Roulette(new IdentityActionGenerator(possibleActions[index]), new NoObservation());
        game.runGame();
        return game.getScore()-1000;
    }


    public static Integer numberOfBetsUntilQuit(int numberOfRounds){
        int totalScore = 0;
        for(int i = 0 ; i < DEFAULT_NUMBER_OF_ITERATIONS ; i++) {
            Roulette game = new Roulette(new BetForXRoundsGenerator(numberOfRounds), new NoObservation());
            while (game.runGame()) ;
            totalScore += game.getScore() - 1000;
        }
        return totalScore;
    }

}
