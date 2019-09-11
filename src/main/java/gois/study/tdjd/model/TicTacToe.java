package gois.study.tdjd.model;

import javax.persistence.*;

@Entity
@Table(name = "tictactoe")
public class TicTacToe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer turn;
    private int x;
    private int y;
    private char player;

    public Integer getTurn() {
        return turn;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getPlayer() {
        return player;
    }

    public TicTacToe() { }

    public TicTacToe(int turn, int x, int y, char player) {
        this.turn = turn;
        this.x = x;
        this.y = y;
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicTacToe that = (TicTacToe) o;
        if (player != that.player) return false;
        if (turn != that.turn) return false;
        if (x != that.x) return false;
        if (y != that.y) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = turn;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + (int) player;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Turn: %d; X: %d; Y: %d; Player: %s", turn, x, y, player);
    }
}
