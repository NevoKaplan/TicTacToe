package com.example.tictactoe;

public class Model {

    private int[][] board;
    private int boardSize = 3;

    public Model(){ this.board = new int[boardSize][boardSize]; }

    public void changeBoard(int num, int turn) { this.board[num/3][num%3] = turn; }

    public boolean checkWin() {
        int sum = 0, sum2 = 0, sum3 = 0;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sum += board[i][j];
                if (i == j)
                    sum2 += board[i][j];
                if (i+j == boardSize - 1)
                    sum3 += board[i][j];
            }
            if (Math.abs(sum) == 3 || Math.abs(sum2) == 3 || Math.abs(sum3) == 3)
                return true;
            sum = 0;
        }
        sum = 0;
        for(int j = 0; j < board[0].length; j++) {
            for(int i = 0; i < board.length; i++) {
                sum += board[i][j];
            }

            if (Math.abs(sum) == 3)
                return true;
            sum = 0;
        }
        return false;
    }

    public boolean checkDraw() {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                if (board[i][j] == 0)
                    return false;
        return true;
    }

}
