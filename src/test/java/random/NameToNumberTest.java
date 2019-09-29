package random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameToNumberTest {
    private NameToNumber nameToNumber;

    @BeforeEach
    public void setUp() {
        nameToNumber = new NameToNumber();
    }

    @Test
    public void sumOfWord() {
        int sum = nameToNumber.sumWord("Rebecca");
        assertEquals(37, sum);
        int sum2 = nameToNumber.sumWord("aBc");
        assertEquals(6, sum2);
    }
}
