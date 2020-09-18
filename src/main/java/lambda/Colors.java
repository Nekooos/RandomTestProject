package lambda;

public enum Colors {
    RED("red"),
    GREEN("greeen");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
