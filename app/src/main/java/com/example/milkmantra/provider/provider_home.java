package com.example.milkmantra.provider;

import android.widget.Button;

public class provider_home {
    int number;
    String name;


    public provider_home(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}

