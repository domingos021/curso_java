package interfaces.interface_comparable.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        // List that will store all names read from the file.
        List<String> list = new ArrayList<>();

        // Path of the text file containing one name per line.
        String path = "C:\\temp01\\in02.txt";

        /*
         * Opens the file using try-with-resources.
         * The BufferedReader is automatically closed when the block ends.
         */
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            // Reads the first line of the file.
            String name = br.readLine();

            /*
             * Continues reading until the end of the file.
             * readLine() returns null when there are no more lines.
             */
            while (name != null) {
                list.add(name);      // Adds the current name to the list.
                name = br.readLine(); // Reads the next line.
            }

            /*
             * Sorts the list in its natural order.
             *
             * String implements the Comparable<String> interface,
             * so Collections.sort() uses the compareTo() method
             * to arrange the names alphabetically.
             */
            Collections.sort(list);

            // Displays the sorted names.
            for (String s : list) {
                System.out.println(s);
            }

        } catch (IOException e) {

            // Handles errors that may occur while reading the file.
            System.out.println("Error: " + e.getMessage());
        }
    }
}