package lambda.streams;

import java.util.stream.Stream;

public class ParallelStreamPractice {


    public long parallelStreamSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
