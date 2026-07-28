package recuperar_dados;

import mysql.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) {

        /*
         * Tests the database connection using the DB class.
         *
         * The DB class:
         * - reads the db.properties file;
         * - gets the URL, username, and password;
         * - creates a connection to the MySQL database.
         */

        // Interface variables from the java.sql package.
        Connection conn = null; // Represents an active connection to the database.
        Statement stmt = null;  // Executes SQL statements.
        ResultSet rs = null;    // Stores the rows returned by a SELECT query.


        try {
            // Creates a connection to the database.
            conn = DB.getConnection();

            // Creates a Statement object used to execute SQL commands.
            stmt = conn.createStatement();

            // Executes the SQL query and stores the result.
            rs = stmt.executeQuery("SELECT * FROM department ");

            System.out.println("Connection established successfully!");
            System.out.println("Database connected: " + !conn.isClosed());



            /*
             * Iterates through the rows returned by the query.
             *
             * rs.next() moves the cursor to the next row until
             * there are no more rows to read.
             *
             * The ResultSet object stores the data returned by
             * the SQL query.
             *
             * The get methods are used to retrieve values from
             * the current row.
             *
             * rs.getInt("Id") retrieves the value from the Id column.
             * rs.getString("Name") retrieves the value from the Name column.
             */
            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + ", " +
                                rs.getString("Name")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error while connecting to the database:");
            e.printStackTrace();
        } finally {
            /*
             * Closes all database resources.
             *
             * The resources used by JDBC are external resources
             * managed by the database, not by the JVM garbage collector.
             * Therefore, they must be closed manually.
             *
             * The DB class methods are used to safely close each resource
             * and handle possible exceptions during the closing process.
             *
             * This prevents resource leaks, such as keeping database
             * connections open unnecessarily.
             */
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
    }
}