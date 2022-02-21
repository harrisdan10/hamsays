package com.hamsays.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.hamsays.Board;

import java.util.Scanner;


public class HAMApp {
    private Board board = new Board();
    Prompter prompter = new Prompter(new Scanner(System.in));
    
    public void execute() {
        welcome();
        String name = promptForName();
        startGame(name);
        gameOver(name);
    }


    private void welcome() {
        Console.blankLines(2);
        System.out.println("W E L C O M E  T O  H A M  S A Y S ! ! !");
        Console.blankLines(2);
    }

    private String promptForName() {  //what will we do with name?
        String name = prompter.prompt("Please enter your name: ",
                "[a-zA-Z]*( [a-zA-Z]*)?", "Please restrict name input to alphabetical characters");
        return name;
    }

    private void startGame(String name) {
        System.out.println("Let's begin " + name);

        while(!gameOver(name)){
            if(board.getRandomColor() == board.promptForColor()){
                displayColor();
                board.promptForColor();
            }
        }
    }

    private void displayColor() {
        board.display();
    }


    private boolean gameOver(String name) {
        boolean isOver = false;

//        if()
//        {
//            isOver = true;
//            System.out.println("Sorry, game over");
//        }
        // if promptForColor != displayColor game will end
        // if reach success count we congratulate
        return isOver;
    }

}