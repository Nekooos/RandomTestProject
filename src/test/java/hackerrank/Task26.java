package hackerrank;

import lambda.CompareService;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task26 {
    //https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
    @Test
    public void task26() {
        int[] scores = {100,100,50,40,40,20,10};
        int[] alice = {5,25,50,120};
        int[] scores2 = {100,90,90,80,75,60};
        int[] alice2 = {50,65,77,90,102};
        Arrays.stream(climbingLeaderboard(scores, alice)) //6,4,2,1
                .forEach(System.out::println);
        System.out.println("");
        Arrays.stream(climbingLeaderboard(scores2, alice2)) //6,4,2,1
               .forEach(System.out::println);
    }

    private int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] sortedScore = IntStream.of(scores)
                .distinct()
                .toArray();

        int i= sortedScore.length-1;
        for(int j=0; j<alice.length; j++) {
            while(i>=0) {
                if(alice[j]>=sortedScore[i]) {
                    i--;
                }
                else {
                    alice[j] = i+2;
                    break;
                }
            }
            if(i<0) {
                alice[j] = 1;
            }
        }
        return alice;
    }

    //to slow to pass 1 test case
    private int[] climbingLeaderboard4(int[] scores, int[] alice) {
        int[] sortedScore = IntStream.of(scores)
                .distinct()
                .toArray();

        for(int j=0; j<alice.length; j++) {
            boolean isAdded= false;
            for(int i=0; i<sortedScore.length; i++) {
                if(alice[j] >= sortedScore[i]) {
                    alice[j] = (i+1);
                    isAdded=true;
                    break;
                }
            }
            if(!isAdded) {
                alice[j] = sortedScore.length + 1;
            }
        }
        return alice;
    }

    // to slow to pass 3 test cases
    private int[] climbingLeaderboard3(int[] scores, int[] alice) {
        List<Integer> aliceScorePosition = new ArrayList<>();
        int[] sortedScore = IntStream.of(scores)
                .distinct()
                .toArray();

        for(int val : alice) {
            boolean isAdded= false;
            for(int i=0; i<sortedScore.length; i++) {
                if(val >= sortedScore[i]) {
                    aliceScorePosition.add(i+1);
                    isAdded=true;
                    break;
                }
            }
            if(!isAdded) {
                aliceScorePosition.add(sortedScore.length + 1);
            }
        }
        return aliceScorePosition.stream().mapToInt(s->s).toArray();
    }

    // to slow to pass 4 test case
    private int[] climbingLeaderboard2(int[] scores, int[] alice) {
        List<Integer> aliceScorePosition = new ArrayList<>();
        List<Integer> scoresList = Arrays.stream(scores)
                .boxed()
                .collect(Collectors.toList());
        scoresList = scoresList.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int alicePreviousPosition;
        for(int val : alice) {
            scoresList.add(val);

            for(int i=0; i<scoresList.size(); i++) {
                if(scoresList.get(i) == val) {
                    alicePreviousPosition = i;
                    if(alicePreviousPosition !=0) {
                        scoresList.remove(i);
                    }
                    aliceScorePosition.add(i+1);
                }
            }
        }
        return aliceScorePosition.stream().mapToInt(s->s).toArray();
    }
}
