package com.hamsays.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.hamsays.Board;
import com.hamsays.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HAMApp {
    private Board board = new Board();
    Prompter prompter = new Prompter(new Scanner(System.in));
    
    public void execute() {
        welcome();
        String name = promptForName();
        startGame(name);
        promptForColor();
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

        displayColor();
    }

    private void displayColor() {
        //access random color array from Board
        //board.show();
        board.display();
    }

    private List<Colors> promptForColor() {
        List<Colors> colorsList = new ArrayList<>();

        String error = "Please choose between one of the four colors: "
                + "[" + Colors.BLUE + ", "
                + Colors.RED + ","
                + Colors.GREEN + ","
                + Colors.YELLOW + "]";

        String colors = prompter.prompt("Please enter the color(s) " +
                "that were displayed: ", "(G|g|R|r|B|b|Y|y)*?",
                error);

        char [] color = colors.toUpperCase().toCharArray();

        for (char c : color) {
            switch (c) {
                case 'G':
                    colorsList.add(Colors.GREEN);
                    break;
                case 'R':
                    colorsList.add(Colors.RED);
                    break;
                case 'B':
                    colorsList.add(Colors.BLUE);
                    break;
                case 'Y':
                    colorsList.add(Colors.YELLOW);
                    break;
                default:
                    System.out.println(colorsList);
                    break;
        }
        }
        System.out.println(colorsList);
        return colorsList;
    }


    private void gameOver(String name) {
        // if promptForColor != displayColor game will end
        // if reach success count we congratulate
    }

}