package generics.set;
import java.util.*;

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
        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        /*
         * União (Union)
         *
         * Cria um novo conjunto 'c' contendo todos os elementos de 'a'.
         * Em seguida, adiciona todos os elementos de 'b' utilizando addAll().
         *
         * Como um Set não permite elementos duplicados,
         * o número 5, que existe nos dois conjuntos,
         * aparecerá apenas uma vez no conjunto resultante.
         */
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);

        System.out.println(c);

        //intersection

        /*
         * Interseção (Intersection)
         *
         * Cria um novo conjunto 'd' contendo todos os elementos de 'a'.
         * Em seguida, mantém apenas os elementos que também
         * existem no conjunto 'b' utilizando retainAll().
         *
         * O resultado será composto apenas pelos elementos
         * comuns aos dois conjuntos.
         */
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);

        System.out.println(d);

        /*
         * Diferença (Difference)
         *
         * Cria um novo conjunto 'e' contendo todos os elementos de 'a'.
         * Em seguida, remove todos os elementos que também
         * existem no conjunto 'b' utilizando removeAll().
         *
         * O resultado será composto apenas pelos elementos
         * exclusivos do conjunto 'a'.
         */
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);

        System.out.println(e);

    }
}
