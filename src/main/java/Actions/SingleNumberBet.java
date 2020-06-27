package Actions;

import Game.RouletteWheel;

public class SingleNumberBet extends WheelBet{
    private final int numberBetOn;

    public SingleNumberBet(int betAmount, int numberBetOn) {
        super(betAmount);
        assert numberBetOn >= 0;
        assert numberBetOn <= RouletteWheel.MAX_VALUE_ON_WHEEL;
        this.numberBetOn = numberBetOn;
    }

    @Override
    public int[] getNumbersBetOn() {
        return new int[]{numberBetOn};
    }
}
