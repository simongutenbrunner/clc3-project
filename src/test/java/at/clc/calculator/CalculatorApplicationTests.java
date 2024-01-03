package at.clc.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import at.clc.calculator.services.CalculatorService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void testAdd(){
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(4, calculatorService.add(2,2));
    }

}
