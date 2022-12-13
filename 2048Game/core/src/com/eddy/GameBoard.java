package com.eddy;

public class GameBoard {
    private int[][] board;

    public GameBoard() {
        board = new int[4][4];
        initEmptyBoard();
        //input textures for 2,4,8,16,32,64,128,256,512,1028,2048
    }

    private void initEmptyBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void moveUP() {

    }
    public void moveLEFT() {

    }
    public void moveDOWN() {

    }
    public void moveRIGHT() {

    }
}
