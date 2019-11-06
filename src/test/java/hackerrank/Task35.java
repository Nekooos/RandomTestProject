package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task35 {
    @Test
    public void task35() {
        int[] values = {2,3,1}; // 2 3 1
        int[] values2 = {4, 3, 5, 1, 2}; //1 3 5 4 2
        Arrays.stream(permutationEquation(values))
                .forEach(System.out::println);
        System.out.println("");
        Arrays.stream(permutationEquation(values2))
                .forEach(System.out::println);
    }

    private int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];
        for(int i=1; i<=p.length; i++) {
            int first = findNumber(p, i) + 1;
            int second = findNumber(p, first)+1;
            result[i-1] = second;
        }
        return result;
    }

    private int findNumber(int[] values, int number) {
        for(int i=0; i<values.length; i++) {
            if(number == values[i]) {
                return i;
            }
        }
        return 0;
    }
}
