package Actions;

public class PlaceBets implements PlayerAction{
    public static final boolean DEFAULT_SHOULD_CONTINUE = true;

    private final WheelBet[] bets;
    private final boolean shouldContinue;

    public PlaceBets(WheelBet bet){
        this(new WheelBet[]{bet});
    }

    public PlaceBets(WheelBet[] bets) {
        this(bets,DEFAULT_SHOULD_CONTINUE);
    }

    public PlaceBets(WheelBet bet, boolean shouldContinue){
        this(new WheelBet[]{bet}, shouldContinue);
    }

    public PlaceBets(WheelBet[] bets, boolean shouldContinue) {
        this.bets = bets;
        this.shouldContinue = shouldContinue;
    }

    public WheelBet[] getWheelBets() {
        return bets;
    }

    public boolean getPlayerContinues() {
        return shouldContinue;
    }
}
