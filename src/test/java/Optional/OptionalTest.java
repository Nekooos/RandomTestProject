package Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionalTest {
    @Test
    public void optionalTests () {
        String testString = "testString";
        Optional<String> word = Optional.of(testString);
        assertEquals(word.get(), "testString");
    }

    @Test
    public void optionalNullableTests() {
        String testString = null;
        Optional<String> word = Optional.ofNullable(testString);
        assertEquals(Optional.empty(), word);
    }

    @Test
    public void optionalException() {
        String testString = null;
        Optional<String> word = Optional.ofNullable(testString);
        assertThrows(NoSuchElementException.class, word::get);
    }

    @Test
    public void optionalOfNullException() {
        assertThrows(NullPointerException.class, () ->
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
        assertEquals("", word1);
        assertEquals("", word2);
        assertEquals("present", word3);
    }

    @Test
    public void optionaloftestException() {
        String testString1 = null;
        assertThrows(NullPointerException.class, () -> Optional.of(testString1).orElse(""));
    }
}
