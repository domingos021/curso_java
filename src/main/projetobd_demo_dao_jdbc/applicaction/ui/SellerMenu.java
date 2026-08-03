package main.projetobd_demo_dao_jdbc.applicaction.ui;


import generals_utils.ConsoleUtils;
import generals_utils.utils.Leitor;
import main.projetobd_demo_dao_jdbc.applicaction.controllers.SellerService;
import main.projetobd_demo_dao_jdbc.model.entities.Department;
import main.projetobd_demo_dao_jdbc.model.entities.Seller;
import mysql.exception.DbException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * UI View class responsible for handling CLI user interactions
 * and delegating business requests to the SellerService.
 */
public class SellerMenu {

    private final Scanner sc;
    private final SellerService sellerService;

    public SellerMenu(Scanner sc, SellerService sellerService) {
        this.sc = sc;
        this.sellerService = sellerService;
    }

    /*
     * Controls the main application workflow, displaying options
     * and routing user input to the corresponding methods.
     */
    public void runMenu() {
        boolean running = true;

        while (running) {
            ConsoleUtils.showSellerMenu();

            int option = Leitor.lerNumeroInteiro(sc, "Choose an option: ");

            switch (option) {
                case 1:
                    findSellerById();
                    break;

                case 2:
                    findSellersByDepartment();
                    break;

                case 3:
                    findAllSellers();
                    break;

                case 4:
                    insertSellers();
                    break;

                case 5:
                    updateSeller();
                    break;

                case 6:
                    deleteSeller();
                    break;

                case 0:
                    System.out.println("\nClosing application...");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid option!");
            }
        }
    }

    /*
     * Option 1: Prompts for a Seller ID and prints the corresponding Seller if found.
     */
    private void findSellerById() {
        ConsoleUtils.title("Find seller by ID");

        int id = Leitor.lerNumeroInteiro(sc, "Seller ID: ");
        Seller seller = sellerService.findById(id);

        if (seller != null) {
            System.out.println("\nSeller found:");
            System.out.println(seller);
        } else {
            System.out.println("\nNo seller found with ID: " + id);
        }
    }

    /*
     * Option 2: Prompts for a Department ID and lists all associated Sellers.
     */
    private void findSellersByDepartment() {
        ConsoleUtils.title("Find sellers by Department");

        int departmentId = Leitor.lerNumeroInteiro(sc, "Department ID: ");
        Department department = new Department(departmentId, null);

        List<Seller> list = sellerService.findByDepartment(department);

        if (list.isEmpty()) {
            System.out.println("\nNo sellers found for this department.");
        } else {
            System.out.println("\nSellers found:");
            list.forEach(System.out::println);
        }
    }

    /*
     * Option 3: Retrieves and prints all Sellers registered in the database.
     */
    private void findAllSellers() {
        ConsoleUtils.title("Find all sellers");

        List<Seller> list = sellerService.findAll();

        if (list.isEmpty()) {
            System.out.println("\nNo sellers found.");
        } else {
            System.out.println("\nSellers found:");
            list.forEach(System.out::println);
        }
    }

    /*
     * Option 4: Allows inserting one or multiple Sellers in batch.
     */
    private void insertSellers() {
        ConsoleUtils.title("Insert seller");

        int sellerRegistry = Leitor.lerNumeroInteiro(
                sc,
                "How many sellers do you want to insert?: "
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < sellerRegistry; i++) {
            System.out.printf("Insert seller #%d:%n", i + 1);

            String name = Leitor.lerTexto(sc, "Name: ");
            String email = Leitor.lerTexto(sc, "Email: ");
            String birthDate = Leitor.lerTexto(sc, "BirthDate (DD/MM/YYYY): ");
            double baseSalary = Leitor.lerNumeroDouble(sc, "BaseSalary: ");
            int departmentId = Leitor.lerNumeroInteiro(sc, "DepartmentId: ");

            /*
             * Creating a new Seller object.
             *
             * The first null refers to the Seller id.
             * We pass null because the database will generate the id automatically
             * using AUTO_INCREMENT after the insert operation.
             *
             * The last null refers to the Department name.
             * At this moment, we only need the Department id because it is used
             * as a foreign key to establish the relationship with the Seller.
             * The complete Department object is not required here.
             */
            Seller seller = new Seller(
                    null,
                    name,
                    email,
                    LocalDate.parse(birthDate, formatter),
                    baseSalary,
                    new Department(departmentId, null)
            );

            sellerService.save(seller);

            ConsoleUtils.success(
                    "Seller inserted successfully! New id: " + seller.getId()
            );
        }
    }

    /*
     * Option 5: Fetches a Seller by ID and allows selective field updates
     * through a dynamic submenu before persisting changes.
     */
    private void updateSeller() {
        ConsoleUtils.title("Update seller");

        int id = Leitor.lerNumeroInteiro(sc, "Enter ID of the seller to update: ");
        Seller seller = sellerService.findById(id);

        if (seller == null) {
            System.out.println("\nNo seller found with ID: " + id);
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean editing = true;

        while (editing) {
            ConsoleUtils.title("Current Seller Details");
            System.out.println(seller);

            System.out.println("\nSelect field to update:");
            System.out.println("1 - Name");
            System.out.println("2 - Email");
            System.out.println("3 - Birth Date");
            System.out.println("4 - Base Salary");
            System.out.println("5 - Department");
            System.out.println("6 - Save changes and Exit");
            System.out.println("0 - Cancel without saving");

            int choice = Leitor.lerNumeroInteiro(sc, "\nChoose an option: ");

            switch (choice) {
                case 1:
                    String name = Leitor.lerTexto(sc, "New Name: ");
                    seller.setName(name);
                    break;

                case 2:
                    String email = Leitor.lerTexto(sc, "New Email: ");
                    seller.setEmail(email);
                    break;

                case 3:
                    String birthDate = Leitor.lerTexto(sc, "New BirthDate (DD/MM/YYYY): ");
                    seller.setBirthDate(LocalDate.parse(birthDate, formatter));
                    break;

                case 4:
                    double baseSalary = Leitor.lerNumeroDouble(sc, "New BaseSalary: ");
                    seller.setBaseSalary(baseSalary);
                    break;

                case 5:
                    int departmentId = Leitor.lerNumeroInteiro(sc, "New DepartmentId: ");
                    seller.setDepartment(new Department(departmentId, null));
                    break;

                case 6:
                    // Persists all modified fields via SellerService
                    sellerService.update(seller);
                    ConsoleUtils.success("Seller updated successfully!");
                    editing = false;
                    break;

                case 0:
                    System.out.println("\nUpdate operation canceled.");
                    editing = false;
                    break;

                default:
                    System.out.println("\nInvalid option!");
            }
        }
    }

    /*
     * Option 6: Deletes a Seller from the database by ID with error handling.
     */
    private void deleteSeller() {
        ConsoleUtils.title("Delete seller");

        int id = Leitor.lerNumeroInteiro(sc, "Enter ID of the seller to delete: ");

        Seller seller = sellerService.findById(id);

        if (seller == null) {
            System.out.println("\nNo seller found with ID: " + id);
            return;
        }

        try {
            sellerService.deleteById(id);
            ConsoleUtils.success("Seller deleted successfully!");
        } catch (DbException e) {
            System.out.println("\nError deleting seller: " + e.getMessage());
        }
    }
}