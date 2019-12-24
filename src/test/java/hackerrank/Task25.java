package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Task25 {
    //https://www.hackerrank.com/challenges/picking-numbers/problem
    @Test
    public void task25() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,1,2);
        List<Integer> numbers2 = Arrays.asList(4,6,5,3,3,1);
        System.out.println(pickingNumbers(numbers));
        System.out.println(pickingNumbers(numbers2));
    }

    public int pickingNumbers(List<Integer> a) {
        for(int num : a) {
            
        }
        return 0;
    }

}
