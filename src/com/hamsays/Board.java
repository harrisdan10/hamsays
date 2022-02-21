package com.hamsays;

import com.apps.util.Prompter;

import java.util.*;

public class Board {
    private List<Player> player;
    private final List<Colors> colorsList = new ArrayList<>();
    private final List<Colors> playerInput = new ArrayList<>();
    Prompter prompter = new Prompter(new Scanner(System.in));

    public void display(){
//        getRandomColor();
//        promptForColor();
        checkInput();
        //gameover
    }

    public void checkInput() {
        while (colorsList.equals(playerInput)) {
            getRandomColor();
            promptForColor();
        }
    }

    //Aaron
    public List<Colors> getRandomColor() {
        int color = new Random().nextInt(Colors.values().length);
        Colors newColor = Colors.values()[color];
        colorsList.add(newColor);
        System.out.println(colorsList);
        return colorsList;
    }

    //Harris
    private List<Colors> promptForColor() {
//        List<Colors> playerInput = new ArrayList<>();
//        List<Colors> playerInput =

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
                    playerInput.add(Colors.GREEN);
                    break;
                case 'R':
                    playerInput.add(Colors.RED);
                    break;
                case 'B':
                    playerInput.add(Colors.BLUE);
                    break;
                case 'Y':
                    playerInput.add(Colors.YELLOW);
                    break;
                default:
                    System.out.println(playerInput);
                    break;
            }
        }
        System.out.println(playerInput);
//        return List<Colors> playerCheck = playerInput;
        return playerInput;
    }
}