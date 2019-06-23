package com.alexbeard.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    private int result;
    public int getResult() {
        return result;
    }

    private BufferedReader bufferedReader;

    public Calculator() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void calculate() throws IOException, ParseException {
        String input = bufferedReader.readLine();
        CalculatorParser calculatorParser = new CalculatorParser(input);
        calculate(calculatorParser.parse());
        if(calculatorParser.isRomeNumber()){
            Printer.printRomeResult(result);
            return;
        }
        Printer.printResult(result);

    }

    private void calculate(CalculatorParser cp) {
        String operand = cp.getOperand();
        switch(operand){
            case "+":
               result = cp.getA() + cp.getB();
               break;
            case "-":
                result = cp.getA() - cp.getB();
                break;
            case "/":
                result = cp.getA() / cp.getB();
                break;
            case "*":
                result = cp.getA() * cp.getB();
                break;
        }

    }
}
