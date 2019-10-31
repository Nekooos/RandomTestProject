package hackerrank;

import org.junit.jupiter.api.Test;

public class Task18 {
    //https://www.hackerrank.com/challenges/day-of-the-programmer/problem
    @Test
    public void task18() {
        System.out.println(dayOfProgrammer(2016)); // 12.09.2016
        System.out.println(dayOfProgrammer(1800)); // 12.09.1800
        System.out.println(dayOfProgrammer(1918)); // 26.09.1918
    }

    String dayOfProgrammer(int year) {
        if (year == 1918){
            return "26.09.2018";
        } else if ((year <= 1917) && (year%4 == 0) || ((year > 1918) && (year % 400 == 0 || (year % 4 == 0) && year % 100 !=0))) {
            return "12.09." + year;
        } else {
            return "13.09." + year;
        }
    }
}
