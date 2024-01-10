package at.clc.calculator.services;

import org.springframework.stereotype.Service;

/**
 * The CalculatorService holds the implementation for all calculation logic used by the application.
 */
@Service
public class CalculatorService {
    public CalculatorService() {
    }

    /**
     * Adds two numbers a and b
     * @param a first summand
     * @param b second sumand
     * @return sum of a + b
     */
    public int add(int a, int b){

        // add a + b and return the result
        return a+b;
    }
}
