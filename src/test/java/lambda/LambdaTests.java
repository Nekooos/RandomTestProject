package lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class LambdaTests {
     Function<Integer, Integer> compose(Function<Integer, Integer> f1,
                                              Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }

    Function<Integer, Integer> function1 = n1 -> n1+1;

    Function<Integer, Integer> function2 = n2 -> n2+1;

    @Test
    public void composeTest() {
        int resultInt = compose(function1, function2).apply(1);
        Assertions.assertEquals(3, resultInt);
    }
}
