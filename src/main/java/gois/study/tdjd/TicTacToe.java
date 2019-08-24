package gois.study.tdjd;

public class TicTacToe {

    public static final char BLANK = '\0';
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    private static final int SIZE = 3;

    private char lastPlayer = BLANK;

    private Character[][] board = {
            {BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK}
    };

    public String play(int x, int y) {

        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        return isWin() ? lastPlayer + " is the winner" : "No winner";
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * SIZE;
        for (int i = 0; i < SIZE; i++) {
            if ( (board[0][i] + board[1][i] + board[2][i] == playerTotal) ||
                    (board[i][0] + board[i][1] + board[i][2] == playerTotal)) {
                return true;
            }
        }
        return false;
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = lastPlayer;
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
