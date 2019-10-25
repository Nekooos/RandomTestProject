package hackerrank;

import org.junit.jupiter.api.Test;

public class Task13 {
    //https://www.hackerrank.com/challenges/kangaroo/problem
    @Test
    public void task14() {
        System.out.println(kangaroo(0, 2, 5, 3));
        System.out.println(kangaroo(0, 3, 4, 2));
        System.out.println(kangaroo(43 ,2 ,70 ,2));
    }
    //x startPos v jumpLength
    private String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1 > v2 && ((x2-x1)%(v1-v2)) == 0) {
            return "YES";
        }
        else
            return "NO";
    }
}
