package edu.isel.adeetc.counting;

public class Counter {

    private int value;

    public Counter(int initialValue) {
        if (initialValue < 0)
            throw new IllegalArgumentException();
        value = initialValue;
    }

    public void increment() {
        value += 1;
    }

    public void decrement() {
        if (value > 0)
            value -= 1;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}
