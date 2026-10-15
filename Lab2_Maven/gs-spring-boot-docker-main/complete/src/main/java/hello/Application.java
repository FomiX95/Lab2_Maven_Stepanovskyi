package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String home() {
        return "<html><body>" +
               "<h1>Калькулятор</h1>" +
               "<form action='/calc' method='get'>" +
               "<input type='text' name='expr' placeholder='Наприклад: 2+2*2' required>" +
               "<button type='submit'>Порахувати</button>" +
               "</form>" +
               "</body></html>";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam String expr) {
        try {
            double result = calculatorService.calculate(expr);
            return "<html><body><h2>Результат виразу " + expr + " = " + result + "</h2><a href='/'>Назад</a></body></html>";
        } catch (Exception e) {
            return "<html><body><h2>Помилка в обчисленні!</h2><a href='/'>Назад</a></body></html>";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}