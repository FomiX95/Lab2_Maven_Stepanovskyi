package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testCalculateSuccess() {
        double result = calculatorService.calculate("1+1");
        assertEquals(2.0, result, "1+1 має дорівнювати 2");
    }

    //@Test
    public void testCalculateFail() {
        double result = calculatorService.calculate("5-1");
        assertEquals(2.0, result, "5-1 дорівнює 4, але ми очікуємо 2, щоб тест впав");
    }
}