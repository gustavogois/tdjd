package gois.study.tdjd.IT;

import gois.study.tdjd.TicTacToeApp;
import gois.study.tdjd.business.TicTacToeBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicTacToeAppIT {

    @Autowired
    private TicTacToeBusiness business;

    @Test
    public void givenMySQLIsRunningWhenPlayThenNoException() {
        TicTacToeApp ticTacToe = new TicTacToeApp(business);
        // The invocation of assertEquals is just as a precaution. The real
        // objective of this test is to make sure that no Exception is thrown.
        assertEquals(TicTacToeApp.NO_WINNER, ticTacToe.play(1, 1));
    }
}
