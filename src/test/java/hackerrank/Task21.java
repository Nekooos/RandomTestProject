package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Task21 {
    //https://www.hackerrank.com/challenges/drawing-book/problem
    @Test
    public void task21() {
        System.out.println(pageCount(6,2)); // 1
        System.out.println(pageCount(5,4)); // 0
    }

    private int pageCount(int n, int p) {
        int total = n/2;
        int right = p/2;
        int left = total - right;
        return Math.min(right, left);
    }
}
