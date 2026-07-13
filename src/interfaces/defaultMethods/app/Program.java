package interfaces.defaultMethods.app;

import generals_utils.utils.Leitor;
import interfaces.defaultMethods.model.services.BrazilInterestService;
import interfaces.defaultMethods.model.services.UsaInterestService;

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
             * *
             * *Here we have two InterestService
             */
            BrazilInterestService is = new BrazilInterestService(1.00); //From Brazil
            UsaInterestService usais = new UsaInterestService(2.00); // From Usa
            double payment = is.payment(amount, months);
            double usa_payment = usais.payment(payment, months);

            System.out.printf("(br)->Payment after %d months: %.2f%n", months, payment);
            System.out.printf("(usa)->Payment after %d months: %.2f%n", months, usa_payment);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}