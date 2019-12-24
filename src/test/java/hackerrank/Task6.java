package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Task6 {
    @Test
    public void task6() {
        int n = 6;
        int addCharTimes = 0;
        int addSpaceTimes = n;
        for(int j = 0; j<n; j++) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int k=addSpaceTimes; k>0; k-- ){
                stringBuilder.append(" ");
            }
            for (int i = 0; i <= addCharTimes; i++) {

                stringBuilder.append("#");
            }
            addCharTimes++;
            addSpaceTimes--;

            System.out.println(stringBuilder);
        }
    }
}
