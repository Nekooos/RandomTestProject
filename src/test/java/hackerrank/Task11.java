package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11 {
    //https://www.hackerrank.com/challenges/grading/problem
    //75, 67, 40, 33
    @Test
    public void task11() {
        List<Integer> grades = Arrays.asList(73, 67, 38, 33);
        List<Integer> convertedGrades = grades.stream()
                .map(grade -> {
                    if (grade % 5 >= 3 && grade >= 38) {
                        if((grade+(5-grade%5))%5 == 0) {
                            return (grade+(5-grade%5));
                        }
                    }
                    return grade;
                })
                .collect(Collectors.toList());
        convertedGrades.forEach(System.out::println);
    }
}