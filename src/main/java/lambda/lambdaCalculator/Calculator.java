package lambda.lambdaCalculator;

@FunctionalInterface
public interface Calculator {
    double applyNum(double x);

    static Calculator plus(double y) {
        return (x) -> x+y;
    }

    static Calculator minus(double y) {
        return (x) -> x-y;
    }

    static Calculator multiply(double y) {
        return (x) -> x*y;
    }


    static Calculator divide(double y) {
        return (x) -> x/y;
    }

    static Calculator applyPi() {
        return x -> x * Math.PI;
    }

    static Calculator cube(double side) {
        return x -> x * side;
    }
}
