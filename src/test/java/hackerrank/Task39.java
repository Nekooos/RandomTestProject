package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class Task39 {
    @Test
    public void task39() {
        System.out.println(squares(3,9)); // 2
        System.out.println(squares(17,24)); // 2
    }
    // to slow
    private int squares2(int a, int b) {
        return (int) IntStream.range(a, b+1)
                .filter(i -> Math.sqrt(i) - Math.floor(Math.sqrt(i)) == 0 )
                .count();
    }
    // to slow
    private int squares3(int a, int b) {
        return (int) (Math.floor(Math.sqrt(b)) - (int) Math.ceil(Math.sqrt(a)) + 1);
    }

    private int squares(int a, int b) {
        int counter = 0;
        int i = 1;
        int square = i*i;
        while(square <=b) {
            if(square>=a) {
                counter++;
            }
            i++;
            square = i*i;
        }
        return counter;
    }
}
