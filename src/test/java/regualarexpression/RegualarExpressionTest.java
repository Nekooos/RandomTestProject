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
        // ^start
        assertEquals("ABCdefghijkabc", secondAlphanumeric.replaceAll("^abc", "ABC"));
        // end$
        String end = alphanumeric.replaceAll("jk$", "Replaced here");
        assertEquals("abcdefghiReplaced here", end);
        // [ace] replace aei with X
        assertEquals("XbXdXfghijk", alphanumeric.replaceAll("[ace]", "X"));
        // [ace][df] replace if char followed by d or f
        String newAlphaNumeric = "abcdefghijk";
        assertEquals("abXefghijk", newAlphaNumeric.replaceAll("[ace][d]", "X"));
        assertEquals("XXefghijk", newAlphaNumeric.replaceAll("[ace][db]", "X"));

        String name = "Anna";
        assertEquals("Anna", name.replaceAll("[Aa]nna", "Anna"));
        assertEquals("Anna", name.replaceAll("[BbAa]nna", "Anna"));
        assertEquals("inna", name.replaceAll("[iAa]nna", "inna"));
        // Replace all except Aa with b
        assertEquals("Abba", name.replaceAll("[^Aa]", "b"));
    }

    @Test
    public void matchesTest() {
        String alphanumeric = "abcdefghijk";
        assertFalse(alphanumeric.matches("^abcdf"));
        // false since its not the complete String
        assertFalse(alphanumeric.matches("^abcdef"));
        assertTrue(alphanumeric.matches("abcdefghijk"));
    }
}
