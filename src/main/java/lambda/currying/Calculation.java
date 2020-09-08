package lambda.currying;

public interface Calculation {
    int apply(int num);

    default Calculation add(int num2) {
        return num -> num + num2;
    }

    
}
