package edu.isel.adeetc.snake.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    /**
     * Method used to get
     * @param elements  - the variable argument list of elements to be added to the collection
     * @param <T>       - the type of elements stored in the list
     * @return          - the list containing the received elements
     */
    public static <T> List<T> listOf(T... elements) {
        final ArrayList<T> list = new ArrayList<>();
        for (T elem : elements) {
            list.add(elem);
        }
        return list;
    }
}
