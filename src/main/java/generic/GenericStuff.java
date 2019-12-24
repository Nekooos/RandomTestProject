package generic;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericStuff {
    public <A> A timed(String description, Supplier<A> code) {
        Consumer<String> defaultOutPut = System.out::println;
        return timed(description, defaultOutPut, code);
    }

    public <A> A timed(String description, Consumer<String> output, Supplier<A> code) {
        final Date before = new Date();
        A result = code.get();
        final long duration = new Date().getTime() - before.getTime();
        output.accept(description + "took" + duration + " milliseconds");
        return result;
    }
}
