package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task38 {
    // https://www.hackerrank.com/challenges/append-and-delete/problem
    @Test
    public void task38() {
        System.out.println("sample input 1 " + appendAndDelete("aba", "aba", 7)); // Yes
        System.out.println("sample input 2 "+appendAndDelete("ashley", "ash", 2)); // No
        System.out.println("sample input 3 "+appendAndDelete("qwerasdf", "qwerbsdf", 6)); // No
        System.out.println("sample input 4 "+appendAndDelete("hackerhappy", "hackerrank", 9));
    }
    // number of operations to get same string > k ? yes : no
    private String appendAndDelete(String s, String t, int k) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        if (k > (s.length()+t.length())) {
            return "Yes";
        }

        int commonChars = 0;
        for (int i=0; i<(Math.min(s.length(),t.length())); i++) {
            if (first[i] == second[i]) {
                commonChars = i + 1;
            }
            else {
                break;
            }
        }

        int left = s.length()+t.length()-2*commonChars;
        if (k >= left) {
            if ((left - k) % 2 == 0) {
                return "Yes";
            } else {
                return "No";
            }
        }
        else {
                return "No";
        }
    }

}
