package hackerrank;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Task49 {

    @Test
    public void task49() {
        System.out.println(((round(weightedMean(Arrays.asList(10, 40, 30, 50, 20, 10, 40, 30, 50, 20), Arrays.asList(1,2,3,4,5,6,7,8,9,10)),1))));
        System.out.println(round(weightedMean(Arrays.asList(10, 40, 30, 50, 20), Arrays.asList(1,2,3,4,5)),1));
        System.out.println(round(weightedMean(Arrays.asList(10, 40, 30, 50, 20, 10, 40, 30, 50, 20 ,1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 40, 30, 50, 20, 10, 40, 30, 50, 20)),1));
    }

    private double weightedMean(List<Integer> numbers, List<Integer> numbers2) {
        return (double)(IntStream.range(0, numbers.size())
                .map(i -> numbers.get(i) *  numbers2.get(i))
                .sum())
                /listSizeSum(numbers2);
    }

    private int listSizeSum(List<Integer> numbers) {
        return numbers.stream().mapToInt(s-> s).sum();
    }

    public double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
