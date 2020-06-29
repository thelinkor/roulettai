package Actions;

import Game.GameState;

public class BetForXRoundsGenerator implements ActionGenerator{
    private int count;
    private final int limit;

    public BetForXRoundsGenerator(int limit) {
        count = 0;
        this.limit = limit;
    }

    @Override
    public PlayerAction getAction(GameState gameState) {
        PlayerAction action;
        if(count == limit)
            return new Quit();
        count++;
        return new PlaceBets(new SingleNumberBet(1,0));
    }
}
