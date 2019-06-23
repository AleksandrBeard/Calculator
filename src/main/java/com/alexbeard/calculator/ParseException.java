package com.alexbeard.calculator;

public class ParseException extends Exception {

    public ParseException() {
        System.out.println("Uncorrected input data. Check it and tray again!!");
    }

    public ParseException(String message){
        this();
        System.out.println("Error at " + message );
    }
}
