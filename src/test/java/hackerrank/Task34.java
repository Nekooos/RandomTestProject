package hackerrank;

import org.junit.jupiter.api.Test;

public class Task34 {
    @Test
    public void task34() {
        System.out.println(viralAdvertising(3)); //9
    }

    private int viralAdvertising(int n) {
        double peoples = 5;
        double likes = 0;
        for(int i=0; i<n; i++) {
            peoples = Math.floor(peoples/2);
            likes += peoples;
            peoples = peoples*3;
        }
        return (int) likes;
    }
}
