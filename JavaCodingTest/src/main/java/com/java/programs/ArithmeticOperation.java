package com.java.programs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ArithmeticOperation {
    public static final Pattern operator = Pattern.compile("[+*-/]");
    public static final Pattern alphanumeric = Pattern.compile("^[a-zA-Z0-9_=;]*$");
    public static final Pattern alphabetic = Pattern.compile("^[a-zA-Z; ]*$");
    public String errorMsg = "";
    public Double total = 0.0;

    /**
     * validating input values from file and sending for operations
     * @param line
     * @return response object with operation values
     */
    protected ResponseObject inputValidation(String line) {
        ResponseObject response = new ResponseObject();
        if (alphanumeric.matcher(line).find() || alphabetic.matcher(line).find()){
            errorMsg= "Error";
        } else {
            total = arithmeticOperation(line);
        }
        response.setInput(line);
        response.setTotal(total);
        response.setErrorMessage(errorMsg);
        total = 0.0;
        errorMsg = "";
        return response;
    }

    /**
     * 4 arithmetic calculations (add , substraction, multiplication, division)
     * @param inputLine input file reading line by line
     * @return total value returns after each arithmetic operations
     */
    public Double arithmeticOperation(String inputLine) {
        double total=0.0;
        String[] splitedIntegerValues = inputLine.split("[+*-/]");
        Double[] floatingValues = Arrays.stream(splitedIntegerValues).map(e -> Double.parseDouble(e)).toArray(Double[]::new);
        List<String> split1 = Arrays.stream(inputLine.split("")).filter(e -> operator.matcher(e).find()).collect(Collectors.toList());
        Queue<String> operatorQueue = new LinkedList<>(split1);

        Double firstValue, currentValue;
        for (int i=1; i<floatingValues.length;i++){
            firstValue = floatingValues[0];
            currentValue = floatingValues[i];

            switch (operatorQueue.poll()) {
                case "+":
                    total = i==1? total+ firstValue + currentValue: total + currentValue;
                    break;

                case "-":
                    total = i==1? total + firstValue - currentValue: total - currentValue;
                    break;

                case "*":
                    total = i==1? firstValue * currentValue: total * currentValue;
                    break;

                case "/":
                    total = i==1? firstValue / currentValue: total / currentValue;
                    break;
            }
        }
        return total;
    }
}
