package edu.isel.adeetc.snake.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtils {
    /**
     * Method used to get a list composed of the given elements.
     * @param elements  - the variable argument list of elements to be added to the collection
     * @param <T>       - the type of elements stored in the list
     * @return          - the list containing the received elements
     */
    @SafeVarargs
    public static <T> List<T> listOf(T... elements) {
        final ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return list;
    }
}
