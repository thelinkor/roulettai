package Actions;

import java.util.stream.IntStream;

public class EvenBet extends WheelBet{
    public EvenBet(int betAmount) {
        super(betAmount);
    }

    @Override
    public int[] getNumbersBetOn() {
        return IntStream.range(1,37).filter(x -> x % 2 == 0).toArray();
    }
}
