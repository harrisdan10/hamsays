package com.hamsays;

// Michael
public enum Colors {
    GREEN("\u001B[32m" + "GREEN" + "\u001B[37m"),
    RED("\u001B[31m" + "RED" + "\u001B[37m"),
    BLUE("\u001B[34m" + "BLUE" + "\u001B[37m"),
    YELLOW("\u001B[33m" + "YELLOW" + "\u001B[37m");

    private String colorView;

    Colors(String colorView) {
        this.colorView = colorView;
    }

    public String toString() {
        return colorView;
    }
}
