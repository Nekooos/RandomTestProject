package random.fibonacci;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIterate {
    public List<Integer> streamIterateLimit(int iterations) {
        return Stream.iterate(1, n -> n + 1)
                .limit(iterations)
                .collect(Collectors.toList());
    }

    public int fibonacci(int n) {
        List<Integer> FibonacciNumbers = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(n)
                .map(t -> t[0])
                .collect(Collectors.toList());
        return FibonacciNumbers.get(FibonacciNumbers.size()-1);
    }
}
