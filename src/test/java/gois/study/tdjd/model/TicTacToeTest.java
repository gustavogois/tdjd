package gois.study.tdjd.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private TicTacToe bean;

    private final Integer turn = 17;
    private final int x = 2;
    private final int y = 3;
    private final char player = 'X';

    @Before
    public void before() {
        bean = new TicTacToe(turn, x, y, player);
    }

    @Test
    public void whenInstantiatedThenIdIsStored() {
        assertEquals(turn, bean.getTurn());
    }

    @Test
    public void whenInstantiatedThenXIsStored() {
        assertEquals(x, bean.getX());
    }

    @Test
    public void whenInstantiatedThenYIsStored() {
        assertEquals(y, bean.getY());
    }

    @Test
    public void whenInstantiatedThenPlayerIsStored() {
        assertEquals(player, bean.getPlayer());
    }
}