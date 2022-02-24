package com.hamsays.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.hamsays.Board;
import com.hamsays.BoardFactory;
import com.hamsays.Difficulty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class HAMApp{
    private Board board;
    private Difficulty level;
    Prompter prompter = new Prompter(new Scanner(System.in));
    
    public void execute () throws IOException {
        welcome();
        promptForName();
        Difficulty level = promptForDifficulty();
        board = BoardFactory.createBoard(level);
        Console.clear();
        startGame();
        replayPrompt();
    }


    private void welcome() throws IOException {
        Console.blankLines(2);

        if (Files.exists(Path.of("data/welcome.txt"))) {
            String welcome = Files.readString(Path.of("data/welcome.txt"));
            System.out.println("\u001B[34m" + welcome + "\u001B[37m");
        } else {
            throw new IOException("Please verify welcome.txt location");
        }
        Console.blankLines(2);
    }

    private void promptForName() {
        String name = prompter.prompt("What are your initials? up to 3 only please: ",
                "[a-zA-Z]{1,3}", "Please restrict name input to alphabetical characters and a limit of 3");
    }

    private Difficulty promptForDifficulty() {
        String difficulty = prompter.prompt("What difficulty would you like to play? " +
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

    private void startGame() throws IOException {
        board.gameSequence();
    }

    private void replayPrompt() throws IOException {
        String replay = prompter.prompt("Would you like to play again? Y/N?: ", "Y|y|N|n",
                "Please select either Y or N");

        replayGame(replay);
    }

    private void replayGame(String replay) throws IOException {
        String inputConversion = replay.toUpperCase();
            if ("Y".equals(inputConversion)){
                Console.clear();
                Difficulty level = promptForDifficulty();
                board = BoardFactory.createBoard(level);
                Console.clear();
                startGame();
                replayPrompt();
            }
            else {
                Console.blankLines(2);
                if (Files.exists(Path.of("data/thanks.txt"))){
                    String thanks = Files.readString(Path.of("data/thanks.txt"));
                    System.out.println("\u001B[33m" + thanks + "\u001B[37m");
                } else {
                    throw new IOException("Please verify thanks.txt location");
                }
                Console.blankLines(2);
            }
    }
}