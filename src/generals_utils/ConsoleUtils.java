package generals_utils;

public class ConsoleUtils {

    /**
     * Prints a formatted title.
     */
    public static void title(String title) {

        System.out.println();
        System.out.println("====================================");
        System.out.println(" " + title.toUpperCase());
        System.out.println("====================================");
    }

    /**
     * Prints a success message.
     */
    public static void success(String message) {
        System.out.println("\n✔ " + message);
    }

    /**
     * Prints an error message.
     */
    public static void error(String message) {
        System.out.println("\n✖ " + message);
    }

    /**
     * Prints an information message.
     */
    public static void info(String message) {
        System.out.println("\n" + message);
    }

    /**
     * Displays the main application menu.
     */
    public static void showSellerMenu() {

        System.out.println();
        System.out.println("====================================");
        System.out.println("         SELLER DAO MENU");
        System.out.println("====================================");
        System.out.println("1 - Find seller by ID");
        System.out.println("2 - Find sellers by Department");
        System.out.println("3 - Find all sellers");
        System.out.println("4 - Insert seller");
        System.out.println("5 - Update seller");
        System.out.println("6 - Delete seller");
        System.out.println("0 - Exit");
        System.out.println("====================================");
    }

    /**
     * Displays the main application menu for Departments.
     */
    public static void showDepartmentMenu() {

        System.out.println();
        System.out.println("====================================");
        System.out.println("         DEPARTMENT DAO MENU        ");
        System.out.println("====================================");
        System.out.println("1 - Find department by ID");
        System.out.println("2 - Find all departments");
        System.out.println("3 - Insert department");
        System.out.println("4 - Update department");
        System.out.println("5 - Delete department");
        System.out.println("0 - Back to Main Menu");
        System.out.println("====================================");
    }

    /**
     * Prevents instantiation.
     */
    private ConsoleUtils() {
    }
}