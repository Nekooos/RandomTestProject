package concurrency;

public enum Colors {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    CYAN("\u001B[36m"),
    PURPLE("\u001B[35");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
