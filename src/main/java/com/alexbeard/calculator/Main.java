package com.alexbeard.calculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            calculator.calculate();
        } catch (IOException | ParseException e) {
            System.exit(0);
        }
    }
}
