package lambda.currying;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurryingTest {
    private Currying currying;

    @BeforeEach
    public void setup() {
        currying = new Currying();
    }

    @Test
    public void addThreeNumbersTest() {
        Assertions.assertEquals(6, currying.currying(1,2,3));
    }
}
