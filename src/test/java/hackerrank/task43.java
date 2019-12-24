package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class task43 {
    @Test
    public void task43() {
        int[] clouds = {0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(clouds));
    }

    private int jumpingOnClouds(int[] c) {
        int position = 0;
        int jumps = 0;

        while (position < c.length - 1) {
            if (position + 2 < c.length && c[position + 2] == 0) {
                position += 2;
                jumps++;
            }
            else {
                position++;
                jumps++;
            }
        }

        return jumps;
    }

}
