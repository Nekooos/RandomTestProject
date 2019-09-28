package hackerrank;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class Task5 {

    @Test
    public void task4() {
        DecimalFormat df2 = new DecimalFormat("#.######");
        int[] arr = {-4, 3, -9, 0, 4, 1};
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] > 0) {
                positive = positive+1;
            } else if(arr[i] < 0) {
                negative = negative+1;
            } else {
                zero = zero +1;
            }
        }
        System.out.println(df2.format((double)positive/arr.length));
        System.out.println(df2.format((double)negative/arr.length));
        System.out.println(df2.format((double)zero/arr.length));
    }
}
