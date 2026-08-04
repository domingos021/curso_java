package main.projetobd_demo_dao_jdbc.applicaction.ui;

import generals_utils.ConsoleUtils;
import generals_utils.utils.Leitor;
import main.projetobd_demo_dao_jdbc.applicaction.controllers.DepartmentService;
import main.projetobd_demo_dao_jdbc.model.entities.Department;
import mysql.exception.DbException;

import java.util.List;
import java.util.Scanner;

/**
 * UI View class responsible for handling CLI user interactions
 * and delegating business requests to the DepartmentService.
 */
public class DepartmentMenu {

    private final Scanner sc;
    private final DepartmentService departmentService;

    public DepartmentMenu(Scanner sc, DepartmentService departmentService) {
        this.sc = sc;
        this.departmentService = departmentService;
    }

    /*
     * Controls the main application workflow, displaying options
     * and routing user input to the corresponding methods.
     */
    public void runMenu() {
        boolean running = true;

        while (running) {
            ConsoleUtils.showDepartmentMenu();

            int option = Leitor.lerNumeroInteiro(sc, "Choose an option: ");

            switch (option) {
                case 1:
                    findDepartmentById();
                    break;

                case 2:
                    findAllDepartments();
                    break;

                case 3:
                    insertDepartments();
                    break;

                case 4:
                    updateDepartment();
                    break;

                case 5:
                    deleteDepartment();
                    break;

                case 0:
                    System.out.println("\nReturning to main menu...");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid option!");
            }
        }
    }

    /*
     * Option 1: Prompts for a Department ID and prints it if found.
     */
    private void findDepartmentById() {
        ConsoleUtils.title("Find Department by ID");

        int id = Leitor.lerNumeroInteiro(sc, "Department ID: ");
        Department department = departmentService.findById(id);

        if (department != null) {
            System.out.println("\nDepartment found:");
            System.out.println(department);
        } else {
            System.out.println("\nNo department found with ID: " + id);
        }
    }

    /*
     * Option 2: Retrieves and prints all Departments registered in the database.
     */
    private void findAllDepartments() {
        ConsoleUtils.title("Find all departments");

        List<Department> list = departmentService.findAll();

        if (list.isEmpty()) {
            System.out.println("\nNo departments found.");
        } else {
            System.out.println("\nDepartments found:");
            list.forEach(System.out::println);
        }
    }

    /*
     * Option 3: Allows inserting one or multiple Departments in batch.
     */
    private void insertDepartments() {
        ConsoleUtils.title("Insert department");

        int departmentRegistry = Leitor.lerNumeroInteiro(
                sc,
                "How many departments do you want to insert?: "
        );

        for (int i = 0; i < departmentRegistry; i++) {
            System.out.printf("Insert department #%d:%n", i + 1);

            String name = Leitor.lerTexto(sc, "Name: ");

            Department department = new Department(null, name);
            departmentService.save(department);

            ConsoleUtils.success(
                    "Department inserted successfully! New id: " + department.getId()
            );
        }
    }

    /*
     * Option 4: Fetches a Department by ID and allows updating its details.
     */
    private void updateDepartment() {
        ConsoleUtils.title("Update department");

        int id = Leitor.lerNumeroInteiro(sc, "Enter ID of the department to update: ");
        Department department = departmentService.findById(id);

        if (department == null) {
            System.out.println("\nNo department found with ID: " + id);
            return;
        }

        ConsoleUtils.title("Current Department Details");
        System.out.println(department);

        String name = Leitor.lerTexto(sc, "New Name: ");
        department.setName(name);

        departmentService.update(department);

        ConsoleUtils.title("The new department Details");
        System.out.println(department);
        System.out.println("\nDepartment updated successfully!");
    }

    /*
     * Option 5: Deletes a Department from the database by ID with error handling.
     */
    private void deleteDepartment() {
        ConsoleUtils.title("Delete department");

        int id = Leitor.lerNumeroInteiro(sc, "Enter ID of the department to delete: ");

        Department department = departmentService.findById(id);

        if (department == null) {
            System.out.println("\nNo department found with ID: " + id);
            return;
        }

        try {
            departmentService.deleteById(id);
            ConsoleUtils.success("Department deleted successfully!");
        } catch (DbException e) {
            System.out.println("\nError deleting department: " + e.getMessage());
        }
    }
}