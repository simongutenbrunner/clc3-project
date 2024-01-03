package at.clc.calculator.controllers;

import at.clc.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorRestController {

    CalculatorService calculatorService;

    @Autowired
    public CalculatorRestController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return String.valueOf(calculatorService.add(a,b));
    }
}

