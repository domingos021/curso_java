package mysql;

import mysql.exception.DbException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    /*
     * Opens a new database connection or returns the existing one.
     *
     * First call:
     * - The conn attribute is null.
     * - The method loads the database properties.
     * - Creates a connection with MySQL.
     * - Stores the connection in the conn attribute.
     *
     * Next calls:
     * - The conn attribute already contains a connection.
     * - The existing connection is returned directly.
     *
     * This implements a simple Singleton pattern for the database connection.
     */
    public static Connection getConnection() {

        if (conn == null) {
            try {
                Properties prop = loadProperties();
                // Loads database configuration from the db.properties file.

                String url = prop.getProperty("dburl");
                // Retrieves the database URL from the properties file.

                String usuario = prop.getProperty("user");
                // Retrieves the database username from the properties file.

                String senha = prop.getProperty("password");
                // Retrieves the database password from the properties file.

                conn = DriverManager.getConnection(url, usuario, senha);
                // Creates a database connection using the loaded information
                // and stores it in the conn variable.

            } catch (SQLException e) {
                throw new DbException(
                        "Error connecting to the database: " + e.getMessage(), e
                );
            }
        }

        return conn;
        // Returns the active database connection.
    }


    /*
     * Closes the current database connection.
     *
     * The connection is closed only if it exists.
     * After closing, the conn attribute is reset to null.
     */
    public static void closeConnection() {

        if (conn != null) {
            try {
                conn.close();
                conn = null;

            } catch (SQLException e) {
                throw new DbException(
                        "Error closing the connection: " + e.getMessage(), e
                );
            }
        }
    }


    /*
     * Loads database configuration from the db.properties file.
     *
     * The file is located inside the resources folder.
     *
     * Flow:
     *
     * db.properties
     *       |
     *       v
     * ClassLoader locates the file
     *       |
     *       v
     * InputStream opens the file for reading
     *       |
     *       v
     * Properties object loads the key-value pairs
     *       |
     *       v
     * Returns the configured Properties object.
     */
    private static Properties loadProperties() {

        try (InputStream inputStream =
                     DB.class.getClassLoader()
                             .getResourceAsStream("db.properties")) {

            if (inputStream == null) {
                throw new DbException(
                        "The db.properties file was not found!"
                );
            }

            Properties prop = new Properties();

            prop.load(inputStream);
            // Loads the properties from the input stream.

            return prop;

        } catch (IOException e) {
            throw new DbException(
                    "Error reading the configuration file", e
            );
        }
    }


    /*
     * Utility method used to safely close a Statement object.
     *
     * Handles possible SQL exceptions internally, preventing checked
     * exceptions from propagating to the calling code.
     */
    public static void closeStatement(Statement stm) {

        if (stm != null) {
            try {
                stm.close();

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }


    /*
     * Utility method used to safely close a ResultSet object.
     *
     * Handles possible SQL exceptions internally, preventing checked
     * exceptions from propagating to the calling code.
     */
    public static void closeResultSet(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}