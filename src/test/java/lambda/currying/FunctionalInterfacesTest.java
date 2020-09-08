package lambda.currying;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Supplier;

public class FunctionalInterfacesTest {
    private Interfaces interfaces;

    @BeforeEach
    public void setup() {
        interfaces = new Interfaces();
    }

    @Test
    public void toLongFunctionTest() {
        final int testInt = 2;
        Long testLong = interfaces.toLongFunction.applyAsLong(testInt);
        Assertions.assertEquals(2, testLong);
    }

    @Test
    public void SupplierTest() {
        final int testNum = 5;
        Supplier<Integer> intSupplier = () -> testNum;
        Assertions.assertEquals(5, intSupplier.get());
    }
}
