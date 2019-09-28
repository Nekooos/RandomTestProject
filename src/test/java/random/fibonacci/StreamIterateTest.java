package random.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamIterateTest {
    private StreamIterate fibonacciService;

    @BeforeEach
    public void setUp() {
        fibonacciService = new StreamIterate();
    }

    @Test
    public void fibonacciTest() {
        int num = fibonacciService.fibonacci(11);
        Assertions.assertEquals(55, num);
        int num2 = fibonacciService.fibonacci(7);
        Assertions.assertEquals(8, num2);
    }

    @Test
    public void streamIterateLimitTest() {
        List<Integer> numbers = fibonacciService.streamIterateLimit(5);
        Assertions.assertEquals(5, numbers.get(numbers.size()-1));
    }
}
