package com.hamsays.client;

import com.hamsays.controller.HAMApp;

import java.io.IOException;

class Main {
    public static void main(String[] args) {
        HAMApp app = new HAMApp();
        try {
            app.execute();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}