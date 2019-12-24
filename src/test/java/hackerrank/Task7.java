package hackerrank;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task7 {
    @Test
    public void task7() {
        long[] nums = {1,2,3,4,5};
        long sum = 0;
        long sum2 = 0;
        Arrays.sort(nums);
        for(int i =0; i<nums.length-1; i++) {
            sum = sum+nums[i];
        }
        for(int i =1; i<nums.length; i++) {
            sum2 = sum2+nums[i];
        }

        System.out.println(sum + " " +sum2);
    }
}
