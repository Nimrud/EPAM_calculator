package com.epam.calculator;

import java.math.BigDecimal;
import java.math.MathContext;

public enum Operations {
    ADDITION{
        @Override
        BigDecimal calculation(BigDecimal first, BigDecimal second) {
            return first.add(second);
        }
    },
    SUBTRACTION {
        @Override
        BigDecimal calculation(BigDecimal first, BigDecimal second) {
            return first.subtract(second);
        }
    },
    MULTIPLICATION{
        @Override
        BigDecimal calculation(BigDecimal first, BigDecimal second) {
            return first.multiply(second, new MathContext(3));
        }
    },
    DIVISION{
        @Override
        BigDecimal calculation(BigDecimal first, BigDecimal second) {
            try {
                return first.divide(second, new MathContext(2));
            } catch (ArithmeticException e) {
                System.err.println("Cannot divide by zero");
            }
            return null;
        }
    };

    abstract BigDecimal calculation(BigDecimal first, BigDecimal second);
}
