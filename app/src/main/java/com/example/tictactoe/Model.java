package com.example.tictactoe;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class Model {

    private int[][] board;
    private int boardSize = 3;

    public Model(){
    this.board = new int[boardSize][boardSize];
}

    public void changeBoard(int num, int turn) {
        switch (num) {
            case 4:
                board[0][0] = 4 * turn;
                break;
            case 9:
                board[0][1] = 9 * turn;
                break;
            case 2:
                board[0][2] = 2 * turn;
                break;
            case 3:
                board[1][0] = 3 * turn;
                break;
            case 5:
                board[1][1] = 5 * turn;
                break;
            case 7:
                board[1][2] = 7 * turn;
                break;
            case 8:
                board[2][0] = 8 * turn;
                break;
            case 1:
                board[2][1] = 1 * turn;
                break;
            default:
                board[2][2] = 6 * turn;
                break;
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++)
                System.out.println("board["+i+"]["+j+"]:" + board[i][j]);
        }
    }

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
            if (Math.abs(sum) == 15 || Math.abs(sum2) == 15 || Math.abs(sum3) == 15)
                return true;
            sum = 0;
        }
        sum = 0;
        for(int j = 0; j < board[0].length; j++) {
            for(int i = 0; i < board.length; i++) {
                sum += board[i][j];
            }

            if (Math.abs(sum) == 15)
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
