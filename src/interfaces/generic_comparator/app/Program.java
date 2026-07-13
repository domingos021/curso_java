package interfaces.generic_comparator.app;

import interfaces.generic_comparator.model.entities.Employee_Comparator;
import interfaces.generic_comparator.utils.GenericComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        // Creates a list to store Employee objects read from the file.
        List<Employee_Comparator> list = new ArrayList<>();

        // Path of the input file.
        String path = "C:\\temp01\\employees02.txt";

        /*
         * Opens the file using try-with-resources.
         * The BufferedReader is automatically closed after use.
         */
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            // Reads the first line from the file.
            String employeeCsv = br.readLine();

            /*
             * Reads the file line by line.
             * Expected format: name,salary (e.g., Maria Brown,4300.00)
             */
            while (employeeCsv != null) {

                // Splits the CSV line into fields.
                String[] fields = employeeCsv.split(",");

                /*
                 * Creates an Employee object.
                 * fields[0] -> employee name
                 * fields[1] -> employee salary (converted from String to Double)
                 */
                list.add(
                        new Employee_Comparator(
                                fields[0],
                                Double.parseDouble(fields[1])
                        )
                );

                // Reads the next line.
                employeeCsv = br.readLine();
            }

            /*
             * Sorts employees by name in ascending order.
             *
             * Since Employee_Comparator doesn't implement Comparable, we provide
             * the sorting rule externally via a Lambda expression.
             * This Lambda is wrapped by our GenericComparator utility.
             */
            Collections.sort(
                    list,
                    GenericComparator.ascending(
                            (e1, e2) -> e1.getName().compareTo(e2.getName())
                    )
            );

            System.out.println("Employees sorted by name:");
            for (Employee_Comparator emp : list) {
                System.out.println(emp); // Utilizes the overridden toString() method
            }

            /*
             * Sorts employees by salary in ascending order.
             *
             * Demonstrates flexibility: the same list is rearranged using a
             * completely different criterion without modifying the entity class.
             */
            Collections.sort(
                    list,
                    GenericComparator.ascending(
                            (e1, e2) -> e1.getSalary().compareTo(e2.getSalary())
                    )
            );

            System.out.println("\nEmployees sorted by salary:");
            for (Employee_Comparator emp : list) {
                System.out.println(emp);
            }

            /*
             * Sorts employees by salary in descending order.
             *
             * The GenericComparator.descending utility automatically reverses
             * the behavior of the salary Lambda comparison.
             */
            Collections.sort(
                    list,
                    GenericComparator.descending(
                            (e1, e2) -> e1.getSalary().compareTo(e2.getSalary())
                    )
            );

            System.out.println("\nEmployees sorted by salary descending:");
            for (Employee_Comparator emp : list) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            // Handles errors that may occur while reading the file.
            System.out.println("Error: " + e.getMessage());
        }
    }
}