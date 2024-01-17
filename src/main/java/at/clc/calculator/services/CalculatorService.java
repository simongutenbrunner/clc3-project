/**
 * Package containing all the Services. Services implement business logic.
 */
package at.clc.calculator.services;

import org.springframework.stereotype.Service;

/**
 * The CalculatorService holds the implementation for all calculation logic used by the application. blubb
 * test docs 2
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
}
