package players.scoreexclusionAI;

import Actions.*;

public class ScoreExlusionQuitOrBet0 {
    public static final PlayerAction placeBet0 = new PlaceBets(new SingleNumberBet(1,0),false);
    public static final PlayerAction justQuit = new Quit();

    public static void main(String[] args){
        PlayerAction[] actions = new PlayerAction[]{
                placeBet0,
                justQuit};
        new ScoreExclusionAI(actions).doScoreExclusionLoop();
    }
}
