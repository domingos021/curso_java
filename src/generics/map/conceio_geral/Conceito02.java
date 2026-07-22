package generics.map.conceio_geral;

import generics.map.entities.Product;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Conceito02 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        /*
         * O Map representa um estoque de produtos.
         *
         * Chave (Key)  -> Product
         * Valor (Value)-> Quantidade ou valor associado ao produto.
         */
        Map<Product, Double> stock = new HashMap<>();

        Product p1 = new Product("Tv", 900.00);
        Product p2 = new Product("Notebook", 800.00);
        Product p3 = new Product("Tablet", 500.00);

        // Adicionando produtos ao estoque.
        stock.put(p1, 10000.00);
        stock.put(p2, 20000.00);
        stock.put(p3, 15000.00);

        /*
         * Criando outro objeto Product.
         *
         * Se equals() e hashCode() estiverem implementados
         * corretamente, containsKey() verificará se existe
         * um produto equivalente dentro do Map.
         */
        Product p4 = new Product("Tv", 900.00);

        System.out.println("Contains product? " + stock.containsKey(p4));
    }
}