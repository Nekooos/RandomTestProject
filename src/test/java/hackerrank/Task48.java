package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Task48 {
    // https://www.hackerrank.com/challenges/s10-basic-statistics/problem
    @Test
    public void task48() {
        calculateMeanMedianMode(Arrays.asList(64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060))
                .forEach(System.out::println);

        calculateMeanMedianMode(Arrays.asList(64630, 11735, 11735, 14470, 14470, 4978, 73429, 38120, 51135, 67060))
                .forEach(System.out::println);
    }

    private List<Double> calculateMeanMedianMode(List<Integer> numbers) {
        Collections.sort(numbers);
        List<Double> result = Arrays.asList(calculateMean(numbers), calculateMedian(numbers), calculateMode(numbers));
        return result;
    }

    private double calculateMean(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::intValue).sum()/numbers.size();
    }

    private double calculateMedian(List<Integer> numbers) {
        if(numbers.size() % 2 == 1) {
            return numbers.get(numbers.size()/2);
        } else {
            return (double)(numbers.get(numbers.size()/2) + numbers.get(numbers.size()/2-1))/2;
        }
    }

    private double calculateMode(List<Integer> numbers) {
        int maxValue = 0;
        int maxCount = 0;

        for (int i = 0; i < numbers.size(); ++i) {
            int count = 0;
            for (Integer number : numbers) {
                if (number.equals(numbers.get(i)))
                    ++count;
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = numbers.get(i);
            }
        }
        return maxValue;
    }
}
