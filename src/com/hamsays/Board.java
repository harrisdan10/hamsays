package com.hamsays;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.util.*;

public abstract class Board extends Thread{
    private final List<Color> colorList = new ArrayList<>();
    private List<Color> playerInput;
    Prompter prompter = new Prompter(new Scanner(System.in));

    public abstract void display();

    //Aaron
    public List<Color> getRandomColor() {
        int color = new Random().nextInt(Color.values().length);
        Color newColor = Color.values()[color];
        colorList.add(newColor);
        System.out.println(colorList);
        return colorList;
    }

    //Harris
    public List<Color> promptForColor() {
        playerInput = new ArrayList<>();

        String error = "Please choose between one of the four colors: "
                + "[" + Color.BLUE + ", "
                + Color.RED + ","
                + Color.GREEN + ","
                + Color.YELLOW + "]";

        String colors = prompter.prompt("Please enter the color(s) " +
                        "that were displayed: ", "(G|g|R|r|B|b|Y|y)*",
                error);

        char[] color = colors.toUpperCase().toCharArray();

        for (char c : color) {
            switch (c) {
                case 'G':
                    playerInput.add(Color.GREEN);
                    break;
                case 'R':
                    playerInput.add(Color.RED);
                    break;
                case 'B':
                    playerInput.add(Color.BLUE);
                    break;
                case 'Y':
                    playerInput.add(Color.YELLOW);
                    break;
                default:
                    break;
            }
        }
        return playerInput;
    }

    public void gameSequence() {
        boolean gameOver = false;
        int incorrect = 0;
        int correct = 0;

        display();
        promptForColor();

        while (!gameOver) {
            if (colorList.equals(playerInput)) {
                display();
                promptForColor();
            }
            else {
                gameOver = true;
                System.out.println("Sorry Game over");
            }
        }
    }

}