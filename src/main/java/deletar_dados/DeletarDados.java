package deletar_dados;

import mysql.DB;
import mysql.exception.DbException;
import mysql.exception.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarDados {

    public static void main(String[] args) {

        // Declaration of connection and statement variables
        Connection conn = null;
        PreparedStatement pstmSeller = null;      // First DELETE (Seller by ID)
        PreparedStatement pstmDepartment = null;  // Second DELETE (Department by ID)

        /*
         * Seller deletion parameters.
         * Example: Deleting seller with ID 2.
         */
        int sellerIdToDelete = 2;

        /*
         * Department deletion parameters.
         * Example: Deleting department with ID 5.
         */
        int departmentIdToDelete = 2;

        try {

            // Opens the database connection
            conn = DB.getConnection();

            // =====================================================================
            // 1. FIRST DELETE: Remove a Seller by ID
            // =====================================================================
            /*
             * CRITICAL: Always include a WHERE clause in DELETE statements
             * to avoid clearing the entire table!
             */
            pstmSeller = conn.prepareStatement(
                    "DELETE FROM seller "
                            + "WHERE Id = ?"
            );

            /*
             * Assigns value to SQL placeholder (?):
             * #1 (?) -> Target Seller Id in WHERE clause
             */
            pstmSeller.setInt(1, sellerIdToDelete);

            int rowsSellerDeleted = pstmSeller.executeUpdate();

            if (rowsSellerDeleted > 0) {
                System.out.println("--- SELLER DELETED ---");
                System.out.printf("Seller ID %d deleted successfully.%n%n", sellerIdToDelete);
            } else {
                System.out.println("No seller found with ID: " + sellerIdToDelete + "\n");
            }

            // =====================================================================
            // 2. SECOND DELETE: Remove a Department by ID
            // =====================================================================
            pstmDepartment = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE Id = ?"
            );

            /*
             * Assigns value to SQL placeholder (?):
             * #1 (?) -> Target Department Id in WHERE clause
             */
            pstmDepartment.setInt(1, departmentIdToDelete);

            int rowsDepartmentDeleted = pstmDepartment.executeUpdate();

            if (rowsDepartmentDeleted > 0) {
                System.out.println("--- DEPARTMENT DELETED ---");
                System.out.printf("Department ID %d deleted successfully.%n%n", departmentIdToDelete);
            } else {
                System.out.println("No department found with ID: " + departmentIdToDelete + "\n");
            }

            System.out.println("Done! Seller rows deleted: " + rowsSellerDeleted);
            System.out.println("Done! Department rows deleted: " + rowsDepartmentDeleted);

        }
        catch (SQLException e) {

            /*
             * MySQL error code 1451 indicates a Foreign Key Constraint violation.
             * It occurs when attempting to delete a record that is still referenced
             * by another table.
             */
            if (e.getErrorCode() == 1451) {
                throw new DbIntegrityException(
                        "Cannot delete record because it is referenced by another table."
                );
            }
            else {
                throw new DbException(e.getMessage());
            }

        }
        catch (DbIntegrityException e) {
            System.out.println("Integrity error: " + e.getMessage());
        }
        catch (DbException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        finally {

            // Safely close statements and connection
            DB.closeStatement(pstmSeller);
            DB.closeStatement(pstmDepartment);
            DB.closeConnection();

        }
    }
}