package com.hamsays;

public class BoardFactory {

    private BoardFactory() {
    }

    public static Board createBoard(Difficulty difficulty){
        Board board;

        if (difficulty == Difficulty.EASY) {
            board = new EasyBoard(3000);
        }
        else if (difficulty == Difficulty.MEDIUM){
            board = new MediumBoard(2000);
        }
        else {
            board = new HardBoard(1000);
        }

        return board;
    }
}