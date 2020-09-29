package generic;

import java.util.List;

public class ExtendsNumber {
    public double sumListToDouble(List<? extends Number> numbers) {
        return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }
}
