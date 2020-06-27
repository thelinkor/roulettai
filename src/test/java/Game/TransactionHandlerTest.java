package Game;



import Actions.SingleNumberBet;
import Actions.WheelBet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Game.GameState;


public class TransactionHandlerTest {
    GameState state;
    WheelBet[] emptyWheelBet;

    @Before
    public void setup(){
        state = new GameState();
        emptyWheelBet = new WheelBet[0];
    }

    @Test
    public void emptyBetsWork() {
        TransactionHandler.payForBets(emptyWheelBet,state);
        Assert.assertEquals(GameState.PLAYER_START_MONEY,state.getPlayerMoney());
    }

    @Test
    public void betsDrawMoneyFromPlayer(){
        WheelBet[] bets = {new SingleNumberBet(5,1), new SingleNumberBet(3,0)};
        TransactionHandler.payForBets(bets,state);
        Assert.assertEquals(GameState.PLAYER_START_MONEY-5-3,state.getPlayerMoney());
    }


    @Test
    public void getWinningsFromBets() {
    }
}