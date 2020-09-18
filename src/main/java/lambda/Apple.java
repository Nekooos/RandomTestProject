package lambda;

public class Apple {
    private Enum<Colors> color;
    private int weight;

    public Apple(Enum<Colors> color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Enum<Colors> getColor() {
        return color;
    }

    public void setColor(Enum<Colors> color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
