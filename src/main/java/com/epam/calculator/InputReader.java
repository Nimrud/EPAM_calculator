package com.epam.calculator;

class InputReader {

    static String[] readAppArguments(String[] args) {
        String[] input = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            input[i] = args[i];
        }
        return input;
    }
}
