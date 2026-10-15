package hello;

import org.springframework.stereotype.Service;
import net.objecthunter.exp4j.ExpressionBuilder;

@Service
public class CalculatorService {

    // Саме цей МІЙ метод ми будемо тестувати, як просив викладач
    public double calculate(String expression) {
        return new ExpressionBuilder(expression).build().evaluate();
    }
}