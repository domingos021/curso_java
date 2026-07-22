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
 * classe define sua ordem natural através do método compareTo(),
 * o Comparator permite criar quantas regras de ordenação
 * forem necessárias, sem modificar a classe original.
 *
 * Em outras palavras:
 *
 * Comparable
 * -------------------------
 * A própria classe define sua ordem natural.
 *
 * Exemplo:
 *
 * Product
 *     │
 *     ▼
 * compareTo()
 *
 * Comparator
 * -------------------------
 * Uma classe externa define a forma de ordenação.
 *
 * Product
 *     │
 *     ▼
 * DefaultComparator
 *     │
 *     ▼
 * compare()
 *
 * Isso torna o código muito mais flexível, pois
 * o mesmo objeto pode ser ordenado de diversas formas,
 * como por nome, preço, quantidade, categoria etc.
 */

import progracaofuncional_lambda.DefaultComparator;
import progracaofuncional_lambda.entities.Product;

import java.util.ArrayList;
import java.util.List;

/*
 * ============================================================
 * CLASSE COMPARATOR
 * ============================================================
 *
 * Demonstra a utilização da interface Comparator para
 * ordenar uma lista de objetos Product.
 *
 * Neste exemplo, o critério de ordenação está definido
 * na classe DefaultComparator.
 */
public class Comparator {

    public static void main(String[] args) {

        /*
         * Cria uma lista que armazenará objetos Product.
         */
        List<Product> lista = new ArrayList<>();


        /*
         * Adicionando alguns produtos na lista.
         */
        lista.add(new Product("Mouse Gamer Logitech", 250.00));
        lista.add(new Product("Notebook Dell Inspiron", 4500.00));
        lista.add(new Product("Teclado Mecânico Redragon", 380.00));
        lista.add(new Product("Monitor LG 27\"", 1350.00));
        lista.add(new Product("Smart TV Samsung 55\"", 3200.00));
        lista.add(new Product("SSD Kingston 1TB", 520.00));


        /*
         * ============================================================
         * ORDENAÇÃO DA LISTA
         * ============================================================
         *
         * O método sort() pertence à interface List.
         *
         * Sua função é reorganizar os elementos da lista.
         *
         * Entretanto, o método sort() não sabe como comparar
         * objetos Product.
         *
         * Por isso, passamos um objeto da classe
         * DefaultComparator.
         *
         * Essa classe implementa a interface
         * Comparator<Product> e possui o método compare(),
         * responsável por informar qual objeto deve vir
         * antes do outro.
         *
         * Fluxo:
         *
         * lista.sort(new DefaultComparator())
         *              │
         *              ▼
         * DefaultComparator.compare(p1, p2)
         *              │
         *              ▼
         * compare() retorna:
         *
         * < 0  → p1 vem antes de p2
         * = 0  → ambos são equivalentes
         * > 0  → p2 vem antes de p1
         *
         * Com base nesse retorno, o método sort()
         * reorganiza automaticamente toda a lista.
         */
        lista.sort(new DefaultComparator());


        /*
         * Percorre toda a lista já ordenada
         * imprimindo seus elementos.
         *
         * O método toString() da classe Product
         * é chamado automaticamente para cada objeto.
         */
        for (Product p : lista) {
            System.out.println(p);
        }
    }
}