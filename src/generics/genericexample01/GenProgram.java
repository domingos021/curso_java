package generics.genericexample01;

import generals_utils.utils.Leitor;
import generics.genericexample01.services.PrintService;

import java.util.Locale;
import java.util.Scanner;

public class GenProgram {

    public static void main(String[] args) {
        PrintService ps = new PrintService();

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            int n = Leitor.lerNumeroInteiro(sc, "Quantos números: ");

            for (int i = 0; i < n; i++) {
                System.out.printf("%dª ", i + 1);

                int value = Leitor.lerNumeroInteiro(sc, "Valor: ");
                ps.addValue(value);
            }

            ps.print();
            System.out.println("Primeiro: " + ps.first());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}