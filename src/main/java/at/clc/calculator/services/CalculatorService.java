package at.clc.calculator.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public CalculatorService() {
    }

    public int add(int a, int b){
        return a+b;
    }
}
