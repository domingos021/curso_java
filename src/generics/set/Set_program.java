package generics.set;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class Set_program {
    /*
    * set<T> e um generic e é uma interface
     * Set é uma interface da Java Collections Framework que
     * representa um conjunto de elementos únicos.
     *
     * Principais características:
     * - Não permite elementos duplicados.
     * - Não possui acesso por índice (não existe get(index)).
     * - É otimizado para inserção, remoção e busca de elementos.
     *
     * As principais implementações são:
     * - HashSet: mais rápido, mas não mantém a ordem dos elementos.
     * - LinkedHashSet: mantém a ordem em que os elementos foram inseridos.
     * - TreeSet: mantém os elementos ordenados.
     *
     * No HashSet, a identificação de elementos duplicados é feita
     * por meio dos métodos hashCode() e equals().
     */

    public static void main(String[] args) {
        // Define a localidade padrão como Estados Unidos.
        Locale.setDefault(Locale.US);

        /*
         * Cria um TreeSet para armazenar elementos únicos do tipo String.
         *
         * Características do TreeSet:
         * - Não permite elementos duplicados.
         * - Mantém os elementos sempre ordenados.
         * - A ordenação segue a ordem natural dos elementos
         *   (ou um Comparator, quando informado).
         * - É mais lento que o HashSet, pois precisa manter
         *   a estrutura ordenada.
         *
         * É a implementação mais indicada quando a ordem
         * dos elementos é importante.
         */
        Set<String> set = new TreeSet<>();

        // Adiciona elementos ao conjunto.
        // Se um elemento já existir, ele não será adicionado novamente.
        set.add("Tv");
        set.add("Tablet");
        set.add("Notebook");
        set.add("Smartphone");
        set.add("Tablet01");
        set.remove("Tablet01");

        // Verifica se o elemento "Tv" está presente no conjunto.
        // Retorna true se existir e false caso contrário.
        System.out.println(set.contains("Tv"));

        /*
         * Percorre todos os elementos do conjunto.
         *
         * Como estamos utilizando um TreeSet, os elementos
         * serão exibidos em ordem alfabética.
         *
         * Exemplo de saída:
         *  Notebook   → N
         * Smartphone → S
         * Tablet     → T
         * Tv         → T
         * *Comparando
         * *N < S < T
         */
        for (String s : set) {
            System.out.println(s);
        }
    }
}
