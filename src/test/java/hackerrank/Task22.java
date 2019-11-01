package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Task22 {

    @Test
    public void task22() {
        System.out.println(countingValleys(8, "UDDDUDUU")); //1
    }

    private int countingValleys(int n, String s) {
        String[] valleys = s.split("");
        int count = 0;
        int seaLevel = 0;
        for(String terrain : valleys) {
            if(terrain.equals("U")) {
                seaLevel++;
                if(seaLevel == 0) {
                    count++;
                }
            } else if (terrain.equals("D")) {
                seaLevel--;
            }
        }
        return count;
    }
}
