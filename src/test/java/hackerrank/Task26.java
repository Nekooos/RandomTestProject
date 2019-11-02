package hackerrank;

import lambda.CompareService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task26 {
    //https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
    @Test
    public void task26() {
        int[] scores = {100,100,50,40,20,10};
        int[] alice = {5,25,50,120};
        Arrays.stream(climbingLeaderboard(scores, alice))
                .forEach(System.out::println);
    }

    private int[] climbingLeaderboard(int[] scores, int[] alice) {

        return scores;
    }
}
