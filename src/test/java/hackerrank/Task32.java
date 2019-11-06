package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Task32 {
    @Test
    public void task33() {
        int[] alphabetValues = {1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7};
        String word = "abc";
        System.out.println(designerPdfViewer(alphabetValues, word));
    }

    private int designerPdfViewer(int[] h, String word) {
        List<Integer> letterPositions = new ArrayList<>();
        String[] letters = word.split("");
        for(String letter : letters) {
            letterPositions.add(h[alphabetPosition(letter)]);
        }
        int tallestLetter = letterPositions.stream()
                .max(Integer::compareTo)
                .orElse(0);
        return tallestLetter * letters.length;
    }

    private int alphabetPosition(String letter) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
        int position = 0;
        for(int i=0; i<alphabet.length; i++) {
            if(alphabet[i].equals(letter)) {
                position = i;
            }
        }
        return position;
    }
}
