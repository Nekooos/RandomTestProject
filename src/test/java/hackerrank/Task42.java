package hackerrank;

import org.junit.jupiter.api.Test;

public class Task42 {
    @Test
    public void task42() {
        //System.out.println(repeatedString("aba", 10));
        //System.out.println(repeatedString("jdiacikk", 899491)); // 112436
        System.out.println(repeatedString("ebcdddafdfeffaddbceddebafbbebebbbcefcbcdfbaabecfaaeeaaffdfccffbdeeaabcfeecfcecbfebacefebdfaeedadebdf", 561984209086L));
    }

    private long repeatedString(String s, long n) {
        long repeatedString = ( n / (long) s.length());
        long remainingString = ( n % (long) s.length());
        long count = s.chars().filter(c -> c == 'a').count();

        count = count * repeatedString;

        for(int i=0; i< remainingString; i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }

        return count;

    }

}

