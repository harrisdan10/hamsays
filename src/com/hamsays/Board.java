package com.hamsays;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public abstract class Board extends Thread{
    private final List<Color> colorList = new ArrayList<>();
    private List<Color> playerColorInput;
    private boolean gameOver = false;
    Prompter prompter = new Prompter(new Scanner(System.in));

    public abstract void display();

    void getRandomColor() {
        synchronized (this) {
            int color = new Random().nextInt(Color.values().length);
            Color newColor = Color.values()[color];
            colorList.add(newColor);
            System.out.println(colorList);
        }
    }

     void promptForColor() {
        String error = "Please choose between one of the four colors: "
                + "[" + Color.BLUE + ", "
                + Color.RED + ","
                + Color.GREEN + ","
                + Color.YELLOW + "]";

        String colors = prompter.prompt("HAM Says the color sequence was? ", "(G|g|R|r|B|b|Y|y)*",
                error);

         addToPlayerColorInput(colors);
     }

    public void gameSequence() {
            int correctCount = 0;
            display();
            promptForColor();
            while (!gameOver) {
                if (colorList.equals(playerColorInput)) {
                    correctCount++;
                    if (correctCount == 10) {
                        gameOver = true;
                        Console.clear();
                        Console.blankLines(2);
                        try {
                            String line = Files.readString(Path.of("data/win.txt"));
                            System.out.println("\u001B[32m" + line + "\u001B[37m");
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                        System.out.println("Good Job you got all " + correctCount + " correct");
                    } else {
                        display();
                        promptForColor();
                    }
                } else {
                    gameOver = true;
                    Console.clear();
                    Console.blankLines(2);
                    try {
                        String line = Files.readString(Path.of("data/lose.txt"));
                        System.out.println("\u001B[31m" + line + "\u001B[37m");
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    System.out.println("Sorry, you lose. You got " + correctCount + " correct.");
                }
            }
        }

    private void addToPlayerColorInput(String colors) {
        playerColorInput = new ArrayList<>();
        char[] color = colors.toUpperCase().toCharArray();

        for (char currentColor : color) {
            switch (currentColor) {
                case 'G':
                    playerColorInput.add(Color.GREEN);
                    break;
                case 'R':
                    playerColorInput.add(Color.RED);
                    break;
                case 'B':
                    playerColorInput.add(Color.BLUE);
                    break;
                case 'Y':
                    playerColorInput.add(Color.YELLOW);
                    break;
                default:
                    break;
            }
        }
    }
}