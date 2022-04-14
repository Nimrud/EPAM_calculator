package com.epam.calculator;

import java.util.Arrays;

class Main {
    public static void main(String... args) {
        System.out.println("input = " + Arrays.toString(InputReader.readAppArguments(args)));

        Validator validator = new Validator();
        validator.checkParameter(InputReader.readAppArguments(args));
        System.out.println("validator = " + validator.checkArguments(InputReader.readAppArguments(args)));

    }

}

