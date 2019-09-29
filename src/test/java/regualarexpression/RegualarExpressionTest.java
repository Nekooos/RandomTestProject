package regualarexpression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegualarExpressionTest {
    @Test
    public void replaceAllTest() {
        String string = "This car is red";
        String replaceAllString = string.replaceAll("red", "yellow");
        assertEquals("This car is yellow", replaceAllString);

        String alphanumeric = "abcdefghijk";
        assertEquals("XXXXXXXXXXX", alphanumeric.replaceAll(".", "X"));
        assertEquals("ABCdefghijk", alphanumeric.replaceAll("^abc", "ABC"));

        String secondAlphanumeric = "abcdefghijkabc";
        assertEquals("ABCdefghijkabc", secondAlphanumeric.replaceAll("^abc", "ABC"));

        String end = alphanumeric.replaceAll("jk$", "Replaced here");
        assertEquals("abcdefghiReplaced here", end);
    }

    @Test
    public void matchesTest() {
        String alphanumeric = "abcdefghijk";
        assertFalse(alphanumeric.matches("^abcdf"));
        assertFalse(alphanumeric.matches("^abcdef"));
        assertTrue(alphanumeric.matches("abcdefghijk"));
    }
}
