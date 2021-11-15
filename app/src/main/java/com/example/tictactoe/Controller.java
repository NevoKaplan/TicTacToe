package com.example.tictactoe;

public class Controller {

    private Model model;
    private String p1;
    private String p2;
    private int turn;


    public Controller(String p1, String p2){
        this.model = new Model();
        this.p1 = p1;
        this.p2 = p2;
        turn = 0;
    }

    public String setMove(int tag) {
        turn++;
        if ((turn-1) % 2 == 0) {
            model.changeBoard(tag, 1);
            return p2;
        }
        model.changeBoard(tag, -1);
        return p1;
    }

    public int check() {
        boolean flag = model.checkWin();
        if (!flag) {
            if (model.checkDraw())
                return 1; // a tie
            else
                return 0; // no one won
        }
        else
            return 2; // a player won
    }
}
