package Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {
    @Test
    public void optionalTests () {
        String testString = "testString";
        Optional<String> word = Optional.of(testString);
        Assertions.assertEquals(word.get(), "testString");
    }

    @Test
    public void optionalNullableTests() {
        String testString = null;
        Optional<String> word = Optional.ofNullable(testString);
        Assertions.assertEquals(Optional.empty(), word);
    }

    @Test
    public void optionalException() {
        String testString = null;
        Optional<String> word = Optional.ofNullable(testString);
        Assertions.assertThrows(NoSuchElementException.class, word::get);
    }

    @Test
    public void optionalOfNullException() {
        Assertions.assertThrows(NullPointerException.class, () ->
                    Optional.of(null)
                );
    }

    @Test
    public void optionalOfTests() {
        String testString1 = null;
        String testString2 = "";
        String testString3 = "present";
        String word1 = Optional.ofNullable(testString1).orElse("");
        String word2 = Optional.of(testString2).orElse("default");
        String word3 = Optional.of(testString3).orElse("");
        Assertions.assertEquals("", word1);
        Assertions.assertEquals("", word2);
        Assertions.assertEquals("present", word3);
    }

    @Test
    public void optionaloftestException() {
        String testString1 = null;
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(testString1).orElse(""));
    }
}
