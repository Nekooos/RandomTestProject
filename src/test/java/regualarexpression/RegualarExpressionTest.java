package regualarexpression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class RegualarExpressionTest {
    private static String alphanumeric;
    private static StringBuilder htmlText;
    private static String numbers;
    private static String newLineWhitespaceBlank;

    @BeforeAll
    public static void setupBeforeAll() {
        alphanumeric = "abcdefghijk";
        numbers = "12345a";
        newLineWhitespaceBlank = "1blanks   \ta tab and a new line \n";

        htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>Paragraph about somthing</p>");
        htmlText.append("<p>Paragrath about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<h2></h2>");
        htmlText.append("<p>Summary of something</p>");
    }

    @Test
    public void replaceWordredWithYellow() {
        String string = "This car is red";
        String replaceAllString = string.replaceAll("red", "yellow");
        assertEquals("This car is yellow", replaceAllString);
    }

    @Test
    public void replaceAllWithX() {
        String alphanumeric = "abcdefghijk";
        assertEquals("XXXXXXXXXXX", alphanumeric.replaceAll(".", "X"));
        assertEquals("ABCdefghijk", alphanumeric.replaceAll("^abc", "ABC"));
    }

    @Test
    public void replaceStartAbcWithUppercase() {
        String secondAlphanumeric = "abcdefghijkabc";
        // ^start
        assertEquals("ABCdefghijkabc", secondAlphanumeric.replaceAll("^abc", "ABC"));
    }

    @Test
    public void replaceLast() {
        // end$
        String end = alphanumeric.replaceAll("jk$", "Replaced here");
        assertEquals("abcdefghiReplaced here", end);
    }

    @Test
    public void replaceACEwithX() {
        // [ace] replace aei with X
        assertEquals("XbXdXfghijk", alphanumeric.replaceAll("[ace]", "X"));
    }

    @Test
    public void replaceACEifDorDB() {
        // [ace][df] replace if char followed by d or f
        String newAlphaNumeric = "abcdefghijk";
        assertEquals("abXefghijk", newAlphaNumeric.replaceAll("[ace][d]", "X"));
        assertEquals("XXefghijk", newAlphaNumeric.replaceAll("[ace][db]", "X"));
    }

    @Test
    public void replacePartIf() {
        String name = "anna";
        // small a with A
        assertEquals("Anna", name.replaceAll("[Aa]nna", "Anna"));
        assertEquals("Anna", name.replaceAll("[BbAa]nna", "Anna"));
        // replace Aa with i
        assertEquals("inna", name.replaceAll("[iAa]nna", "inna"));
        // Replace all except Aa with b
        assertEquals("abba", name.replaceAll("[^Aa]", "b"));
    }

    @Test
    public void replacePartIf2() {
        String thirdAlphaNumeric = "aBcdef12345";
        // a-c 1-3 with X
        assertEquals("XBXdefXXX45", thirdAlphaNumeric.replaceAll("[a-c1-3]", "X"));
        // a-c A-Z 1-3 with X
        assertEquals("XXXdefXXX45", thirdAlphaNumeric.replaceAll("[a-cA-Z1-3]", "X"));
        // ?i ignore case sensitivity replace a-z 1-3 with X
        assertEquals("XXXXXXXXX45", thirdAlphaNumeric.replaceAll("(?i)[a-z1-3]", "X"));
    }

    @Test
    public void replaceAllNumbers() {
        //replace all numbers
        assertEquals("XXXXXa", numbers.replaceAll("\\d", "X"));
    }

    @Test
    public void replaceAllNonDigits() {
        //replace all non digits
        String nonDigits = "abcde1";
        assertEquals("XXXXX1", nonDigits.replaceAll("\\D", "X"));
    }

    @Test
    public void replaceE() {
        String alphaNumeric = "abcDeeeee";
        // replace abcDe and 4 e
        assertEquals("Xe", alphaNumeric.replaceAll("^abcDe{4}", "X"));
        // replace any number of e
        assertEquals("X", alphaNumeric.replaceAll("^abcDe+", "X"));
        assertEquals("X", alphaNumeric.replaceAll("^abcDe*", "X"));
    }

    public void newLineWhitespaceBlank() {
        //"1blanks   \ta tab and a new line \n"
        //space with X
        assertEquals("1blanksXXXXaXtabXandXaXnewXlineXX", newLineWhitespaceBlank.replaceAll("\\s", "X"));
        //\t with X
        assertEquals("1blanks   Xa tab and a new line \n", newLineWhitespaceBlank.replaceAll("\\t", "X"));
        assertEquals("XXXXXXX   \tX XXX XXX X XXX XXXX \n", newLineWhitespaceBlank.replaceAll("\\S", "X"));
        assertEquals("1blanksXXXXaXtabXandXaXnewXlineXX", newLineWhitespaceBlank.replaceAll("\\W", "X"));
        assertEquals("XXXXXXX   \tX XXX XXX X XXX XXXX \n", newLineWhitespaceBlank.replaceAll("\\w", "X"));
        assertEquals("X1blanksX   \tXaX XtabX XandX XaX XnewX XlineX \n", newLineWhitespaceBlank.replaceAll("\\b", "X"));
    }

    @Test
    public void qualifiersAndPatterns() {
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
