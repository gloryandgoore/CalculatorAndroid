package com.example.assignment1casey;

import java.util.ArrayList;

public class Calculator {
    ArrayList<String> inputString = new ArrayList<String>();
    ArrayList<String> calculatorHistory = new ArrayList<>();
    int index = 0;
    int result = 0;
    int solution = 0;
    int hisArrayIndex = 0;
    String expression;
    String expressionHist;

    //add expression into an array list
    public void push(String input) {
        inputString.add(index, input);
        index++;
        expression = String.join("", inputString);
    }

    //calculator function
    //takes two operands and an operator
    //calculates the result depending on operator
    public int calc(int operand1, int operand2, String operator) {

        switch (operator) {
            //addition
            case "+":
                result = operand1 + operand2;
                break;
                //subtraction
            case "-":
                result = operand1 - operand2;
                break;
            //multiplication
                case "*":
                result = operand1 * operand2;
                break;
                //division
            case "/":
                result = operand1 / operand2;
                break;

        }
        return result;
    }
    //calculate expression in the array list
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

    //add to history
    public void storeHistory(){
        expressionHist = expression+"="+solution;
        calculatorHistory.add(hisArrayIndex, expressionHist+"\n");
        hisArrayIndex++;
    }

}
