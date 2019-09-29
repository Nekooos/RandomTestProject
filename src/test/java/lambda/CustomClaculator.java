package lambda;

import lambda.lambdaCalculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomClaculator {
    @Test
    public void calculatorLambdaTest() {
       
        //Calculator calculator;
        int sum = Calculator.applySecondNum(5).applyNum(4);
        assertEquals(9, sum);

        int sum2 = Calculator.applySecondNum(5).applyNum(Calculator.applySecondNum(5).applyNum(5));
        assertEquals(15, sum2);
    }
}

