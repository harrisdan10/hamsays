package com.hamsays.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.hamsays.Board;

import java.util.Scanner;


public class HAMApp{
    private Board board = new Board();
    Prompter prompter = new Prompter(new Scanner(System.in));
    
    public void execute() {
        welcome();
        String name = promptForName();
        startGame();
//        gameOver();
    }


    private void welcome() {
        Console.blankLines(2);
        System.out.println("o       o o--o o      o-o  o-o  o   o o--o     o-O-o  o-o      o  o   O  o   o      o-o    O  o   o  o-o\n" +
                "|       | |    |     /    o   o |\\ /| |          |   o   o     |  |  / \\ |\\ /|     |      / \\  \\ /  |\n" +
                "o   o   o O-o  |    O     |   | | O | O-o        |   |   |     O--O o---o| O |      o-o  o---o  O    o-o\n" +
                " \\ / \\ /  |    |     \\    o   o |   | |          |   o   o     |  | |   ||   |         | |   |  |       |\n" +
                "  o   o   o--o O---o  o-o  o-o  o   o o--o       o    o-o      o  o o   oo   o     o--o  o   o  o   o--o");
        Console.blankLines(2);
    }

    private String promptForName() {  //what will we do with name?
        String name = prompter.prompt("Please enter your name: ",
                "[a-zA-Z]*( [a-zA-Z]*)?", "Please restrict name input to alphabetical characters");
        return name;
    }

    private void startGame() {
            board.gameSequence();

        /*
        System.out.println("Let's begin!");
        boolean gameOver = false;

        while (!gameOver) {
            if (board.getRandomColor().equals(board.promptForColor())) {
                displayColor();
                board.promptForColor();
            }
            else{
                gameOver = true;
                System.out.println("Sorry Game over");
            }
        }
         */
    }

    private void displayColor() {
        board.display();
    }

   /*
   private boolean gameOver() {
        boolean isOver = false;

        if ((board.getRandomColor().equals(board.promptForColor())))
        {
            System.out.println("Sorry, game over");
        }
        else{
            isOver = true;
            System.out.println("Sorry, game over");
        }

        return isOver;
    }
    */

}