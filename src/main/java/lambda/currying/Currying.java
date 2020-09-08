package lambda.currying;

import java.util.function.Function;

public class Currying {

    public Function<Integer, Function<Integer, Function<Integer, Integer>>> addThreeNumbers =
            num1 -> num2 -> num3 -> num1 + num2 + num3;

    public Function<Integer, Integer> multiply =
            num1 -> num1 * 2;

    public Function<Integer, Function<Integer, Integer>> multiply2var =
            num1 -> num2 -> num1 * num2;

    private Function<Integer, Integer> add10 =
            num1 -> num1 + 10;

    private Function<Integer, Integer> multiplyAndAdd10 =
            multiply.compose(add10);

    public int currying(int num1, int num2, int num3) {
        return addThreeNumbers.apply(num1).apply(num2).apply(num3);
    }

    public int composeMultiplyAndAdd10(int num) {
        return multiplyAndAdd10.apply(num);
    }

    public int andThenMultiplyAndAddx3(int num) {
        return multiply.compose(add10).andThen(add10).andThen(add10).apply(num);
    }

    public int multiplyComposeMultiply(int num1, int num2, int num3) {
        return addThreeNumbers.compose(add10).apply(num1).apply(num2).apply(num3);
    }

    public int multiply2varAndAdd(int num1, int num2, int num3, int multiplier) {
        return addThreeNumbers.compose(multiply2var.apply(multiplier)).apply(num1).apply(num2).apply(num3);
    }

    public int functionalCalculationAdd5x2plus2() {
        Calculation<Integer, Integer> add5 = num -> num + 5;
        return add5.andThen(add5).add(2).apply(5);
    }
}
