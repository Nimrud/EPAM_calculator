package com.epam.calculator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class PrefixEvaluator {

    private final Deque<String> stack = new ArrayDeque<>();

    Deque<String> addToDeque(String[] array) {
        for (int i = 1; i < array.length; i++) {
            stack.addFirst(array[i]);
        }
        return stack;
    }

    Deque<String> countPrefixDeque(Deque<String> stack) {
        Deque<String> temp = new ArrayDeque<>();
        BigDecimal result;
        for (String s : stack) {
            temp.addFirst(s);
            if (Validator.assessArgument(s, Validator.OPERATOR)) {
                String operator = temp.poll();
                String b = temp.poll();
                String a = temp.poll();

                assert a != null;
                assert b != null;
                assert operator != null;

                BigDecimal a_big = new BigDecimal(a);
                BigDecimal b_big = new BigDecimal(b);

                result = switch(operator) {
                    case "+" -> Operations.ADDITION.calculation(a_big, b_big);
                    case "-" -> Operations.SUBTRACTION.calculation(a_big, b_big);
                    case "*" -> Operations.MULTIPLICATION.calculation(a_big, b_big);
                    case "/" -> Operations.DIVISION.calculation(a_big, b_big);
                    default -> null;
                };
                temp.addFirst(String.valueOf(result));
                System.out.println("temp.toArray() = " + Arrays.toString(temp.toArray()));
            }
        }

        return temp;
    }
}
