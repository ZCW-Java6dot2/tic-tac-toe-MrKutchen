package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    Character [][] board;
    boolean didWin = false;
    String whoWon = "";

    public Board(Character[][] matrix) {
        this.board = matrix;
    }

    public Boolean isInFavorOfX() {

        return getWhoWon().equals("X");
    }

    public Boolean isInFavorOfO() {

        return getWhoWon().equals("O");
    }

    public Boolean isTie() {

        return getWhoWon().equals("");
    }

    public String getWhoWon() {

        //horizontal
        for (int i = 0; i < 3; i++) {
            checkBoard(board[i][0], board[i][1], board[i][2]);
            if (didWin) {
                return whoWon;
            }
        }
        //vertical
        for (int i = 0; i < 3; i++) {
            checkBoard(board[0][i], board[1][i], board[2][i]);
            if (didWin) {
                return whoWon;
            }
        }

        //diagonal
        checkBoard(board[0][0], board[1][1], board[2][2]);
        if (didWin) {
            return whoWon;
        }
        checkBoard(board[0][2], board[1][1], board[2][0]);
        if (didWin) {
            return whoWon;
        }
        return "";
    }

    public void checkBoard(Character squareOne, Character squareTwo, Character squareThree) {

        if( squareOne == squareTwo && squareTwo == squareThree && squareOne != ' ') {
            if (squareOne == 'X') {
                didWin = true;
                whoWon = "X";
            } else if (squareOne == 'O') {
                didWin = true;
                whoWon = "O";
            } else {
                whoWon = " ";
            }
        }
    }

}
