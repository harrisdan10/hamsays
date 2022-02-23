package com.hamsays.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.hamsays.Board;
import com.hamsays.BoardFactory;
import com.hamsays.Difficulty;

import java.util.Scanner;


public class HAMApp{
    private Board board;
    private Difficulty level;
    Prompter prompter = new Prompter(new Scanner(System.in));
    
    public void execute() {
        welcome();
        promptForName();
        Difficulty level = promptForDifficulty();
        board = BoardFactory.createBoard(level);
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

    private Difficulty promptForDifficulty() {
        String difficulty = prompter.prompt("Please choose from one of the following difficulties: " +
                "[E]asy, [M]edium, [H]ard: ", "E|e|M|m|H|h", "Please choose a valid difficulty " +
                "level: [E]asy, [M]edium, or [H]ard");

        String inputConversion = difficulty.toUpperCase();

        switch(inputConversion) {
            case "E":
                level = Difficulty.EASY;
                break;
            case "M":
                level = Difficulty.MEDIUM;
                break;
            case "H":
                level = Difficulty.HARD;
                break;
            default:
                break;
        }
        return level;
    }

    private void startGame() {
        board.gameSequence();
    }

}