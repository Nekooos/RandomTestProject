package lambda.currying;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Calculation<T, R> {
    R apply(T t);

    default <V> Calculation<T, V> andThen(Calculation<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    default <V> Calculation<T, V> add(V v) {
        return t -> v;
    }
}
/*

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);

    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
    */


