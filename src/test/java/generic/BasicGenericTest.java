package generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicGenericTest {
    BasicGeneric<String> storeString;
    KeyValue<String, Integer> keyValue;

    @BeforeEach
    public void setup() {
        storeString = new BasicGeneric<>();
        keyValue = new KeyValue<>("derp", 1);
    }

    @Test
    public void isString() {
        storeString.setItem("derp");
        Assertions.assertEquals(storeString.getItem(), "derp");
    }

    @Test
    public void keyValue() {
        Assertions.assertEquals(keyValue.toString(), "derp-1");
    }
}
