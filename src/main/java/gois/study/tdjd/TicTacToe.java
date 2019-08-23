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
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        for (int index = 0; index < 3; index++) {
            if (board[0][index] == lastPlayer
                    && board[1][index] == lastPlayer
                    && board[2][index] == lastPlayer) {
                return lastPlayer + " is the winner";
            }
        }
        return "No winner";
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
