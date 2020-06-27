package players.jeneticsAI;

import Actions.IdentityActionGenerator;
import Actions.NoObservation;
import Actions.PlayerAction;
import Game.Roulette;
import players.scoreexclusionAI.ScoreExlusionQuitOrBet0;

public class Fitness {
    private static final PlayerAction[] possibleActions
            = {ScoreExlusionQuitOrBet0.justQuit
            ,ScoreExlusionQuitOrBet0.placeBet0};


    public static Integer fitness(int index) {
        Roulette game = new Roulette(new IdentityActionGenerator(possibleActions[index]), new NoObservation());
        game.runGame();
        return game.getScore();
    }

}
