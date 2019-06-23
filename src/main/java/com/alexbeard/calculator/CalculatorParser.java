package com.alexbeard.calculator;


public class CalculatorParser {
    private boolean isRomeNumber;
    public boolean isRomeNumber() {
        return isRomeNumber;
    }

    private String line;

    private int a, b;
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    private String operand;
    public String getOperand() {
        return operand;
    }

    public CalculatorParser(String line) {
        this.line = line;
    }

    private void checkerInputData() throws ParseException {
        if(line.length() < 2){
            throw new ParseException(format("Short input data"));
        }

        if(!(line.contains("+")||line.contains("-")||line.contains("*")||line.contains("/")))
            throw new ParseException(format("Input data doesn't contain arithmetic operand"));

        if(line.matches("[0a-zA-HJ-UWYZ]"))
            throw new ParseException(format("Input data contains '0 a-z A-H J-U W Y Z'"));

    }

    public CalculatorParser parse() throws ParseException {
        checkerInputData();
        if(line.matches("\\d{1,2}\\W{1,3}\\d{1,2}")){
            isRomeNumber = false;
            parseArabNumbers();
        }
        else if(line.matches("[XIV]*\\W{3}[XVI]*")){
            isRomeNumber = true;
            parseRomeNumbers();
        }
        else {
            throw new ParseException("Wrong input data");
        }
        return this;
    }

    private void parseRomeNumbers() throws ParseException {
        a = findRomeNumber(line.substring(0, line.indexOf(' ')));
        b = findRomeNumber(line.substring(line.lastIndexOf(' ')+1));
        operand = line.substring(line.indexOf(' ')+1, line.lastIndexOf(' '));
    }


    private void parseArabNumbers() throws ParseException {
        a = findArabNumber(line.substring(0, line.indexOf(' ')));
        b = findArabNumber(line.substring(line.lastIndexOf(' ')+1));
        operand = line.substring(line.indexOf(' ')+1, line.lastIndexOf(' '));
    }

    private int findArabNumber(String  subLine) throws ParseException {
        int x = Integer.parseInt(subLine);
        if(x > 0 && x < 11)
            return x;
        else {
            throw new ParseException("input data contain digits more 10 and less 0");
        }
    }

    private int findRomeNumber(String subLine) throws ParseException {
        if(RomeNumber.RomeToArabNumbersHM.containsKey(subLine)){
            String temp = RomeNumber.RomeToArabNumbersHM.get(subLine);
            return Integer.parseInt(temp);
        }else {
            throw new ParseException("input data contain digits more 10 and less 0");
        }
    }


    private String format(String msg){
        return String.format("%s: %s", msg, line);
    }
}
