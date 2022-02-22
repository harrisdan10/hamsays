package com.hamsays;

import com.apps.util.Console;

class MediumBoard extends Board {
    private int difficulty;

    public MediumBoard(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public void display() {
        getRandomColor();
        try{
            Thread.sleep(difficulty);
            Console.clear();
        }
        catch(InterruptedException ignored) {
            System.out.println("error");
        }
    }
}