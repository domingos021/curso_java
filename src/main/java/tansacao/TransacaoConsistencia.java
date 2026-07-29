package tansacao;

import mysql.DB;
import mysql.exception.DbException;
import mysql.exception.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Demonstrates how to use database transactions to maintain data consistency.
 *
 * A transaction groups multiple SQL operations into a single unit of work.
 *
 * If all operations succeed:
 *      -> COMMIT
 *
 * If any operation fails:
 *      -> ROLLBACK
 *
 * This guarantees that the database is never left in an inconsistent state.
 *
 * Transaction flow:
 *
 *      Start Transaction
 *             |
 *             V
 *     Operation 1 (DELETE)
 *             |
 *             V
 *     Operation 2 (DELETE)
 *             |
 *     +-------+-------+
 *     |               |
 * Success          Failure
 *     |               |
 *     V               V
 *  COMMIT         ROLLBACK
 */

public class TransacaoConsistencia {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = DB.getConnection();      // Opens a connection to the database.

            // Starts a transaction.
            // All SQL operations executed after this point become part of the same transaction.
            // The changes will only be saved after commit() is called.
            // If an error occurs before commit(), rollback() can undo all changes.
            conn.setAutoCommit(false);

            stm = conn.createStatement();

            int rows1 = stm.executeUpdate(
                    "UPDATE seller SET BaseSalary = 2500 WHERE DepartmentId = 1"
            );

            /*
             * Simulates an error in the middle of the transaction.
             *
             * When the exception is thrown, execution leaves the try block
             * and moves to the catch block.
             *
             * Without a transaction, the first UPDATE would already have
             * been committed to the database.
             *
             * With a transaction, rollback() undoes all changes made since
             * setAutoCommit(false), ensuring that either all operations
             * succeed or none of them are applied.


            int x = 1;
            if (x < 2) {
                throw new SQLException("Fake error.");
            }

             */

            int rows2 = stm.executeUpdate(
                    "UPDATE seller SET BaseSalary = 3500 WHERE DepartmentId = 2"
            );

            // Ends the transaction by making all changes permanent.
            conn.commit();

            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);

        }
        catch (SQLException e) {

            // Ensure the connection exists before calling rollback()
            // to avoid a NullPointerException.
            if (conn != null) {
                try {
                    /*
                     * Suppose the transaction contains three SQL operations:
                     *
                     * 1st -> Executes successfully.
                     * 2nd -> Fails and throws an exception.
                     * 3rd -> Never executes because the exception interrupts the try block.
                     *
                     * Control immediately moves to this catch block.
                     *
                     * If the connection is still open, rollback() is called.
                     * It cancels the entire transaction and undoes all changes
                     * made since setAutoCommit(false) was called.
                     *
                     * As a result, the database returns to the state it was in
                     * before the transaction started.
                     */
                    conn.rollback();
                }
                // when rollback fails, which is a very complicated situation
                // 'cause we tried back the operation but it failed
                catch (SQLException e2) {
                    throw new DbException("Error trying to back caused by: " + e2.getMessage());
                }
            }

            throw new DbException(
                    "Error: Transaction not concluded: Rollback! cause by: "
                            + e.getMessage()
            );

        }
        finally {

            /*
             * The finally block is GUARANTEED to execute whether the try block
             * completed successfully or an exception was thrown/caught.
             *
             * It handles resource cleanup to prevent database leaks.
             */

            // 1. Always close statements first before closing the main connection.
            DB.closeStatement(stm);

            // 2. Restore auto-commit state to default (true) if the connection exists.
            // This is crucial when working with Connection Pools, so that reused
            // connections do not remain stuck in manual-commit mode.
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            }
            catch (SQLException e) {
                throw new DbException("Error resetting auto-commit mode: " + e.getMessage());
            }

            // 3. Close the connection to release the database resources back to the pool/server.
            DB.closeConnection();
        }
    }
}