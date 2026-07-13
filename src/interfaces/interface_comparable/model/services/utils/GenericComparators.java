package interfaces.interface_comparable.model.services.utils;

import java.util.Comparator;

public class GenericComparators {

    /*
     * Creates a comparator that compares objects using their natural ordering.
     *
     * The type T must implement Comparable.
     *
     * Examples:
     * String  -> alphabetical order (A-Z)
     * Integer -> ascending order (1,2,3...)
     * Double  -> ascending order (smaller to larger)
     */
    public static <T extends Comparable<T>> Comparator<T> ascending() {

        return (o1, o2) -> o1.compareTo(o2);
    }


    /*
     * Creates a comparator that reverses the natural ordering.
     *
     * Examples:
     * String  -> Z-A
     * Integer -> 3,2,1
     * Double  -> larger to smaller
     */
    public static <T extends Comparable<T>> Comparator<T> descending() {

        return (o1, o2) -> o2.compareTo(o1);
    }
}
