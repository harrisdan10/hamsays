package com.hamsays;

import java.util.Map;

class Player {
    private String name;
    private int successCount;
    private Map<String, Integer> player;  //may not need

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSuccessCount() {
        return successCount;
    }
}