package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Task46 {
    @Test
    public void task46() {
        String[] strings = {"aba", "baba", "aba", "xzxb"};
        String[] queries = {"aba", "xzxb", "ab"};
        Arrays.stream(matchingStrings(strings, queries)).forEach(System.out::println);
    }

    private int[] matchingStrings(String[] strings, String[] queries) {
        for(int i=0; i<strings.length; i++) {
            for(int j=0; j<queries.length; j++) {
                int count = 0;
                if(strings[i].matches(queries[j])) {
                    count += 1;
                }
            }
        }
        int[] placeHolder = {1};
        return placeHolder;
    }

}
