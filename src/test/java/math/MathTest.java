package math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {
    @Test
    void minMaxRootTest() {
        // a >= b) ? a : b
        assertEquals(5, Math.max(5,3));
        // a <= b) ? a : b
        assertEquals(3, Math.min(5,3));
        //root
        assertEquals(8, Math.sqrt(64));
    }
    @Test
    void absTest() {
        // positive
        assertEquals(5.3, Math.abs(-5.3));
    }

    @Test
    void powTest() {
        // 2*2*2*2
        assertEquals(16, Math.pow(2,4));
    }

    @Test
    void roundTest() {
        assertEquals(5, Math.round(5.3));
        assertEquals(5, Math.round(4.8));
    }

}
