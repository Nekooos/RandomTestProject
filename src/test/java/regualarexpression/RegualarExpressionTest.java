package regualarexpression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegualarExpressionTest {
    @Test
    public void replaceAllTest() {
        String string = "This car is red";
        String replaceAllString = string.replaceAll("red", "yellow");
        Assertions.assertEquals("This car is yellow", replaceAllString);

        String alphanumeric = "abcdefghijk";
        Assertions.assertEquals("XXXXXXXXXXX", alphanumeric.replaceAll(".", "X"));
        Assertions.assertEquals("ABCdefghijk", alphanumeric.replaceAll("^abc", "ABC"));

        String secondAlphanumeric = "abcdefghijkabc";
        Assertions.assertEquals("ABCdefghijkabc", secondAlphanumeric.replaceAll("^abc", "ABC"));

        String end = alphanumeric.replaceAll("jk$", "ends here");
        Assertions.assertEquals("abcdefghiends here", end);
    }

    @Test
    public void matchesTest() {
        String alphanumeric = "abcdefghijk";
        Assertions.assertFalse(alphanumeric.matches("^abcdf"));
        Assertions.assertFalse(alphanumeric.matches("^abcdef"));
        Assertions.assertTrue(alphanumeric.matches("abcdefghijk"));
    }
}
