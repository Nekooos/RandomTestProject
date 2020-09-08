package lambda.currying;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LambdaTest {
    private Currying currying;

    @BeforeEach
    public void setup() {
        currying = new Currying();
    }

    @Test
    public void addThreeNumbersTest() {
        Assertions.assertEquals(6, currying.currying(1,2,3));
    }

    @Test
    public void composeMultiplyAndAdd10() {
        int result = currying.composeMultiplyAndAdd10(5);
        Assertions.assertEquals(30, result);
    }

    @Test
    public void andThenMultiplyAndAddx3() {
        int result = currying.andThenMultiplyAndAddx3(5);
        Assertions.assertEquals(50, result);
    }

    @Test
    public void multiply2varAndAdd() {
        int result = currying.multiply2varAndAdd(2,2,2,2);
        Assertions.assertEquals(8, result);

    }

    @Test
    public void functionalAdd() {

    }
}
