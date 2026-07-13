package interfaces.generic_comparator.model.entities;


/*
 * Employee is a simple entity class.
 *
 * This class does not implement Comparable because
 * it does not define a natural ordering.
 *
 * The comparison rules will be created externally
 * using Comparator.
 */
public class Employee_Comparator {

    private String name;
    private Double salary;

    public Employee_Comparator(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + ", " + salary;
    }
}
