package gois.study.tdjd;

public class TicTacToe {

    public static final char BLANK = '\0';
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';

    private char lastPlayer = BLANK;

    private Character[][] board = {
            {BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK}
    };

    public String play(int x, int y) {

        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        lastPlayer = nextPlayer();
        return "No winner";
    }

    private void setBox(int x, int y) {
        if (board[x-1][y-1] != BLANK) {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x-1][y-1] = PLAYER_X;
        }
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Axis is outside board");
        }
    }

    public char nextPlayer() {
        return lastPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
    }
}
