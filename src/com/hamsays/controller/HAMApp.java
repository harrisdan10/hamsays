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
    }

    private void displayColor() {
        board.display();
    }
}