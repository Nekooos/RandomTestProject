package lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamTest {
    private List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    private Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;

    @Test
    void numIsGreaterThanTest() {
        int num = values.stream()
                .filter(isGreaterThan.apply(5))
                .findFirst()
                .orElse(0);
        assertEquals(6, num);
    }

    @Test
    void numIsGreaterThanTest2() {
        values.stream()
                .filter(isGreaterThan.apply(5))
                .findFirst()
                .ifPresent(num2 -> assertEquals(6, num2));
    }

    @Test
    void predicateTest() {
        Predicate<Integer> isGreaterThanFive = num -> num > 5;
        assertTrue(isGreaterThanFive.or(integer -> integer < 0).test(6));
        assertTrue(isGreaterThanFive.or(integer -> integer < 0).test(-1));
        assertFalse(isGreaterThanFive.and(integer -> integer < 0).test(-1));
    }

    @Test
    void collectorTest() {
        String streamString = List.of(1.3, 1.5, 3.1).stream().map(Object::toString).collect(Collectors.joining(" + "));
        assertEquals("1.3 + 1.5 + 3.1", streamString);

        double sum = List.of(5, 10, 15).stream().collect(Collectors.averagingInt(Integer::intValue));
        assertEquals(10.0, sum);
    }

    @Test
    void buildStringFromArray() {
        String[] words = new String[]{"This", "will", "be", "a", "single", "String"};
        String result = Arrays.stream(words)
                .collect(Collectors.joining(" "));
        assertEquals("This will be a single String", result);
    }

    @Test
    void buildStringFromArrayDelimeterPrefixSuffix() {
        String[] words = new String[]{"This", "will", "be", "a", "single", "String"};
        String result = Arrays.stream(words)
                .collect(Collectors.joining(" ", "Hello! ", "!"));
        assertEquals("Hello! This will be a single String!", result);
    }

    @Test
    void partitioningBy() {
        List<Integer> numbers = Arrays.asList(3,6,7);
        Map<Boolean, List<Integer>> wordsEvenLength = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num > 5));
        assertTrue(wordsEvenLength.get(true).contains(6));
    }

    @Test
    void skip() {
        List<Integer> numbers = Arrays.asList(3,6,7);
        numbers = numbers.stream()
                .skip(1)
                .collect(Collectors.toList());
        assertEquals(6, numbers.get(0));
    }

    @Test
    void subListTest() {
        List<Integer> nums = Arrays.asList(1,2,3,4);
        List<Integer> nums2 = new ArrayList<>();
        List<Integer> expectedNums2 = Arrays.asList(10,9,7,4);
        for(int i=0; i<nums.size(); i++) {
            int num = nums.subList(i, nums.size()).stream().mapToInt(s->s).sum();
            nums2.add(num);
        }
        assertEquals(expectedNums2, nums2);
    }

    @Test
    void mapStream() {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        /*Map<Integer, Long> numsMap = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Function.identity(), num -> num));*/
    }
}
