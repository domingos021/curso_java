package main.projetobd_demo_dao_jdbc.applicaction;

import java.util.List;
import generals_utils.ConsoleUtils;
import generals_utils.utils.Leitor;
import main.projetobd_demo_dao_jdbc.model.dao.DaoFactory;
import main.projetobd_demo_dao_jdbc.model.dao.SellerDao;
import main.projetobd_demo_dao_jdbc.model.entities.Department;
import main.projetobd_demo_dao_jdbc.model.entities.Seller;

import java.util.Locale;
import java.util.Scanner;

public class TesterMain {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            /*
             * Here we use DaoFactory as an intermediary.
             * It is responsible for creating DAO implementations,
             * such as SellerDao and DepartmentDao, so we don't
             * need to know the implementation details.
             *
             * Here we simply ask the factory to create a SellerDao,
             * but we could also ask it to create a DepartmentDao.
             */
            SellerDao sellerDao = DaoFactory.createSellerDao();

            boolean running = true;

            while (running) {

                ConsoleUtils.showSellerMenu();

                int option = Leitor.lerNumeroInteiro(sc, "Choose an option: ");

                switch (option) {

                    case 1:

                        ConsoleUtils.title("Find seller by ID");

                        int id = Leitor.lerNumeroInteiro(sc, "Seller ID: ");

                        Seller seller = sellerDao.findById(id);

                        if (seller != null) {
                            System.out.println("\nSeller found:");
                            System.out.println(seller);
                        } else {
                            System.out.println("\nNo seller found with ID: " + id);
                        }

                        break;

                    case 2:

                        ConsoleUtils.title("Find sellers by Department");

                        int departmentId = Leitor.lerNumeroInteiro(sc, "Department ID: ");

                        Department department = new Department(departmentId, null);

                        List<Seller> list = sellerDao.findByDepartment(department);

                        if (list.isEmpty()) {
                            System.out.println("\nNo sellers found for this department.");
                        } else {
                            System.out.println("\nSellers found:");
                            list.forEach(System.out::println);
                        }

                        break;

                    case 3:
                        ConsoleUtils.title("Find all sellers");
                        System.out.println("TODO");
                        break;

                    case 4:
                        ConsoleUtils.title("Insert seller");
                        System.out.println("TODO");
                        break;

                    case 5:
                        ConsoleUtils.title("Update seller");
                        System.out.println("TODO");
                        break;

                    case 6:
                        ConsoleUtils.title("Delete seller");
                        System.out.println("TODO");
                        break;

                    case 0:

                        System.out.println("\nClosing application...");
                        running = false;
                        break;

                    default:

                        System.out.println("\nInvalid option!");
                }
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}