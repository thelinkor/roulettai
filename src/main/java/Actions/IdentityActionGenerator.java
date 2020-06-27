package Actions;

import Game.GameState;

public class IdentityActionGenerator implements ActionGenerator{
    private final PlayerAction action;

    public IdentityActionGenerator(PlayerAction action) {
        this.action = action;
    }

    @Override
    public PlayerAction getAction(GameState gameState) {
        return action;
    }
}
