package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Task14 {
    @Test
    public void task14() {
        int[] scores = {12,24,10,24};
        Arrays.stream(breakingRecords(scores)).forEach(s -> System.out.println(s));
    }

    private int[] breakingRecords(int[] scores) {
        int record = 0;
        int lowest = 0;
        int max = scores[0];
        int min = scores[0];
        for(int i=0; i<scores.length; i++) {
            if(scores[i] > max) {
                max = scores[i];
                record++;
            }
            if(scores[i] < min) {
                min = scores[i];
                lowest++;
            }
        }
        int[] result = {record, lowest};
        return result;
    }
}
