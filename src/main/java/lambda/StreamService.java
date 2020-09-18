package lambda;

import java.util.Currency;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamService {
    private final Function<String, String> lastWord =
            (phrase) -> {
                final int lastSpace = phrase.lastIndexOf(" ");

                return lastSpace < 0 ? phrase : phrase.substring(lastSpace +1);
            };

    private final Predicate<String> non_empty =
            s -> !s.isEmpty();

    public String summarize(final String[] description) {
        /*return Arrays.asList(description).stream()
                .peek(s -> System.out.println("About to filter: " + s))
                .filter(non_empty)
                .peek(s -> System.out.println("About to map: " + s))
                .map(lastWord)
                .peek(s -> System.out.println("About to reduce " + s))
                .*/
        return "";
    }

    public int sumNumbersReduce(List<Integer> numbers, int startValue) {
        return numbers
                .stream()
                .reduce(startValue, Integer::sum); //(x,y) -> x+y
    }
}
