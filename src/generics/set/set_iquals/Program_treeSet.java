package generics.set.set_iquals;

import generics.set.set_iquals.entities.Product_set_treeSet;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class Program_treeSet {

    public static void main(String[] args) {

        // Define a localidade padrão como Estados Unidos.
        Locale.setDefault(Locale.US);

        /*
         * Cria um TreeSet que armazenará objetos Product_set_treeSet.
         *
         * Diferente do HashSet:
         * - O TreeSet mantém os elementos ordenados.
         * - Utiliza compareTo() ou Comparator para comparar objetos.
         * - Não utiliza hashCode() e equals() para controlar duplicidade.
         */
        Set<Product_set_treeSet> set = new TreeSet<>();

        // Adiciona produtos ao conjunto.
        set.add(new Product_set_treeSet("tv", 1200.00));
        set.add(new Product_set_treeSet("tablet", 1500.00));
        set.add(new Product_set_treeSet("notebook", 1550.00));

        /*
         * Cria um novo objeto para testar se já existe
         * um produto equivalente dentro do TreeSet.
         *
         * O TreeSet irá utilizar o compareTo().
         *
         * Como existe um produto com o nome "notebook",
         * o compareTo() retornará 0 e o objeto será
         * considerado existente no conjunto.
         */
        Product_set_treeSet prod =
                new Product_set_treeSet("notebook", 1550.00);

        // Verifica se o produto existe dentro do conjunto.
        System.out.println(set.contains(prod));

        /*
         * Percorre os elementos do conjunto.
         *
         * Como é um TreeSet, os produtos serão exibidos
         * na ordem definida pelo compareTo().
         */


        System.out.println("Lista de produtos:");

        for (Product_set_treeSet p : set) {
            System.out.println(p);
        }
    }
}