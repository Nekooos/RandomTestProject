package hackerrank;

import org.junit.jupiter.api.Test;

public class Task23 {
    @Test
    public void tsk23() {
        int[] keyboards = {3,1};
        int[] drives = {5,2,8};
        System.out.println(getMoneySpent(keyboards, drives, 10)); //9, -1 if not enough
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int sum = 0;
        int previousSum = 0;
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                if (keyboard + drive <= b && (keyboard + drive > previousSum)) {
                    sum = keyboard + drive;
                    previousSum = sum;
                }
            }
        }
        if(sum>0) {
            return sum;
        } else {
            return -1;
        }
    }
}
