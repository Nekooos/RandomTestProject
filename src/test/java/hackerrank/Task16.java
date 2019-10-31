package hackerrank;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Task16 {
    //https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
    @Test
    public void task16() {
        int[] ar = {1,3,2,6,1,2};
        System.out.println(divisibleSumPairs(6,3, ar));
        System.out.println(divisibleSumPairs2(6,3, ar));
    }

    private int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        for(int i=0; i<ar.length; i++) {
            for(int j=i+1; j<ar.length; j++) {
                if((ar[i] + ar[j]) % k == 0)
                    count++;
            }
        }
        return count;
    }

    private int divisibleSumPairs2(int n, int k, int[] ar) {
        return IntStream.range(0, ar.length)
                .map(x -> IntStream.range(x + 1, ar.length)
                        .map(y -> {
                            if((ar[x] + ar[y]) % k == 0) {
                                return 1;
                            }
                            return 0;
                        })
                        .sum())
                .sum();
    }
}
