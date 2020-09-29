package lambda.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParallelStreamTest {

    private ParallelStreamPractice parallelStreamPractice = new ParallelStreamPractice();

    @Test
    public void parallelStreamSumTest() {
        long result = parallelStreamPractice.parallelStreamSum(3);
        System.out.println(result);
        Assertions.assertEquals(6, result);
    }
}
