package com.epam.calculator;

import java.util.Arrays;
import java.util.Deque;

class Main {
    public static void main(String... args) {
        System.out.println("input = " + Arrays.toString(InputReader.readAppArguments(args)));

        Validator validator = new Validator();
        String[] input = InputReader.readAppArguments(args);
        boolean isValidExpression = validator.checkParameter(input);
        System.out.println("validator = " + validator.checkArguments(InputReader.readAppArguments(args)));

        PrefixEvaluator prefixEvaluator = new PrefixEvaluator();
        if (isValidExpression) {
            Deque<String> deque = prefixEvaluator.addToDeque(input);
            System.out.println("evaluator.count(deque) = " + prefixEvaluator.countPrefixDeque(deque));
        } else {
            System.err.println("Exiting, 'cause of invalid expression");
        }
    }

}

