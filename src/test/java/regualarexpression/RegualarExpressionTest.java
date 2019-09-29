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

        String thirdAlphaNumeric = "aBcdef12345";
        assertEquals("XBXdefXXX45", thirdAlphaNumeric.replaceAll("[a-c1-3]", "X"));
        assertEquals("XXXdefXXX45", thirdAlphaNumeric.replaceAll("[a-cA-Z1-3]", "X"));
        // ?i ignore case sensitivity
        assertEquals("XXXXXXXXX45", thirdAlphaNumeric.replaceAll("(?i)[a-z1-3]", "X"));

        //replace all numbers
        String numbers = "12345a";
        assertEquals("XXXXXa", numbers.replaceAll("\\d", "X"));
        //replace all non digits
        String nonDigits = "abcde1";
        assertEquals("XXXXX1", nonDigits.replaceAll("\\D", "X"));

        String newLineWhitespaceBlank = "1blanks   \ta tab and a new line \n";
        assertEquals("1blanksXXXXaXtabXandXaXnewXlineXX", newLineWhitespaceBlank.replaceAll("\\s", "X"));
        assertEquals("1blanks   Xa tab and a new line \n", newLineWhitespaceBlank.replaceAll("\\t", "X"));
        assertEquals("XXXXXXX   \tX XXX XXX X XXX XXXX \n", newLineWhitespaceBlank.replaceAll("\\S", "X"));
        assertEquals("1blanksXXXXaXtabXandXaXnewXlineXX", newLineWhitespaceBlank.replaceAll("\\W", "X"));
        assertEquals("XXXXXXX   \tX XXX XXX X XXX XXXX \n", newLineWhitespaceBlank.replaceAll("\\w", "X"));
        assertEquals("X1blanksX   \tXaX XtabX XandX XaX XnewX XlineX \n", newLineWhitespaceBlank.replaceAll("\\b", "X"));
    }

    @Test
    public void matchesTest() {
        String alphanumeric = "abcdfghijk";
        assertFalse(alphanumeric.matches("^abcdf"));
        // false since its not the complete String
        assertFalse(alphanumeric.matches("^abcdef"));
        assertTrue(alphanumeric.matches("abcdefghijk"));
    }
}
