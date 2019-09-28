package lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

class StreamTest {
    private List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    private Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;

    @Test
    void numIsGreaterThanTest() {
        int num = values.stream()
                .filter(isGreaterThan.apply(5))
                .findFirst()
                .orElse(0);
        Assertions.assertEquals(6, num);
    }

    @Test
    void numIsGreaterThanTest2() {
        values.stream()
                .filter(isGreaterThan.apply(5))
                .findFirst()
                .ifPresent(num2 -> Assertions.assertEquals(6, num2));
    }

    @Test
    void predicate() {
        Predicate<Integer> isGreaterThanFive = num -> num > 5;
        Assertions.assertTrue(isGreaterThanFive.or(integer -> integer < 0).test(6));
        Assertions.assertTrue(isGreaterThanFive.or(integer -> integer < 0).test(-1));
        Assertions.assertFalse(isGreaterThanFive.and(integer -> integer < 0).test(-1));
    }
}
