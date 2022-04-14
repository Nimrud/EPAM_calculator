package com.epam.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator {

    private static final String NOTATION = "--notation=";
    private static final String TYPE = "prefix|infix|postfix";
    private static final String DESIRED_PARAMETER = NOTATION + "(" + TYPE + ")+";
    private static final String DIGIT = "(-)?(\\d+)((\\.)(\\d{0,3}))?";
    private static final String OPERATOR = "(-|\\+|\\*|\\/)";
    private static final String LEFT_BRACES = "\\(";
    private static final String RIGHT_BRACES = "\\)";
    private int numberCounter = 0;
    private int operatorCounter = 0;
    private int leftBracesCounter = 0;
    private int rightBracesCounter = 0;

    boolean checkParameter(String[] array) {
        Pattern pattern = Pattern.compile(DESIRED_PARAMETER);
        Matcher matcher = pattern.matcher(array[0]);
        return matcher.matches();
    }

    private boolean assessArgument(String argument, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(argument);
        return matcher.matches();
    }

    boolean checkArguments(String[] array) {
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            if (assessArgument(array[i], DIGIT)) {
                numberCounter++;
                counter++;
            } else if (assessArgument(array[i], OPERATOR)) {
                operatorCounter++;
                counter++;
            } else if (assessArgument(array[i], LEFT_BRACES)) {
                leftBracesCounter++;
                counter++;
            } else if (assessArgument(array[i], RIGHT_BRACES)) {
                rightBracesCounter++;
                counter++;
            };
        }
        return assessAllArguments(array, counter);
    }

    private boolean checkBracesOrder(String[] array) {
        int left = 0;
        int right = 0;
        for (String s : array) {
            if (assessArgument(s, LEFT_BRACES)) {
                left++;
            } else if (assessArgument(s, RIGHT_BRACES)) {
                right++;
            }
            if (right > left) {
                return false;
            }
        }
        return true;
    }

    private boolean assessAllArguments(String[] array, int counter) {
        boolean areAllNumbersOrOperators = counter == array.length - 1;
        boolean areEnoughNumbers = numberCounter >= 1;
        boolean areEnoughNumbersAndOperators = numberCounter == operatorCounter + 1;
        boolean areEnoughBraces = leftBracesCounter == rightBracesCounter;

        if ((areAllNumbersOrOperators)
                && (areEnoughNumbersAndOperators)
                && (areEnoughNumbers)
                && (areEnoughBraces)
                && checkBracesOrder(array)){
            return true;
        } else {
            System.err.println("Invalid input!");
            return false;
        }
    }

}
