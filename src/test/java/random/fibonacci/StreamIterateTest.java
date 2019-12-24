package random.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamIterateTest {
    private StreamIterate fibonacciService;

    @BeforeEach
    public void setUp() {
        fibonacciService = new StreamIterate();
    }

    @Test
    public void fibonacciTest() {
        int num = fibonacciService.fibonacci(11);
        assertEquals(55, num);
        int num2 = fibonacciService.fibonacci(7);
        assertEquals(8, num2);
    }
}
