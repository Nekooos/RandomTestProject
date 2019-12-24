package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4 {
    int n = 3;
    List<Integer> list1 = Arrays.asList(11,2,4);
    List<Integer> list2 = Arrays.asList(4,5,6);
    List<Integer> list3 = Arrays.asList(10,8,-12);
    List<List<Integer>> arr = Arrays.asList(list1, list2, list3);

    @Test
    public void task4() {
        int val1 = 0;
        for (int i = 0; i < arr.size(); i++) {
            val1 = val1 + arr.get(i).get(i);
        }
        int val2 = 0;
        int pos = arr.size()-1;
        for (int j = 0;  j < arr.size(); j++) {
            val2 = val2 + arr.get(j).get(pos);
            pos=pos-1;
        }
        assertEquals(15, Math.abs(val1-val2));
    }

}
