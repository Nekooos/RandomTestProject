package hackerrank;

import org.junit.jupiter.api.Test;

public class Task45 {
    @Test
    public void task45() {
        int[][] hourglasses = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println(hourglassSum(hourglasses)); // 19
        int[][] hourglasses2 = {
                {- 1, - 1,   0, - 9, - 2, - 2,},
                {- 2, - 1, - 6, - 8, - 2, - 5,},
                {- 1, - 1, - 1, - 2, - 3, - 4,},
                {- 1, - 9, - 2, - 4, - 4, - 5,},
                {- 7, - 3, - 3, - 2, - 9, - 9,},
                {- 1, - 3, - 1, - 2, - 4, - 5,}
        };
        System.out.println(hourglassSum(hourglasses2)); // -6
    }

    private int hourglassSum(int[][] arr) {
        int highest = Integer.MIN_VALUE;
        for(int i=0; i<4; i++) {
            for(int j=1; j<5; j++) {
                int hourglassSum = arr[i][j-1] + arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j-1] + arr[i+2][j] + arr[i+2][j+1];
                highest = Math.max(hourglassSum, highest);
            }
        }
        return highest;
    }
}
