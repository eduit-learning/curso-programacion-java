package eduit.learning.modulo3.laboratorio.utils;

public class Holder<T> {

    private T value;

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
