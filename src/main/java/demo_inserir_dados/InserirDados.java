package demo_inserir_dados;

import mysql.DB;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InserirDados {

    public static void main(String[] args) {

        /*
         * Modern Java 8+ API: DateTimeFormatter to define the date pattern (dd/MM/yyyy).
         * It is an immutable and thread-safe class, unlike the legacy SimpleDateFormat.
         */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Declaration of connection and statement variables (java.sql package)
        Connection conn = null;      // Represents an active connection to the database
        PreparedStatement pstm = null; // Precompiled SQL statement with placeholders (?)

        /*
         * Seller data to be inserted.
         * Centralizing data in local variables makes code maintenance easier
         * and avoids redundancy in console logs.
         */
        String name = "Aline Jovete";
        String email = "alinejovte@gmail.com";
        String birthDateStr = "27/09/1985";
        double baseSalary = 3000.00;
        int departmentId = 4;

        try {

            // Opens the database connection using the DB utility class
            conn = DB.getConnection();

            /*
             * Prepares the INSERT SQL statement.
             *
             * The Statement.RETURN_GENERATED_KEYS flag is an overload that requests
             * the database to return the auto-generated primary key (Id).
             */
            pstm = conn.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            /*
             * Parses the String into a LocalDate (java.time API).
             */
            LocalDate birthDate = LocalDate.parse(birthDateStr, dtf);

            /*
             * Assigns values to the SQL parameters (placeholders ?).
             * Parameter index in PreparedStatement starts at 1.
             *
             * #1 (?) -> Name
             * #2 (?) -> Email
             * #3 (?) -> BirthDate (java.sql.Date.valueOf converts LocalDate directly to java.sql.Date)
             * #4 (?) -> BaseSalary
             * #5 (?) -> DepartmentId
             */
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setDate(3, Date.valueOf(birthDate));
            pstm.setDouble(4, baseSalary);
            pstm.setInt(5, departmentId);

            /*
             * Executes the INSERT command.
             * The executeUpdate() method returns the number of affected rows.
             */
            int rowsAffected = pstm.executeUpdate();

            /*
             * Checks if the insertion was successful (at least 1 row affected).
             */
            if (rowsAffected > 0) {

                /*
                 * Try-with-resources: retrieves the ResultSet containing the generated Id.
                 * The ResultSet is automatically closed at the end of the try block,
                 * eliminating the need for additional finally blocks for rset.
                 */
                try (ResultSet rset = pstm.getGeneratedKeys()) {

                    if (rset.next()) {

                        // Retrieves the returned Id from the first column of the ResultSet
                        int id = rset.getInt(1);

                        // Prints the registered data confirming the generated Id from the database
                        System.out.printf(
                                "Id: %d%n"
                                        + "Name: %s%n"
                                        + "Email: %s%n"
                                        + "Birth Date: %s%n"
                                        + "Base Salary: %.2f%n"
                                        + "Department Id: %d%n%n",
                                id,
                                name,
                                email,
                                birthDate.format(dtf), // Displays formatted date
                                baseSalary,
                                departmentId
                        );
                    }
                }

            } else {

                System.out.println("No rows were affected.");

            }

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {

            /*
             * Database error handling.
             *
             * Error code 1062 in MySQL indicates a UNIQUE constraint violation.
             * In this case, it means the provided email already exists in the seller table.
             */
            if (e.getErrorCode() == 1062) {

                System.out.println("Email already registered.");

            } else {

                System.out.println("Error while executing the SQL statement:");
                e.printStackTrace();

            }

        } catch (DateTimeParseException e) {

            // Specific exception handling for the java.time API (invalid date format)
            System.out.println("Invalid date format:");
            e.printStackTrace();

        } finally {

            /*
             * Closing JDBC resources (Statement and Connection).
             *
             * Since JDBC interacts with external resources outside the JVM,
             * objects must be closed manually to prevent resource leaks.
             */
            DB.closeStatement(pstm);
            DB.closeConnection();

        }
    }
}