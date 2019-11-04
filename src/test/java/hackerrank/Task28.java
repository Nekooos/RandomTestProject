package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Task28 {
    @Test
    public void task28() {
        int[] height = {1,6,3,5,2};
        int[] height2 = {2,5,4,5,2};
        System.out.println(hurdleRace(4, height)); //2
        System.out.println(hurdleRace(7, height2)); //0
    }

    private int hurdleRace(int k, int[] height) {
        int maxHeight = Arrays.stream(height)
                .max()
                .orElse(0);
        return Math.max(maxHeight - k, 0);
    }

}
