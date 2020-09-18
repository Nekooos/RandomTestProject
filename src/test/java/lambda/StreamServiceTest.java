package lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StreamServiceTest {
    StreamService streamService = new StreamService();

    final String[] foodDescription = new String[] {
            "Orange Carrots",
            "Yellow Bananas",
            "Huge Pumpkins",
            "Green Broccoli",
            "Bloody Meat"
    };

    @Test
    public void streamServiceTest() {
        //Assertions.assertEquals("", streamService.summarize(foodDescription));
    }

    @Test
    public void reduceNumbersTest() {
        Assertions.assertEquals(21, streamService.sumNumbersReduce(Arrays.asList(1, 2, 3, 4, 5, 6), 0));
        Assertions.assertEquals(321, streamService.sumNumbersReduce(Arrays.asList(1, 2, 3, 4, 5, 6), 300));
    }
}
