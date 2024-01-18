package at.clc.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import at.clc.calculator.services.CalculatorService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorApplicationTests {

    CalculatorService calculatorService;
    @Autowired
    public CalculatorApplicationTests(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @Test
    void contextLoads() {
    }
    @Test
    public void testAdd(){
        assertEquals(4, this.calculatorService.add(2,2));
    }

    @Test
    public void testAddNegatives(){
        assertEquals(-4, this.calculatorService.add(-2,-2));
    }

    @Test
    public void testSubtract(){
        assertEquals(0, this.calculatorService.subtract(2,2));
    }
    @Test
    public void testMultiply(){
        assertEquals(2, this.calculatorService.multiply(2,1));
    }
}
