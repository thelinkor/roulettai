package Game;

import Actions.ActionGenerator;
import Actions.ResultObserver;

public class Gameplay {
    private final Roulette game;

    public Gameplay(ActionGenerator player, ResultObserver observer){
        game = new Roulette(player, observer);
    }


    public int run(){
        boolean running = true;
        while(running){
            running = game.runGame();
        }
        return game.getScore();
    }


}
