package interfaces.interface_comparable.model;


/*
 * Comparable<T> defines the natural ordering of objects.
 *
 * When a class implements this interface, it must provide the
 * compareTo() method, which determines how one object should be
 * compared to another object of the same type.
 *
 * The compareTo() method returns:
 *   < 0 : this object comes before the other object.
 *     0 : both objects are considered equal for sorting.
 *   > 0 : this object comes after the other object.
 *
 * Classes that implement Comparable can be sorted automatically
 * using methods such as Collections.sort() or Arrays.sort().
 */

public interface Comparable <T>  {
    int compareTo(T other);
}
