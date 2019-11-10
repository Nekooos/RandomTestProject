package lambda;

import models.User;
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
    void concatArray() {
        int[] nums1 = {5,7,8};
        int[] nums2 = {3,4,5};
        int[] joinedArray = IntStream
                .concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(s->s)
                .toArray();
        int[] expectedArray = {8,7,5,5,4,3};
        assertArrayEquals(expectedArray, joinedArray);
    }

    @Test
    void mapStringFormatTest() {
        List<User> users = Arrays.asList(new User("Ulf", 44), new User("Malin", 32));
        List<String> messages = users.stream()
                .map(User::message)
                .collect(Collectors.toList());
        messages.forEach(System.out::println);
    }

    @Test
    void returnMapAndCountNames() {
        List<User> users = Arrays.asList(new User("Ulf", 22), new User("Ulf", 44), new User("Malin", 32));
        countNames(users).forEach((v, k) -> System.out.println("name "+ " " + v + " occurs " +k+ " times"));
    }

    private Map<String, Long> countNames(List<User> users) {
        return users.stream()
                .map(User::getName)
                .flatMap(Stream::of)
                .filter(name->name.length()>0)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }
    @Test
    void findLongestName() {
        List<User> users = Arrays.asList(new User("Ulf", 22), new User("Ulf", 44), new User("Malin", 32));
        String longestName = users.stream()
                .map(User::getName)
                .max(Comparator.comparingInt(String::length))
                .get();
        Assertions.assertEquals("Malin", longestName);
    }

    @Test
    void findNamesThatStartsWithU() {
        List<User> users = Arrays.asList(new User("Ulf", 22), new User("Urban", 44), new User("Malin", 32));
        Optional<User> foundUser = searchUser(users, "M");
        foundUser.ifPresent(user -> System.out.println(user.getName()));
        if (foundUser.isPresent()) {
            System.out.println("first name found");
        } else {
            System.out.println("not found");
        }
        Assertions.assertEquals("Malin", foundUser.get().getName());
    }

    private Optional<User> searchUser(List<User> users, String searchTerm) {
        return users.stream()
                .filter(user -> user.getName().contains(searchTerm))
                .findFirst();
                // or else
                // orElseThrow
    }

    @Test
    void rangeAndClosedRange() {
        List<User> users = Arrays.asList(new User("Ulf", 22), new User("Urban", 44), new User("Malin", 32));
        List<User> usersResult = IntStream.range(1, 3)
                .mapToObj(i -> users.get(i-1))
                .collect(Collectors.toList());
        assertEquals(2, usersResult.size());

        List<User> usersResult2 = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> users.get(i-1))
                .collect(Collectors.toList());
        assertEquals(3, usersResult2.size());
    }

    @Test
    void iterateStream() {
        List<User> users = Arrays.asList(new User("Ulf", 22), new User("Urban", 44), new User("Malin", 32));
        List<User> usersResult = IntStream.iterate(0, i -> i++)
                .mapToObj(users::get)
                .limit(2)
                .collect(Collectors.toList());
        assertEquals(2, usersResult.size());
    }
}
