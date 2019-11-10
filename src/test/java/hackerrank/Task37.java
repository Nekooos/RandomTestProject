package hackerrank;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task37 {
    @Test
    public void task37() {
        System.out.println(findDigits(12));
        System.out.println(findDigits(1012));
    }

    private int findDigits(int n) {
        return (int) splitInteger(n).stream()
                .filter(s -> s != 0 && n % s == 0)
                .count();
    }

    private List<Integer> splitInteger(int value) {
        List<Integer> values = new ArrayList<>();
        while(value > 0) {
            values.add(value % 10);
            value = value / 10;
        }
        return values;
    }
}
