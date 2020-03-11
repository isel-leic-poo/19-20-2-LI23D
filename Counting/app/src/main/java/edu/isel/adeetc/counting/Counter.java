package edu.isel.adeetc.counting;

public class Counter {

    private int value;

    public Counter(int initialValue) {
        value = initialValue;
    }

    public void increment() {
        value += 1;
    }

    public void decrement() {
        value -= 1;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}
