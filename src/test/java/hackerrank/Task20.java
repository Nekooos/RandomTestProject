package hackerrank;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Task20 {
    //https://www.hackerrank.com/challenges/sock-merchant/problem
    //9
    //10 20 20 10 10 30 50 10 20
    @Test
    public void Task20 () {
        int[] socks = {10,20,20,10,10,30,50,10,20};
        System.out.println(sockMerchant(9, socks));
    }

    private int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        int[] noDuplicate = Arrays.stream(ar)
                .distinct()
                .toArray();
        for (int value : noDuplicate) {
            int count = 0;
            for (int value2 : ar) {
                if (value == value2) {
                    count++;
                }
            }
            pairs = pairs + count / 2;
        }
        return pairs;
    }
}
