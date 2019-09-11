package gois.study.tdjd;

import gois.study.tdjd.business.TicTacToeBusiness;
import gois.study.tdjd.model.TicTacToe;

public class TicTacToeApp {

    public static final char BLANK = '\0';
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    private static final int SIZE = 3;

    private char lastPlayer = BLANK;
    private int turn = 0;
    private TicTacToeBusiness business;

    private Character[][] board = {
            {BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK}
    };

    public TicTacToeApp(TicTacToeBusiness business) {
        this.business = business;
    }

    public String play(int x, int y) {

        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(new TicTacToe(++turn, x, y, lastPlayer));
        if (isWin(x, y)) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        } else {
            return "No winner";
        }
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * 3;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        if (horizontal == playerTotal || vertical == playerTotal ||
                diagonal1 == playerTotal || diagonal2 == playerTotal) {
            return true;
        }
        return false;
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private void setBox(TicTacToe bean) {
        if (board[bean.getX() - 1][bean.getY() - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[bean.getX() - 1][bean.getY() - 1] = lastPlayer;
            if(!business.saveMove(bean)) {
                throw new RuntimeException("Saving to DB failed");
            }
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

    public TicTacToeBusiness getTicTacToeBusiness() {
        return business;
    }
}
