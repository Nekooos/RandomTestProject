package hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task17 {
    //https://www.hackerrank.com/challenges/migratory-birds/problem
    @Test
    public void task17() {
        List<Integer> birdSightings = Arrays.asList(1,2,3,4,5,4,3,2,1,3,4);
        System.out.println(migratoryBirds(birdSightings));
    }

    int migratoryBirds(List<Integer> arr) {
        return arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .findFirst()
                .filter(optional -> optional.getKey()!=null)
                .get()
                .getKey();
    }
}
