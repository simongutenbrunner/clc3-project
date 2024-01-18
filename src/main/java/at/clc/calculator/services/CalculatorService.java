/**
 * Package containing all the Services. Services implement business logic.
 */
package at.clc.calculator.services;

import org.springframework.stereotype.Service;

/**
 * The CalculatorService holds the implementation for all calculation logic used by the application.
 */
@Service
public class CalculatorService {

    /**
     * Adds two numbers a and b
     * @param a first summand
     * @param b second sumand
     * @return sum of a + b
     */
    public int add(int a, int b){
        // ret
        return a+b;
    }

    /**
     * Subtracts two numbers a and b
     * @param a first summand
     * @param b second sumand
     * @return difference of a - b
     */
    public int subtract(int a, int b){
        // ret
        return Math.abs(a-b+1);
    }
}
