package java_eleven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ElevenStringTest {
    @Test
    public void javaElevenStringTest() {
        var blank1 = " ";
        var blank2 = "\n ";
        Assertions.assertTrue(blank1.isBlank());
        Assertions.assertTrue(blank2.isBlank());

        String twoLines = "1. first line\n2. second line";
        List<String> lines = twoLines.lines().collect(Collectors.toList());
        Assertions.assertEquals("1. first line",lines.get(0));
        Assertions.assertEquals("2. second line",lines.get(1));
    }
}
