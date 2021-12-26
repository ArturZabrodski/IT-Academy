package exam.ex7;

public class Pair<T, K> {

    private T firstValue;
    private K lastValue;

    public Pair() {
    }

    public Pair(T firstValue, K lastValue) {
        this.firstValue = firstValue;
        this.lastValue = lastValue;
    }

    public T first() {
        return firstValue;
    }

    public K last() {
        return lastValue;
    }

    public Pair<T, K> swap() {
        return new Pair(lastValue, firstValue);
    }

    public Pair<T, K> replaceFirst(Object newValue) {
        return new Pair(newValue, lastValue);
    }

    public Pair<T, K> replaceLast(Object newValue) {
        return new Pair(firstValue, newValue);
    }
}
