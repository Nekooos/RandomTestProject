package hackerrank;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task50 {
    //https://www.hackerrank.com/challenges/s10-quartiles/problem
    @Test
    public void task50() {
        calculateQuartiles(Arrays.asList(3, 7, 8, 5, 12, 14, 21, 13, 18))
                .forEach(System.out::println); // 6, 12, 16
        calculateQuartiles(Arrays.asList(3, 7, 8, 5, 12, 14, 21, 15, 18, 14))
                .forEach(System.out::println); // 6, 12, 16
    }

    private List<Integer> calculateQuartiles(List<Integer> numbers) {
        Collections.sort(numbers);
        List<Integer> lowerPart;
        List<Integer> upperPart;
        if(numbers.size() % 2 == 1) {
            lowerPart = splitList(numbers, 0, numbers.size() / 2);
            upperPart = splitList(numbers, numbers.size() / 2 + 1, numbers.size());
        } else {
            lowerPart = splitList(numbers, 0, numbers.size() / 2);
            upperPart = splitList(numbers, numbers.size() / 2, numbers.size());
        }
        return Arrays.asList(
                calculateMedian(lowerPart),
                calculateMedian(numbers),
                calculateMedian(upperPart));
    }

    private List<Integer> splitList(List<Integer> numbers, int start, int stop) {
        return IntStream.range(start, stop)
                .map(numbers::get)
                .boxed()
                .collect(Collectors.toList());
    }

    private int calculateMedian(List<Integer> numbers) {
        if(numbers.size() % 2 == 1) {
            return numbers.get(numbers.size()/2);
        } else {
            return (numbers.get(numbers.size()/2) + numbers.get(numbers.size()/2-1))/2;
        }
    }
}
