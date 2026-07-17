package generics.set;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

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
         * Cria um LinkedHashSet para armazenar elementos únicos do tipo String.
         *
         * Características do LinkedHashSet:
         * - Não permite elementos duplicados.
         * - Mantém a ordem em que os elementos foram inseridos.
         * - É um pouco mais lento que o HashSet, pois precisa
         *   manter a ordem de inserção.
         *
         * É a implementação mais indicada quando precisamos
         * preservar a ordem de inserção dos elementos.
         */
        Set<String> set = new LinkedHashSet<>();

        // Adiciona elementos ao conjunto.
        // Se um elemento já existir, ele não será adicionado novamente.
        set.add("Tv");
        set.add("Tablet");
        set.add("Notebook");
        set.add("Smartphone");

      // Remove um elemento específico do conjunto.
        set.remove("Tablet");

       // Adiciona um novo elemento.
        set.add("Carro");

        // Remove todos os elementos com mais de 5 caracteres.
        set.removeIf(x -> x.length() > 5);

       // Remove todos os elementos cuja segunda letra seja 'v'.
        set.removeIf(x -> x.length() > 1 && x.charAt(1) == 'v');

     // Verifica se o elemento "Tv" está presente no conjunto.
        System.out.println("Existe TV no conjunto? " + set.contains("Tv"));

     // Verifica se o conjunto está vazio.
        System.out.println(set.isEmpty());

     // Retorna a quantidade de elementos armazenados.
        System.out.println(set.size());

     // Exibe todos os elementos do conjunto.
        System.out.println(set);

     // Remove todos os elementos do conjunto.
        set.clear();

     // Verifica novamente se o conjunto está vazio.
        System.out.println(" existe elemento no conjunto? " + set.isEmpty()); //true/false

        /*
         * Percorre todos os elementos do conjunto.
         *
         * Como estamos utilizando um LinkedHashSet,
         * os elementos serão exibidos na mesma ordem
         * em que foram inseridos.
         *
         * Exemplo de saída:
         * true
         * Tv
         * Tablet
         * Notebook
         * Smartphone
         */
        for (String s : set) {
            System.out.println(s);
        }
    }
}
