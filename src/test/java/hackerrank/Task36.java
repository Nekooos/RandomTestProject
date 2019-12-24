package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task36 {
    @Test
    public void task36() {
        int[] clouds = {0, 0, 1, 0, 0, 1, 1, 0};
        int jumpDistance = 2;
        System.out.println(jumpingOnClouds(clouds, jumpDistance));
    }

    static int jumpingOnClouds(int[] c, int k) {
        int i = k % c.length;
        int energy = 100;
        energy -= c[i] * 2 + 1;
        while (i != 0){
            i = (i + k) % c.length;
            energy -= c[i] * 2 + 1;
        }
        return energy;
    }

}
