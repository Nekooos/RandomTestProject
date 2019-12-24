package hackerrank;

import org.junit.jupiter.api.Test;

public class Task44 {
    @Test
    public void task44() {
        //System.out.println(chocolateFeast(10,2,5)); //6
        //System.out.println(chocolateFeast(12,4,4)); //3
        //System.out.println(chocolateFeast(6,2,2)); //5
        System.out.println(chocolateFeast(43203 , 60 , 5)); // 899
    }

    private int chocolateFeast(int n, int c, int m) {
        int totalChoc = n / c;
        int totalWrappers = totalChoc;
        int chocFromWrapper;
        while (m <= totalWrappers) {
            int wrapperToGive = totalWrappers - (totalWrappers % m);
            chocFromWrapper = totalWrappers / m;
            totalWrappers = (totalWrappers - wrapperToGive) + chocFromWrapper;
            totalChoc = totalChoc + chocFromWrapper;
        }
        return totalChoc;
    }

}
