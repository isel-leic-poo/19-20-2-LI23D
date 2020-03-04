package edu.isel.leic.poo;

/**
 * Data class for representing course grades.
 * Valid course grades are within the interval [0..20]
 */
public class Grade {
    /**
     * The grade, rounded.
     */
    public final int value;

    /**
     * Initiates an instance with the given value.
     * @param value The grade's value, in the interval [0..20]
     */
    public Grade(int value) {
        if (value < 0 || value > 20)
            throw new IllegalArgumentException();
        this.value = value;
    }
}
