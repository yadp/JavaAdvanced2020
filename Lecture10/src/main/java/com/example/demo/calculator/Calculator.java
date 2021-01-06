package com.example.demo.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

public class Calculator {
    private final Collection<Operation> operations;

    public Calculator(Collection<Operation> operations) {
        this.operations = operations;
    }
    public void calculate(int lhs, int rhs, char op) {
        for (var operation : operations) {
            if (operation.handles(op)) {
                var result = operation.apply(lhs, rhs);
                System.out.printf("%d %s %d = %s%n", lhs, op, rhs, result);
                return;
            }
        }
        throw new IllegalArgumentException("Unknown operation " + op);
    }
}
