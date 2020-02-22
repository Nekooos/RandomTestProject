package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task51 {
    // https://www.hackerrank.com/challenges/s10-interquartile-range/problem
    @Test
    public void task51() {
        System.out.println(interquartileRange(Arrays.asList(6, 12, 8, 10, 20, 16), Arrays.asList(5, 4, 3, 2, 1, 5)));
    }

    private double interquartileRange(List<Integer> numbers, List<Integer> frequencies) {
        List<Integer> numbersFrequencies = new ArrayList<>();

        IntStream.range(0, numbers.size()).forEach(i ->{
            IntStream.range(0, frequencies.get(i)).forEach(num -> {
                numbersFrequencies.add(numbers.get(i));
            });
        });
        Collections.sort(numbersFrequencies);
        List<Integer> lowerPart;
        List<Integer> upperPart;
        if(numbers.size() % 2 == 1) {
            lowerPart = splitList(numbersFrequencies, 0, numbersFrequencies.size() / 2);
            upperPart = splitList(numbersFrequencies, numbersFrequencies.size() / 2 + 1, numbersFrequencies.size());
        } else {
            lowerPart = splitList(numbersFrequencies, 0, numbersFrequencies.size() / 2);
            upperPart = splitList(numbersFrequencies, numbersFrequencies.size() / 2, numbersFrequencies.size());
        }

        Collections.sort(lowerPart);
        Collections.sort(upperPart);
        return Math.abs(calculateMedian(lowerPart) - calculateMedian(upperPart));
    }

    private List<Integer> splitList(List<Integer> numbers, int start, int stop) {
        return IntStream.range(start, stop)
                .map(numbers::get)
                .boxed()
                .collect(Collectors.toList());
    }

    private double calculateMedian(List<Integer> numbers) {
        if(numbers.size() % 2 == 1) {
            return numbers.get(numbers.size()/2);
        } else {
            return (double)(numbers.get(numbers.size()/2) + numbers.get(numbers.size()/2-1))/2;
        }
    }
}
