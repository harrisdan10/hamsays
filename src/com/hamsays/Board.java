package com.hamsays;

import java.util.*;

public class Board {
    private List<Player> player;
    private final List<Colors> colorsList = new ArrayList<>();

    public void display(){
        getRandomColor();
    }

    public List<Colors> getRandomColor() {
        int color = new Random().nextInt(Colors.values().length);
        Colors newColor = Colors.values()[color];
        colorsList.add(newColor);
        System.out.println(colorsList);
        return colorsList;
    }
}