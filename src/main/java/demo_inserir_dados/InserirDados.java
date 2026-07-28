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
         */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Declaration of connection and statement variables
        Connection conn = null;
        PreparedStatement pstmSeller = null;      // First INSERT (Seller)
        PreparedStatement pstmDepartment = null;  // Second INSERT (Department)

        /*
         * Seller data to be inserted.
         */
        String name = "samia Jovete";
        String email = "samiajovte@gmail.com";
        String birthDateStr = "27/09/1985";
        double baseSalary = 3000.00;
        int departmentId = 4;

        /*
         * Department data to be inserted.
         */
        String dep1 = "Comestiveis";
        String dep2 = "Laticinios";

        try {

            // Opens the database connection
            conn = DB.getConnection();

            // =========================================================================
            // 1. FIRST INSERTION: Seller
            // =========================================================================
            pstmSeller = conn.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            LocalDate birthDate = LocalDate.parse(birthDateStr, dtf);

            pstmSeller.setString(1, name);
            pstmSeller.setString(2, email);
            pstmSeller.setDate(3, Date.valueOf(birthDate));
            pstmSeller.setDouble(4, baseSalary);
            pstmSeller.setInt(5, departmentId);

            int rowsSeller = pstmSeller.executeUpdate();

            if (rowsSeller > 0) {
                try (ResultSet rset = pstmSeller.getGeneratedKeys()) {
                    if (rset.next()) {
                        int id = rset.getInt(1);
                        System.out.println("--- SELLER INSERTED ---");
                        System.out.printf(
                                "Id: %d%n"
                                        + "Name: %s%n"
                                        + "Email: %s%n"
                                        + "Birth Date: %s%n"
                                        + "Base Salary: %.2f%n"
                                        + "Department Id: %d%n%n",
                                id, name, email, birthDate.format(dtf), baseSalary, departmentId
                        );
                    }
                }
            }

            // =========================================================================
            // 2. SECOND INSERTION: Multiple Departments
            // =========================================================================
            // Note the SQL syntax for multiple parameter placeholders: VALUES (?), (?)
            pstmDepartment = conn.prepareStatement(
                    "INSERT INTO department (Name) VALUES (?), (?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            /*
             * Assigns values to the SQL parameters:
             * #1 (?) -> "Comestiveis"
             * #2 (?) -> "Laticinios"
             */
            pstmDepartment.setString(1, dep1);
            pstmDepartment.setString(2, dep2);

            int rowsDepartment = pstmDepartment.executeUpdate();

            if (rowsDepartment > 0) {
                try (ResultSet rset = pstmDepartment.getGeneratedKeys()) {
                    System.out.println("--- DEPARTMENTS INSERTED ---");
                    // Using 'while' because multiple rows were inserted
                    while (rset.next()) {
                        int id = rset.getInt(1);
                        System.out.println("Generated Department ID: " + id);
                    }
                    System.out.println();
                }
            }

            System.out.println("Done! Total seller rows affected: " + rowsSeller);
            System.out.println("Done! Total department rows affected: " + rowsDepartment);

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {
                System.out.println("Email already registered.");
            } else {
                System.out.println("Error while executing the SQL statement:");
                e.printStackTrace();
            }

        } catch (DateTimeParseException e) {

            System.out.println("Invalid date format:");
            e.printStackTrace();

        } finally {

            // Close both statements safely
            DB.closeStatement(pstmSeller);
            DB.closeStatement(pstmDepartment);
            DB.closeConnection();

        }
    }
}