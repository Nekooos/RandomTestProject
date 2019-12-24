package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task41 {
    //https://www.hackerrank.com/challenges/non-divisible-subset/problem
    @Test
    public void task41() {
        //List<Integer> numbers = Arrays.asList(1,7,2,4); // 3
        List<Integer> numbers2 = Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436); //11
       // System.out.println(nonDivisibleSubset(3, numbers));
        System.out.println(nonDivisibleSubset(7, numbers2));
    }

    private int nonDivisibleSubset(int k, List<Integer> s) {
        int[] arr = new int[k];
        int count=0;

        for (Integer num : s) {
            arr[num % k]++;
        }

        for (int i=0; i<k; i++)
            if ((i==0 || i == k-i) && arr[i] != 0)
                count++;

            else if (i != 0 && i!=k-i && arr[i] >= arr[k-i])
            {count += arr[i];
                arr[k-i]=0;
            }

        return count;
    }
}
