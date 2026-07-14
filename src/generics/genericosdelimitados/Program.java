package generics.genericosdelimitados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import generics.genericosdelimitados.model.entities.Product;
import generics.genericosdelimitados.model.services.CalculationService;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        String path = "C:\\temp01\\products.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");// recorta a linha nas virgulas, transformando a cada parte em uma posição no vetor
                list.add(new Product(
                        fields[0],
                        Double.parseDouble(fields[1]),
                        Integer.parseInt(fields[2])
                ));
                line = br.readLine();
            }

            System.out.println("----------------- Lista de Produtos----------");
            for (Product product : list) {
                System.out.println(product);
            }

            System.out.println();
            System.out.println("--------------------------------------");
            Product x = CalculationService.max(list);
            System.out.println("Most expensive:");
            System.out.println(x);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
