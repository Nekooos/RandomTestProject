package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Task49 {

    @Test
    public void task49() {
        System.out.println(weightedMean(Arrays.asList(10, 40, 30, 50, 20)));
    }

    private double weightedMean(List<Integer> numbers) {
        return (double)(IntStream.range(0, numbers.size())
                .map(i -> (i+1) *  numbers.get(i))
                .sum())
                /listSizeSum(numbers);
    }

    private int listSizeSum(List<Integer> numbers) {
        return IntStream.range(0, numbers.size()).map(i -> i+1).sum();
    }
}
