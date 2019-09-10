package gois.study.tdjd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TicTacToeAppTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToeApp ticTacToeApp;

    @Before
    public final void before() {
        ticTacToeApp = new TicTacToeApp();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToeApp.play(5, 2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToeApp.play(2, 5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToeApp.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToeApp.play(2, 1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX() {
        assertEquals(TicTacToeApp.PLAYER_X, ticTacToeApp.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO() {
        ticTacToeApp.play(1, 1);
        assertEquals(TicTacToeApp.PLAYER_O, ticTacToeApp.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToeApp.play(1,1);
        assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToeApp.play(1, 1); // X
        ticTacToeApp.play(1, 2); // O
        ticTacToeApp.play(2, 1); // X
        ticTacToeApp.play(2, 2); // O
        String actual = ticTacToeApp.play(3, 1); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        ticTacToeApp.play(2, 1); // X
        ticTacToeApp.play(1, 1); // O
        ticTacToeApp.play(3, 1); // X
        ticTacToeApp.play(1, 2); // O
        ticTacToeApp.play(2, 2); // X
        String actual = ticTacToeApp.play(1, 3); // O
        assertEquals("O is the winner", actual);
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        ticTacToeApp.play(1, 1); // X
        ticTacToeApp.play(1, 2); // O
        ticTacToeApp.play(2, 2); // X
        ticTacToeApp.play(1, 3); // O
        String actual = ticTacToeApp.play(3, 3); // X

        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() {
        ticTacToeApp.play(1, 3); // X
        ticTacToeApp.play(1, 1); // O
        ticTacToeApp.play(2, 2); // X
        ticTacToeApp.play(1, 2); // O
        String actual = ticTacToeApp.play(3, 1); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw() {
        ticTacToeApp.play(1, 1);
        ticTacToeApp.play(1, 2);
        ticTacToeApp.play(1, 3);
        ticTacToeApp.play(2, 1);
        ticTacToeApp.play(2, 3);
        ticTacToeApp.play(2, 2);
        ticTacToeApp.play(3, 1);
        ticTacToeApp.play(3, 3);
        String actual = ticTacToeApp.play(3, 2);
        assertEquals("The result is draw", actual);
    }

}