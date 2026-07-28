package atualizar_dados;

import mysql.DB;

import java.sql.*;

public class AtualizarDados {

    public static void main(String[] args) {

        // Declaration of connection and statement variables
        Connection conn = null;
        PreparedStatement pstmSeller = null;      // First UPDATE (Salary raise by department)
        PreparedStatement pstmDepartment = null;  // Second UPDATE (Department name)

        /*
         * Seller update parameters.
         * Example: Adding 500.00 to the salary of all sellers in department 2.
         */
        double salaryIncrease = 500.00;
        int departmentIdForSalaryRaise = 2;

        /*
         * Department update parameters.
         * Example: Renaming department with ID 2.
         */
        String newDepartmentName = "Alimentos e Bebidas";
        int departmentIdToUpdate = 2;

        try {

            // Opens the database connection
            conn = DB.getConnection();

            // =========================================================================
            // 1. FIRST UPDATE: Increase Seller's Salary by Department
            // =========================================================================
            /*
             * CRITICAL: Always include a WHERE clause in UPDATE statements
             * to avoid modifying all records in the table!
             */
            pstmSeller = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE DepartmentId = ?"
            );

            /*
             * Assigns values to SQL placeholders (?):
             * #1 (?) -> Amount to add to existing BaseSalary
             * #2 (?) -> Target DepartmentId in WHERE clause
             */
            pstmSeller.setDouble(1, salaryIncrease);
            pstmSeller.setInt(2, departmentIdForSalaryRaise);

            int rowsSellerAffected = pstmSeller.executeUpdate(); // atualiza a linha

            if (rowsSellerAffected > 0) {
                System.out.println("--- SELLERS UPDATED ---");
                System.out.printf(
                        "Added %.2f to the salary of all sellers in Department ID %d (Affected sellers: %d)%n%n",
                        salaryIncrease,
                        departmentIdForSalaryRaise,
                        rowsSellerAffected
                );
            } else {
                System.out.println("No sellers found in Department ID: " + departmentIdForSalaryRaise + "\n");
            }

            // =========================================================================
            // 2. SECOND UPDATE: Rename Department
            // =========================================================================
            pstmDepartment = conn.prepareStatement(
                    "UPDATE department "
                            + "SET Name = ? "
                            + "WHERE Id = ?"
            );

            /*
             * Assigns values to SQL placeholders (?):
             * #1 (?) -> New Department Name
             * #2 (?) -> Target Department Id in WHERE clause
             */
            pstmDepartment.setString(1, newDepartmentName);
            pstmDepartment.setInt(2, departmentIdToUpdate);

            int rowsDepartment = pstmDepartment.executeUpdate();

            if (rowsDepartment > 0) {
                System.out.println("--- DEPARTMENT UPDATED ---");
                System.out.printf(
                        "Department ID %d renamed to: %s%n%n",
                        departmentIdToUpdate,
                        newDepartmentName
                );
            } else {
                System.out.println("No department found with ID: " + departmentIdToUpdate + "\n");
            }

            System.out.println("Done! Seller rows affected: " + rowsSellerAffected);
            System.out.println("Done! Department rows affected: " + rowsDepartment);

        } catch (SQLException e) {

            /*
             * Database error handling.
             */
            if (e.getErrorCode() == 1062) {
                System.out.println("Update failed: Unique constraint violation (duplicated data).");
            } else {
                System.out.println("Error while executing the SQL update statement:");
                e.printStackTrace();
            }

        } finally {

            // Safely close statements and connection
            DB.closeStatement(pstmSeller);
            DB.closeStatement(pstmDepartment);
            DB.closeConnection();

        }
    }
}