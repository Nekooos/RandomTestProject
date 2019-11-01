package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task8 {
    @Test
    public void task8() {
        //https://www.hackerrank.com/challenges/birthday-cake-candles/problem
        int[] ar = {3,2,1,3};
        int highestCandle = Arrays.stream(ar)
                .max()
                .getAsInt();

        int[] remainingCandles = Arrays.stream(ar).
                filter(height -> height == highestCandle)
                .peek(num -> System.out.println(num))
                .toArray();

        int blownOutCandles = remainingCandles.length;
    }
}
