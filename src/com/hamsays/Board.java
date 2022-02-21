package com.hamsays;

import com.apps.util.Prompter;

import java.util.*;

public class Board {
    private List<Player> player;
    private final List<Color> colorList = new ArrayList<>();
    private List<Color> playerInput;
    Prompter prompter = new Prompter(new Scanner(System.in));


    public void display(){
        getRandomColor();
    }

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

        char [] color = colors.toUpperCase().toCharArray();

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
        System.out.println(playerInput);
        return playerInput;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorList, playerInput);
    }
    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if(obj instanceof Color){
            result = Objects.equals(colorList, playerInput);
        }
        return result;
    }

}