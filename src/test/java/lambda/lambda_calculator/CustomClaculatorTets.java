package lambda.lambda_calculator;

import lambda.lambdaCalculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomClaculatorTets {
    @Test
    public void calculatorLambdaTest() {
       
        //Calculator calculator;
        double sum = Calculator.plus(5).applyNum(4);
        assertEquals(9, sum);

        double sum2 = Calculator.plus(5).applyNum(Calculator.plus(5).applyNum(5));
        assertEquals(15, sum2);
    }

    @Test
    public void circleArea() {
        double sum = Calculator.applyPi().applyNum(3);
        assertEquals(9.42477796076938, sum);
    }

    @Test
    public void cubeArea() {
        double sum = Calculator.cube(4).applyNum(3);
        assertEquals(12, sum);
    }

    @Test
    public void plusMinusMultiplyDivide(){
        double sum = Calculator.plus(5).applyNum(Calculator.minus(3).applyNum(Calculator.multiply(2).applyNum(Calculator.divide(2).applyNum(10))));
        assertEquals(12, sum);
    }
}

