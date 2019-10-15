package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task9 {
    @Test
    public void task9() {
        //https://www.hackerrank.com/challenges/magic-square-forming/problem
        int[][] s = {
                {4,8,2},
                {4,5,7},
                {6,1,6}
        };
        for (int[] ints : s) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

    public boolean checkIfDuplicate(int[][] array, int currentNum) {

        return false;
    }
}
