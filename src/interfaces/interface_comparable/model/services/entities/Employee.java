package interfaces.interface_comparable.model.services.entities;

/*
 * Employee implements Comparable<Employee> to define its natural ordering.
 *
 * By implementing Comparable, the class provides a comparison rule
 * between two Employee objects through the compareTo() method.
 *
 * This allows Java methods such as Collections.sort() and Arrays.sort()
 * to sort Employee objects automatically without requiring an external
 * Comparator.
 */
public class Employee implements Comparable<Employee> {

    // Employee's name.
    private String name;

    // Employee's salary.
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /*
     * Compares this Employee with another Employee.
     *
     * The comparison is based on the employee's name,
     * defining the natural ordering of Employee objects.
     *
     * Returns:
     *   < 0 : this employee comes before the other.
     *     0 : both employees are equal for sorting.
     *   > 0 : this employee comes after the other.
     */
    @Override
    public int compareTo(Employee other) {
        /*
         * Fulfilling the Comparable interface contract.
         * 1st Criterion: Compare this employee's name with the other employee's name
         * lexicographically (alphabetically) to determine their sorting order.
         */
        int nameComparison = name.compareTo(other.getName());

        // If names are different, this result is enough to determine the order.
        if (nameComparison != 0) {
            return nameComparison;
        }

        /*
         * 2nd Criterion (Tie-breaker): If names are identical,
         * compare by salary from lowest to highest.
         */
        return salary.compareTo(other.getSalary());
    }
}