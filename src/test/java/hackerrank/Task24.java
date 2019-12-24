package hackerrank;

import org.junit.jupiter.api.Test;

public class Task24 {
    @Test
    public void task24() {
        //x cat A, y Cat B, z Mouse C
        System.out.println(catAndMouse(1, 2, 3)); // Cat B
        System.out.println(catAndMouse(1, 3, 2)); // Mouse C
    }

    private String catAndMouse(int x, int y, int z) {
        if(Math.abs(x-z) < Math.abs(y-z)) {
            return "Cat A";
        } else if(Math.abs(x-z) > Math.abs(y-z)) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }
}
