package Game;

import java.util.Random;

public class RouletteWheel {
    public static final int MAX_VALUE_ON_WHEEL = 36;

    private final Random random;
    private int lastSpin;

    public RouletteWheel(){
        random = new Random();
    }

    public RouletteWheel(long seed){
        random = new Random(seed);
    }

    public int spin(){
        lastSpin = random.nextInt(MAX_VALUE_ON_WHEEL+1);
        return lastSpin;
    }
}
