package instrucoes;

/**
 * Reference guide for Database and SQL commands (MySQL focus),
 * ordered by daily usage frequency.
 * Designed as a quick cheat sheet in your IDE.
 */
public class ComandosSQL {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("      SQL / DATABASE CHEAT SHEET - FREQUENCY      ");
        System.out.println("==================================================");

        /*
         * 1. DAILY DATA MANIPULATION (DML - Usados continuamente no dia a dia)
         * Reading, inserting, updating, and removing table records.
         */

        // Retrieve specific columns with filtering and ordering
        // Example: SELECT id, name, email FROM seller WHERE department_id = 4 ORDER BY name ASC;
        String selectFiltered = "SELECT col1, col2 FROM table_name WHERE condition ORDER BY col1 ASC;";

        // Retrieve all columns from a table (frequently used for quick data checks)
        // Example: SELECT * FROM seller;
        String selectAll = "SELECT * FROM table_name;";

        // Insert new records into a table
        // Example: INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES ('Domingos', 'domingos@gmail.com', '1985-08-21', 1000.00, 4);
        String insert = "INSERT INTO table_name (col1, col2) VALUES ('value1', 'value2');";

        // Update existing records (CRITICAL: ALWAYS use WHERE clause to avoid corrupting all rows!)
        // Example: UPDATE seller SET BaseSalary = 1200.00 WHERE Id = 1;
        String update = "UPDATE table_name SET col1 = 'newValue' WHERE id = 1;";

        // Delete specific records (CRITICAL: ALWAYS use WHERE clause!)
        // Example: DELETE FROM seller WHERE Id = 5;
        String delete = "DELETE FROM table_name WHERE id = 1;";


        /*
         * 2. RELATIONAL QUERIES & AGGREGATIONS (Usados em relatórios e buscas avançadas)
         * Combining multiple tables and calculating totals/counts.
         */

        // Join two tables based on a foreign key relationship
        // Example: SELECT seller.Name, department.Name AS Dept FROM seller INNER JOIN department ON seller.DepartmentId = department.Id;
        String innerJoin = "SELECT t1.col, t2.col FROM table1 t1 INNER JOIN table2 t2 ON t1.fk_id = t2.pk_id;";

        // Left Join to include all rows from table1 even if no match exists in table2
        String leftJoin = "SELECT t1.col, t2.col FROM table1 t1 LEFT JOIN table2 t2 ON t1.fk_id = t2.pk_id;";

        // Aggregate functions: Count, Sum, Average, Grouping
        // Example: SELECT DepartmentId, COUNT(*) AS TotalSellers, AVG(BaseSalary) FROM seller GROUP BY DepartmentId;
        String groupBy = "SELECT col1, COUNT(*), AVG(col2) FROM table_name GROUP BY col1 HAVING COUNT(*) > 1;";


        /*
         * 3. TABLE & SCHEMA STRUCTURE (DDL - Usados na criação/evolução do modelo)
         * Creating and modifying tables, constraints, and indexes.
         */

        // Create a new table with Primary Key, Foreign Key, and AUTO_INCREMENT
        String createTable = "CREATE TABLE seller (\n"
                + "    Id INT NOT NULL AUTO_INCREMENT,\n"
                + "    Name VARCHAR(60) NOT NULL,\n"
                + "    Email VARCHAR(100) NOT NULL UNIQUE,\n"
                + "    BirthDate DATE NOT NULL,\n"
                + "    BaseSalary DOUBLE NOT NULL,\n"
                + "    DepartmentId INT NOT NULL,\n"
                + "    PRIMARY KEY (Id),\n"
                + "    FOREIGN KEY (DepartmentId) REFERENCES department(Id)\n"
                + ");";

        // Add a new column to an existing table
        // Example: ALTER TABLE seller ADD COLUMN Phone VARCHAR(20);
        String alterTableAdd = "ALTER TABLE table_name ADD COLUMN column_name DATATYPE;";

        // Drop a table permanently from the database
        String dropTable = "DROP TABLE IF EXISTS table_name;";


        /*
         * 4. TRANSACTIONS & SAFETY (Usados ao executar alterações críticas)
         * Ensuring data integrity during multiple related SQL operations.
         */

        // Start a manual transaction context
        String startTransaction = "START TRANSACTION; -- or BEGIN";

        // Confirm and save changes permanently
        String commit = "COMMIT;";

        // Cancel and revert all changes made since START TRANSACTION
        String rollback = "ROLLBACK;";


        /*
         * 5. MYSQL COMMAND LINE & UTILITIES (Usados via Terminal / CMD)
         * Administrative commands to manage MySQL service and backups.
         */

        // Connect to MySQL server via terminal with password prompt
        // Example: mysql -u root -p
        String mysqlConnect = "mysql -u username -p";

        // List all databases available on the server
        String showDatabases = "SHOW DATABASES;";

        // Select a database to work with
        // Example: USE course_jdbc;
        String useDatabase = "USE database_name;";

        // List all tables inside the selected database
        String showTables = "SHOW TABLES;";

        // Inspect table schema/structure (column names, types, keys)
        // Example: DESCRIBE seller;
        String describeTable = "DESCRIBE table_name; -- or DESC table_name;";

        // Export/Backup database to a .sql file via terminal (mysqldump)
        String backup = "mysqldump -u username -p database_name > backup_file.sql";

        // Restore/Import database from a .sql file via terminal
        String restore = "mysql -u username -p database_name < backup_file.sql";


        // Print quick daily reminder
        System.out.println("\nEssential SQL Flow:");
        System.out.println("1. " + useDatabase);
        System.out.println("2. " + selectAll);
        System.out.println("3. " + insert);
        System.out.println("4. " + update);
    }
}