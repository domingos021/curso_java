package mysql.exception;

/*
 * Exception thrown when a database operation violates
 * referential integrity constraints.
 *
 * Example:
 * - Attempting to delete a parent record that is still
 *   referenced by child records through foreign keys.
 */
public class DbIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DbIntegrityException(String message) {
        super(message);
    }
}