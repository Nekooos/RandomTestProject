package lambda.lambdaCalculator;

@FunctionalInterface
public interface Calculator {
    int applyNum(int x);

    static Calculator applySecondNum(int y) {
        return (x) -> x+y;
    }
}
