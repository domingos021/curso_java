package interfaces.interface_comparable.app;

import interfaces.interface_comparable.model.services.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        // Creates a list that will store Employee objects read from the file.
        List<Employee> list = new ArrayList<>();

        // Path of the input file containing employee data.
        String path = "C:\\temp01\\employees.txt";

        /*
         * Opens the file using try-with-resources.
         *
         * The BufferedReader is automatically closed after the try block,
         * even if an exception occurs.
         */
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            // Reads the first line of the file.
            String employeeCsv = br.readLine();

            /*
             * Reads the file line by line until the end.
             *
             * Each line follows the format:
             * name,salary
             */
            while (employeeCsv != null) {

                // Splits the current CSV line into separate fields.
                String[] fields = employeeCsv.split(",");

                /*
                 * Creates an Employee object from the CSV fields.
                 *
                 * Example:
                 * Maria Brown,4300.00
                 *
                 * fields[0] -> employee name ("Maria Brown")
                 * fields[1] -> employee salary ("4300.00")
                 *
                 * Since values read from a file are Strings,
                 * the salary must be converted to Double before
                 * creating the Employee object.
                 */
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));


                // Reads the next line from the file.
                employeeCsv = br.readLine();

                /*
                 * The loop execution now returns to the 'while (employeeCsv != null)'
                 * condition at the top. If the new line contains data, the process
                 * repeats; if the end of the file is reached, the loop terminates.
                 */
            }

            /*
             * Sorts the Employee objects using their natural ordering.
             *
             * The sorting rule is defined by the multi-criterion compareTo() method
             * implemented in the Employee class.
             *
             * In this example, employees are sorted primarily by name,
             * using their salary as a tie-breaker if names are identical.

             * Activating the sorting engine.
             * Collections.sort() triggers the internal sorting algorithm (TimSort),
             * which loops through the list and uses our custom compareTo() method
             * to rearrange the employees in place.
             */

            Collections.sort(list);

            /*
             * Displays the employees after sorting.
             *
             * The order shown here reflects the natural multi-criterion ordering:
             * alphabetical by name, and lowest-to-highest salary for identical names.
             */
            for (Employee emp : list) {
                System.out.println(emp.getName() + ", " + emp.getSalary());
            }

        } catch (IOException e) {

            // Handles errors that may occur while reading the file.
            System.out.println("Error: " + e.getMessage());
        }
    }
}