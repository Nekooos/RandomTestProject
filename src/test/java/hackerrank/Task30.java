package hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class Task30 {
    @Test
    public void task30() {
        int[] array = {1,4,3,2};
        int[] expectedArray = {2,3,4,1};
        Assertions.assertArrayEquals(expectedArray, reverseArray(array));
    }

    private int[] reverseArray(int[] a) {
        return IntStream.range(0, a.length)
                .map(i -> a[a.length - i -1 ])
                .toArray();
    }
}
