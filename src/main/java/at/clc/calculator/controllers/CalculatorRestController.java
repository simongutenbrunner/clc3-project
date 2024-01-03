package at.clc.calculator.controllers;

import at.clc.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The CalculatorRestController Class holds the implementation for all REST endpoints
 */
@RestController
public class CalculatorRestController {

    CalculatorService calculatorService;

    @Autowired
    public CalculatorRestController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    /**
     * Adds the two request params together
     * @param a first request param
     * @param b second request param
     * @return sum of request params a + b
     */
    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return String.valueOf(calculatorService.add(a,b));
    }
}

