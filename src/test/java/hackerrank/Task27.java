package hackerrank;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task27 {
    @Test
    public void task27() {
        extraLongFactorials(25);
    }

    private void extraLongFactorials(int n) {
        BigInteger factorial = new BigInteger("1");
        while (n>1){
            factorial = factorial.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(factorial);
    }

}
