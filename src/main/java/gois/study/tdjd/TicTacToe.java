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
        char diagonal1 = '\0';
        char diagonal2 = '\0';
        for (int i = 0; i < SIZE; i++) {
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
            if ( columnPlayerWin(playerTotal, i) || linePlayerWin(playerTotal, board[i])) {
                return true;
            }
        }
        return (diagonal1 == playerTotal || diagonal2 == playerTotal) ? true : false;
    }

    private boolean linePlayerWin(int playerTotal, Character[] characters) {
        return characters[0] + characters[1] + characters[2] == playerTotal;
    }

    private boolean columnPlayerWin(int playerTotal, int i) {
        return board[0][i] + board[1][i] + board[2][i] == playerTotal;
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
