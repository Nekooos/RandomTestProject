package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class task33 {
    @Test
    public void task33() {
        int cancelTreshold = 3;
        int[] studentArrival = {-1, -3, 4, 2};
        System.out.println(angryProfessor(cancelTreshold, studentArrival));
        int cancelTreshold2 = 2;
        int[] studentArrival2 = {0, -1, 2, 1};
        System.out.println(angryProfessor(cancelTreshold2, studentArrival2));
    }

    private String angryProfessor(int k, int[] a) {
        long studentsInTimeForClass = Arrays.stream(a)
                .filter(time -> time >= 0)
                .count();
        return studentsInTimeForClass >= k ? "YES" : "NO";
    }

}
