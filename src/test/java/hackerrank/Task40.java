package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task40 {
    @Test
    public void task40() {
        int[] sticks = {5,4,4,2,2,8}; // 6,4,2,1
        Arrays.stream(cutTheSticks(sticks)).forEach(System.out::println);
    }

    private int[] cutTheSticks(int[] arr) {
        List<Integer> sticks = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> sticksCutCount = new ArrayList<>();

        while(sticks.size() > 0) {
            sticksCutCount.add(sticks.size());
            int shortestStick = getShortestStick(sticks);
            sticks = cutSticks(sticks, shortestStick);
        }

        return sticksCutCount.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> cutSticks(List<Integer> sticks, int shortestStick) {
        return sticks.stream()
                .map(stick -> stick-shortestStick)
                .filter(stick -> stick != shortestStick)
                .collect(Collectors.toList());
    }

    private int getShortestStick(List<Integer> sticks) {
        return sticks.stream()
                .min(Comparator.comparing(Integer::valueOf))
                .get();
    }
}
