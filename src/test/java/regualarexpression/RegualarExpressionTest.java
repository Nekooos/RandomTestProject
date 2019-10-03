package regualarexpression;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String alphaNumeric = "abcDeeeee";
        // replace 4 e
        assertEquals("Xe", alphaNumeric.replaceAll("^abcDe{4}", "X"));
        // any number of e
        assertEquals("X", alphaNumeric.replaceAll("^abcDe+", "X"));
        assertEquals("X", alphaNumeric.replaceAll("^abcDe*", "X"));

        String newLineWhitespaceBlank = "1blanks   \ta tab and a new line \n";
        assertEquals("1blanksXXXXaXtabXandXaXnewXlineXX", newLineWhitespaceBlank.replaceAll("\\s", "X"));
        assertEquals("1blanks   Xa tab and a new line \n", newLineWhitespaceBlank.replaceAll("\\t", "X"));
        assertEquals("XXXXXXX   \tX XXX XXX X XXX XXXX \n", newLineWhitespaceBlank.replaceAll("\\S", "X"));
        assertEquals("1blanksXXXXaXtabXandXaXnewXlineXX", newLineWhitespaceBlank.replaceAll("\\W", "X"));
        assertEquals("XXXXXXX   \tX XXX XXX X XXX XXXX \n", newLineWhitespaceBlank.replaceAll("\\w", "X"));
        assertEquals("X1blanksX   \tXaX XtabX XandX XaX XnewX XlineX \n", newLineWhitespaceBlank.replaceAll("\\b", "X"));
    }

    @Test
    public void qualifiersAndPatterns() {
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>Paragraph about somthing</p>");
        htmlText.append("<p>Paragrath about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<h2></h2>");
        htmlText.append("<p>Summary of something</p>");

        // anything before and anything after
        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        assertTrue(matcher.matches());
        //* zero or more + empty
        String h2Pattern2 = "(<h2>.*?</h2>)";
        Pattern pattern2 = Pattern.compile(h2Pattern2);
        Matcher matcher2 = pattern2.matcher(htmlText);

        matcher2.reset();
        List<String> h2List = new ArrayList<>();
        while(matcher2.find()) {
            h2List.add(matcher2.group(1));
        }
        assertEquals("<h2>Sub-heading</h2>", h2List.get(0));
        assertEquals("<h2>Summary</h2>", h2List.get(1));
        assertEquals("<h2></h2>", h2List.get(2));

        String h2Pattern3 = "(<h2>)(.+?)(</h2>)";
        Pattern pattern3 = Pattern.compile(h2Pattern3);
        Matcher matcher3 = pattern3.matcher(htmlText);

        matcher3.reset();
        List<String> h2List2 = new ArrayList<>();
        while(matcher3.find()) {
            h2List2.add(matcher3.group(2));
        }
        assertEquals("Sub-heading", h2List2.get(0));
        assertEquals("Summary", h2List2.get(1));
    }

    @Test
    public void matchesTest() {
        String alphanumeric = "abcdfghijk";
        assertFalse(alphanumeric.matches("^abcdf"));
        // false since its not the complete String
        assertFalse(alphanumeric.matches("^abcdef"));
        assertTrue(alphanumeric.matches("abcdefghijk"));
    }

    @Test
    public void andOrNot() {

    }
}
