package com.hamsays;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public abstract class Board extends Thread {
    private final List<Color> colorList = new ArrayList<>();
    private List<Color> playerColorInput;
    public boolean gameOver = false;
    Prompter prompter = new Prompter(new Scanner(System.in));

    public abstract void display();

    void getRandomColor() {
        int color = new Random().nextInt(Color.values().length);
        Color newColor = Color.values()[color];
        colorList.add(newColor);
        System.out.println(colorList);
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

    public void gameSequence() throws IOException {
        int correctCount = 0;

        display();
        promptForColor();
        Console.clear();

        while (!gameOver) {
            if (colorList.equals(playerColorInput)) {
                correctCount++;
                if (correctCount == 10) {
                    gameOver = true;
                    Console.clear();
                    Console.blankLines(2);
                    if (Files.exists(Path.of("data/win.txt"))) {
                        String line = Files.readString(Path.of("data/win.txt"));
                        System.out.println("\u001B[32m" + line + "\u001B[37m");
                    } else {
                       throw new IOException("Please verify win.txt location");
                    }
                    System.out.println("Good Job you got all " + correctCount + " correct");
                } else {
                    display();
                    promptForColor();
                    Console.clear();
                }
            } else {
                gameOver = true;
                Console.clear();
                Console.blankLines(2);
                if (Files.exists(Path.of("data/lose.txt"))) {
                    String line = Files.readString(Path.of("data/lose.txt"));
                    System.out.println("\u001B[31m" + line + "\u001B[37m");
                } else {
                    throw new IOException("Please verify lose.txt location");
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