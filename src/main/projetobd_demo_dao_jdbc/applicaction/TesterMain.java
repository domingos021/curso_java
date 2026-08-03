package main.projetobd_demo_dao_jdbc.applicaction;

import java.util.Locale;
import java.util.Scanner;

import main.projetobd_demo_dao_jdbc.applicaction.controllers.SellerService;
import main.projetobd_demo_dao_jdbc.applicaction.ui.SellerMenu;
import main.projetobd_demo_dao_jdbc.model.dao.DaoFactory;
import main.projetobd_demo_dao_jdbc.model.dao.SellerDao;


public class TesterMain {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            /*
             * DaoFactory creates the DAO implementation.
             * The application only depends on the SellerDao interface.
             */
            SellerDao sellerDao = DaoFactory.createSellerDao();

            /*
             * SellerService encapsulates business rules and acts as an intermediate
             * layer between the application UI and the DAO persistence layer.
             */
            SellerService sellerService = new SellerService(sellerDao);

            /*
             * Instantiates the SellerMenu encapsulating Scanner and SellerService,
             * then runs the main interface loop.
             * The constructor of SellerMenu now requires the Scanner and SellerService objects.
             */
            SellerMenu menu = new SellerMenu(sc, sellerService);
            menu.runMenu(); // Accesses the runMenu method of the SellerMenu class to start the menu loop.

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}