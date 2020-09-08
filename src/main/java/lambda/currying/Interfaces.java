package lambda.currying;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ToLongFunction;

public class Interfaces {
    // It represents an operation that accepts two input arguments and returns no result.
    BiConsumer<String, String> biConsumer = (string1, string2) -> System.out.println(string1 + " " + string2);

    //It represents an operation that accepts a single argument and returns no result.
    Consumer<String> consumer = string1 -> System.out.println(string1);

    //It represents a function that returns a result of long type.
    ToLongFunction<Integer> toLongFunction = integer -> integer;
}
