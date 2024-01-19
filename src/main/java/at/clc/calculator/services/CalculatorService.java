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
     * @param a minuend
     * @param b subtrahend
     * @return dif of a-b
     */
    public int sub(int a, int b){
        // ret
        return Math.abs(a-b);
    }

    /**
     * Multiply two numbers a and b
     * @param a first factor
     * @param b second factor
     * @return product of a*b
     */
    public int multiply(int a, int b){
        return a*b;
    }
}
