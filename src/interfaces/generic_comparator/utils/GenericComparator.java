package interfaces.generic_comparator.utils;


import java.util.Comparator;

/*
 * Generic Comparator utility.
 *
 * This class creates comparison rules for any type.
 *
 * The comparison logic is provided externally through
 * a lambda expression.
 */
public class GenericComparator {

    /*
     * Creates an ascending comparator.
     *
     * Example:
     * String -> A to Z
     * Integer -> 1,2,3
     * Double -> smaller to larger
     */
    public static <T> Comparator<T> ascending(Comparator<T> comparator) {

        return comparator;
    }


    /*
     * Creates a descending comparator by reversing
     * the comparison rule.
     */
    public static <T> Comparator<T> descending(Comparator<T> comparator) {

        return comparator.reversed();
    }
}