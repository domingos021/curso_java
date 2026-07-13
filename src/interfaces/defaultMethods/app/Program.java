package interfaces.defaultMethods.app;

import generals_utils.utils.Leitor;
import interfaces.defaultMethods.model.services.BrazilInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            // Reading financial amount as double and duration as integer
            double amount = Leitor.lerNumeroDouble(sc, "Amount: ");
            int months = Leitor.lerNumeroInteiro(sc, "Months: ");

            /*
             * BrazilInterestService implements the InterestService interface.
             * Instead of implementing the 'payment' method logic inside the class,
             * it automatically inherits the default implementation provided by the interface.
             */
            BrazilInterestService is = new BrazilInterestService(2.0);
            double payment = is.payment(amount, months);

            System.out.printf("Payment after %d months: %.2f%n", months, payment);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}