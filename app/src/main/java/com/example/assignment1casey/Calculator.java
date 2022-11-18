package com.example.assignment1casey;

import java.util.ArrayList;

public class Calculator {
    ArrayList<String> inputString = new ArrayList<String>();
    ArrayList<String> calculatorHistory = new ArrayList<>();
    int index = 0;
    int result = 0;
    int solution = 0;
    int hisArrayIndex = 0;
    String joined;
    String hisJoinedString;

    public void push(String input) {
        inputString.add(index, input);
        index++;
        joined = String.join("", inputString);
    }

    public int calc(int operand1, int operand2, String operator) {

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;

        }
        return result;
    }
    public int calculate() {
        for (int i = 0; i < inputString.size(); i++) {
            if ((inputString.get(i).equals("-")) ||
                    (inputString.get(i).equals("+")) ||
                    (inputString.get(i).equals("/")) ||
                    (inputString.get(i).equals("*")))
            {
                String op = inputString.get(i);
                int num1;

                if (i==1) {
                    num1 = Integer.parseInt(inputString.get(i - 1));
                }
                else {num1=solution;}
                int num2 = Integer.parseInt(inputString.get(i + 1));
                solution = calc(num1,num2,op);
            }
        }
        return solution;
    }

    public void storeHistory(){
        hisJoinedString = joined+"="+solution;
        calculatorHistory.add(hisArrayIndex, hisJoinedString+"\n");
        hisArrayIndex++;
    }

}
