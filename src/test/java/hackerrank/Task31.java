package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task31 {
    @Test
    public void task31() {
        assertEquals(2, beautifulDays(20, 23, 6));
    }
    // https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
    private int beautifulDays(int i, int j, int k) {
        return (int) IntStream.range(i, j + 1)
                .mapToDouble(s -> Math.abs((double) (s - reverseNumber(s)) / k))
                .filter(num -> num % 1 == 0)
                .boxed()
                .count();
    }

    // a /= b       divide a by b put result in a
    private int reverseNumber(int num) {
        int reversed = 0;
        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
}
