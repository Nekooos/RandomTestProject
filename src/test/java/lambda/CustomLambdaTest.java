package lambda;

import org.junit.jupiter.api.BeforeAll;

public class CustomLambdaTest {
    private final double[] EXPECTED_SALES_JAN_TO_DEC = new double[] {42.0, 56.6, 43.6, 50.2, 55.6, 54.7, 58.0, 57.3, 62.0, 60.3, 71.2, 88.8};

    FunctionOverTime sales = FunctionOverTime.monthByMonth(EXPECTED_SALES_JAN_TO_DEC);

    FunctionOverTime fixedCosts = FunctionOverTime.constant(15.0);

    FunctionOverTime incrementalCosts = FunctionOverTime.line(5.1, 0.15);
}

@FunctionalInterface
interface FunctionOverTime {
    double valueAt(int time);

    static FunctionOverTime monthByMonth(final double[] values) {
        return time -> values[time-1];
    }

    static FunctionOverTime constant(final double value) {
        return polynomial(new double[] {value});
    }

    static FunctionOverTime line(final double intercept, final double slope) {
        return polynomial(new double[] {intercept, slope});
    }

    static FunctionOverTime polynomial(double[] coefficients) {
        return time -> {
            Double sum = 0.0;
            for(int i=0; i<coefficients.length; i++) {
                sum += Math.pow(time, i) * coefficients[i];
            }
            return sum;
        };
    }

    static FunctionOverTime combinationOf3 (FunctionOverTime a, FunctionOverTime b, FunctionOverTime c, FunctionOf3 f) {
        return time -> f.apply(a.valueAt(time), b.valueAt(time), c.valueAt(time));
    }
}

@FunctionalInterface
interface FunctionOf3 {
    double apply(double a, double b, double c);
}
