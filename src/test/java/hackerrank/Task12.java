package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task12 {
    //1 1
    @Test
    public void task12() {
        int[] apples = {2,3,-4};
        int[] oranges = {3,-2,-4};
        countApplesAndOranges(7, 10, 4, 12, apples, oranges); // easier to copy in to hacker rank
    }
    //a appleTreePos
    //b orangeTreePos
    //t houseEnd orangeTree
    //s houseEnd appleTree
    public void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        Predicate<Integer> inRange = num -> num >= s && num <= t;
        int applesCloseToHouse = Arrays.stream(apples)
                  .map(num -> num + a)
                  .filter(inRange::test)
                  .toArray().length;
        System.out.println(applesCloseToHouse);

        int orangesCloseToHouse = Arrays.stream(oranges)
                  .map(num -> num + b)
                  .filter(inRange::test)
                  .toArray().length;
        System.out.println(orangesCloseToHouse);
    }
}
