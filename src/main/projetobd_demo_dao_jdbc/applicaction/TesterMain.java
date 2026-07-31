package main.projetobd_demo_dao_jdbc.applicaction;

import generals_utils.utils.Leitor;
import main.projetobd_demo_dao_jdbc.model.dao.DaoFactory;
import main.projetobd_demo_dao_jdbc.model.dao.SellerDao;
import main.projetobd_demo_dao_jdbc.model.entities.Seller;

import java.util.Locale;
import java.util.Scanner;

public class TesterMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {

            int id = Leitor.lerNumeroInteiro(sc, "Numero de id de Consulta: ");

            /*
             * The factory creates and returns a SellerDao instance.
             */
            SellerDao sellerDao = DaoFactory.createSellerDao();
            Seller sl = sellerDao.findById(id);

            if (sl != null) {
                System.out.println(sl);
            } else {
                System.out.println("Nenhum vendedor encontrado com o ID: " + id);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}