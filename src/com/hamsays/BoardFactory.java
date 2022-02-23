package com.hamsays;

public class BoardFactory {
    private static final int EASY_SPEED = 1500;
    private static final int MEDIUM_SPEED = 1000;
    private static final int HARD_SPEED = 500;

    private BoardFactory() {
    }

    public static Board createBoard(Difficulty difficulty){
        Board board;

        System.out.println(difficulty);
        if (difficulty.equals(Difficulty.EASY)) {
            board = new EasyBoard(EASY_SPEED);
        }
        else if (difficulty.equals(Difficulty.MEDIUM)) {
            board = new MediumBoard(MEDIUM_SPEED);
        }
        else {
            board = new HardBoard(HARD_SPEED);
        }

        return board;
    }
}