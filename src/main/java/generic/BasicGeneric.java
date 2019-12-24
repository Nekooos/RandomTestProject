package generic;
/*
    T item
 */
public class BasicGeneric<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return ""+this.item.toString();
    }
}
