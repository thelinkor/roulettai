package Actions;

public class Quit implements PlayerAction{

    public WheelBet[] getWheelBets() {
        return new WheelBet[0];
    }

    public boolean getPlayerContinues() {
        return false;
    }
}
