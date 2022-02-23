package com.hamsays.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.hamsays.Board;
import com.hamsays.BoardFactory;
import com.hamsays.Difficulty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class HAMApp{
    private Board board;
    private Difficulty level;
    Prompter prompter = new Prompter(new Scanner(System.in));
    
    public void execute () {
        welcome();
        promptForName();
        Difficulty level = promptForDifficulty();
        board = BoardFactory.createBoard(level);
        startGame();
    }


    private void welcome() {
        Console.blankLines(2);

        try {
            String line = Files.readString(Path.of("data/welcome.txt"));
            System.out.println("\u001B[31m" + line + "\u001B[37m");
        } catch (IOException e) {
            System.out.println(e);
        }

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