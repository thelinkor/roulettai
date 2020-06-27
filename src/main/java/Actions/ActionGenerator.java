package Actions;

import Game.GameState;

public interface ActionGenerator {
    PlayerAction getAction(GameState gameState);
}
