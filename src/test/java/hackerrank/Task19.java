package hackerrank;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Task19 {
    @Test
    public void task19() {
        List<Integer> bill1 = new ArrayList<>(Arrays.asList(3,10,2,9));
        List<Integer> bill2 = new ArrayList<>(Arrays.asList(3,10,2,9));
        bonAppetit(bill1, 1, 12); //5
        bonAppetit(bill2, 1, 7); //5
    }

    void bonAppetit(List<Integer> bill, int k, int b) {
        bill.remove(k);
        int sum = bill.stream()
                .mapToInt(s->s)
                .sum();
        if(b-sum/2 < b && b-sum/2>0) {
            System.out.println(b-sum/2);
        } else {
            System.out.println("Bon Appetit");
        }
    }
}
