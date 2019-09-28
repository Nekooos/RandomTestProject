package lambda.lambdaCalculator;

import java.util.function.BiFunction;

public class CalculatorService {
    BiFunction<Integer, Integer, Integer> calculatorAdd = Integer::sum;
    BiFunction<Integer, Integer, Integer> calculatorSub = (x,y) -> x-y;

}
