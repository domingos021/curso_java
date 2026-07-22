package progracaofuncional_lambda.apps;

/*
 * ============================================================
 * COMPARATOR
 * ============================================================
 *
 * Comparator é uma interface funcional da linguagem Java
 * utilizada para definir um critério de comparação entre
 * dois objetos.
 *
 * Diferentemente da interface Comparable, onde a própria
 * classe define sua ordem natural, o Comparator permite
 * criar quantas regras de ordenação forem necessárias,
 * sem modificar a classe original.
 *
 * Em outras palavras:
 *
 * Comparable
 *     → A classe sabe como deve ser ordenada.
 *
 * Comparator
 *     → Uma classe externa decide como ordenar.
 *
 * Isso torna o código muito mais flexível, pois o mesmo
 * objeto pode ser ordenado de várias maneiras diferentes.
 */

import progracaofuncional_lambda.DefaultComparator;
import progracaofuncional_lambda.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//implementa interface comparable com o product
public class Comparator {
    public static void main(String[] args) {
        List<Product> lista = new ArrayList<>();


        lista.add(new Product("Mouse Gamer Logitech", 250.00));
        lista.add(new Product("Notebook Dell Inspiron", 4500.00));
        lista.add(new Product("Teclado Mecânico Redragon", 380.00));
        lista.add(new Product("Monitor LG 27\"", 1350.00));
        lista.add(new Product("Smart TV Samsung 55\"", 3200.00));
        lista.add(new Product("SSD Kingston 1TB", 520.00));

        lista.sort(new DefaultComparator());

        for (Product p : lista) {
            System.out.println(p);
        }

    }



}
