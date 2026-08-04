package main.projetobd_demo_dao_jdbc.applicaction;

import main.projetobd_demo_dao_jdbc.applicaction.controllers.DepartmentService;
import main.projetobd_demo_dao_jdbc.applicaction.ui.DepartmentMenu;
import main.projetobd_demo_dao_jdbc.model.dao.DaoFactory;
import main.projetobd_demo_dao_jdbc.model.dao.DepartmentDao;
import mysql.exception.DbException;

import java.util.Locale;
import java.util.Scanner;

/**
 * Main application entry point for Department management (CLI).
 * Configures the layered dependency tree (DAO -> Service -> UI Menu)
 * and handles global application exceptions.
 *
 * <pre>
 * ARCHITECTURE AND LAYER INTERMEDIATION TREE:
 *
 *                     ┌────────────────────────┐
 *                     │    TestMain02 (Main)   │
 *                     └───────────┬────────────┘
 *                                 │ Instantiates & Injects
 *                                 ▼
 *                     ┌────────────────────────┐
 *                     │     DepartmentMenu     │ (UI / Presentation)
 *                     └───────────┬────────────┘
 *                                 │
 *     Captures Scanner Input      │ Calls business operations
 *     & Displays to Console       │ (findById, save, update, etc.)
 *                                 ▼
 *                     ┌────────────────────────┐
 *                     │   DepartmentService    │ (Service / Controller)
 *                     └───────────┬────────────┘
 *                                 │
 *     Business Rules & Layer      │ Delegates data calls
 *     Intermediation              │ to the interface
 *                                 ▼
 *                     ┌────────────────────────┐
 *                     │     DepartmentDao      │ (Data Interface)
 *                     └───────────┬────────────┘
 *                                 │
 *                                 │ Implemented by
 *                                 ▼
 *                     ┌────────────────────────┐
 *                     │   DepartmentDaoJDBC    │ (Concrete Implementation)
 *                     └───────────┬────────────┘
 *                                 │
 *                                 │ Executes SQL
 *                                 ▼
 *                     ┌────────────────────────┐
 *                     │   MySQL Database       │ (Persistence)
 *                     └────────────────────────┘
 * </pre>
 */
public class TestMain02 {

    public static void main(String[] args) {
        // Sets US locale for standardized number/currency formatting (decimal point)
        Locale.setDefault(Locale.US);

        /*
         * Try-with-resources ensures the Scanner is automatically closed
         * when the application finishes, preventing resource leaks.
         */
        try (Scanner sc = new Scanner(System.in)) {

            // 1. DATA LAYER INITIALIZATION (DAO)
            // The Factory hides the JDBC implementation details and provides the DepartmentDao interface
            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

            // 2. SERVICE LAYER INITIALIZATION (CONTROLLER)
            // The Service receives the DAO via Dependency Injection in its constructor.
            // It acts as the intermediary between the UI and the Database.
            DepartmentService departmentService = new DepartmentService(departmentDao);

            // 3. PRESENTATION LAYER INITIALIZATION (UI MENU)
            // The Menu receives the Scanner (for user inputs) and the Service (to execute operations)
            DepartmentMenu departmentMenu = new DepartmentMenu(sc, departmentService);

            // 4. MENU LIFECYCLE EXECUTION
            // Starts the interactive CLI loop
            departmentMenu.runMenu();

        } catch (DbException e) {
            // Handles database-specific exceptions (e.g., connection lost, foreign key issues)
            System.err.println("\n[CRITICAL DATABASE ERROR]");
            System.err.println("Cause: " + e.getMessage());
            System.err.println("Please check your MySQL database connection or credentials.");

        } catch (Exception e) {
            // Generic catch-all for unexpected application failures
            System.err.println("\n[UNEXPECTED APPLICATION ERROR]");
            System.err.println("Details: " + e.getMessage());
            e.printStackTrace();

        } finally {
            System.out.println("\nApplication safely shut down.");
        }
    }
}