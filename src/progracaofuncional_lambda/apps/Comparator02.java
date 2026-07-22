package progracaofuncional_lambda.apps;

/*
 * ============================================================
 * COMPARATOR
 * ============================================================
 *
 * Comparator é uma interface funcional da linguagem Java
 * utilizada para definir critérios personalizados de
 * comparação entre dois objetos.
 *
 * Diferentemente da interface Comparable, onde a própria
 * classe define sua ordem natural através do método
 * compareTo(), o Comparator permite criar diversas
 * regras de ordenação sem alterar a classe original.
 *
 * Em outras palavras:
 *
 * Comparable
 * -------------------------
 * A própria classe sabe como deve ser ordenada.
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
 * Uma classe externa define como os objetos
 * deverão ser comparados.
 *
 * Product
 *     │
 *     ▼
 * Comparator
 *     │
 *     ▼
 * compare()
 *
 * Isso torna o código muito mais flexível,
 * permitindo ordenar um mesmo objeto por:
 *
 * • nome;
 * • preço;
 * • quantidade;
 * • categoria;
 * • qualquer outro critério.
 */

import progracaofuncional_lambda.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * ============================================================
 * CLASSE Comparator02
 * ============================================================
 *
 * Demonstra como criar um Comparator utilizando
 * uma Classe Anônima (Anonymous Class).
 *
 * Diferentemente do exemplo anterior, onde foi criada
 * uma classe separada (DefaultComparator), aqui a
 * implementação do Comparator é criada diretamente
 * dentro do método main().
 *
 * Esse recurso é bastante utilizado quando o Comparator
 * será utilizado apenas uma única vez.
 */
public class Comparator02 {

    public static void main(String[] args) {

        /*
         * ============================================================
         * CRIAÇÃO DA LISTA
         * ============================================================
         *
         * Cria uma lista capaz de armazenar objetos Product.
         */
        List<Product> lista = new ArrayList<>();


        /*
         * ============================================================
         * ADICIONANDO PRODUTOS
         * ============================================================
         *
         * Cada chamada ao método add() cria um novo objeto
         * Product e o adiciona ao final da lista.
         */
        lista.add(new Product("Mouse Gamer Logitech", 250.00));
        lista.add(new Product("Notebook Dell Inspiron", 4500.00));
        lista.add(new Product("Teclado Mecânico Redragon", 380.00));
        lista.add(new Product("Monitor LG 27\"", 1350.00));
        lista.add(new Product("Smart TV Samsung 55\"", 3200.00));
        lista.add(new Product("SSD Kingston 1TB", 520.00));


        /*
         * ============================================================
         * CLASSE ANÔNIMA (Anonymous Class)
         * ============================================================
         *
         * No exemplo anterior utilizamos uma classe chamada
         * DefaultComparator para implementar a interface
         * Comparator.
         *
         * Entretanto, quando essa implementação será utilizada
         * apenas em um único ponto do programa, criar uma
         * classe separada pode deixar o projeto maior do que
         * o necessário.
         *
         * O Java permite criar um objeto que implementa
         * diretamente a interface Comparator sem declarar
         * uma classe com nome.
         *
         * Esse recurso é chamado de Classe Anônima
         * (Anonymous Class).
         *
         * Uma classe anônima:
         *
         * ✔ implementa uma interface ou estende uma classe;
         * ✔ não possui um nome declarado pelo programador;
         * ✔ normalmente é utilizada apenas naquele ponto
         *   do código;
         * ✔ evita criar arquivos desnecessários.
         *
         * Neste exemplo estamos criando um objeto que
         * implementa Comparator<Product>.
         *
         * Fluxo:
         *
         * Comparator<Product> comp
         *             │
         *             ▼
         * new Comparator<Product>() { ... }
         *             │
         *             ▼
         * Implementação do método compare()
         *             │
         *             ▼
         * Objeto Comparator criado
         */
        Comparator<Product> comp = new Comparator<Product>() {

            /*
             * ============================================================
             * compare()
             * ============================================================
             *
             * Método responsável por comparar dois objetos
             * Product.
             *
             * Sempre que o método sort() precisar decidir
             * qual elemento deve aparecer primeiro, ele
             * chamará automaticamente este método.
             *
             * Neste exemplo a comparação é realizada pelo
             * nome do produto.
             *
             * O compareTo() retorna:
             *
             * valor negativo (< 0)
             *      O primeiro produto vem antes.
             *
             * zero (0)
             *      Os dois produtos possuem a mesma ordem.
             *
             * valor positivo (> 0)
             *      O segundo produto vem antes.
             *
             * Os nomes são convertidos para letras
             * maiúsculas para ignorar diferenças entre
             * maiúsculas e minúsculas durante a comparação.
             */
            @Override
            public int compare(Product p1, Product p2) {

                return p1.getName()
                        .toUpperCase()
                        .compareTo(
                                p2.getName().toUpperCase()
                        );
            }
        };


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
         * Por isso, recebe como argumento um objeto que
         * implementa Comparator<Product>.
         *
         * Neste caso, estamos passando o objeto "comp",
         * criado através de uma classe anônima.
         *
         * Sempre que o sort() precisar comparar dois
         * produtos, ele chamará automaticamente o método
         * compare() implementado acima.
         *
         * Fluxo completo:
         *
         * lista.sort(comp)
         *         │
         *         ▼
         * sort() percorre a lista
         *         │
         *         ▼
         * compare(p1, p2)
         *         │
         *         ▼
         * compare() informa qual produto vem primeiro
         *         │
         *         ▼
         * sort() reorganiza toda a lista
         */
        lista.sort(comp);


        /*
         * ============================================================
         * EXIBIÇÃO DA LISTA
         * ============================================================
         *
         * Neste momento a lista já foi ordenada.
         *
         * O for-each percorre todos os elementos da lista,
         * exibindo-os um a um.
         *
         * Para cada objeto Product, o Java chama
         * automaticamente o método toString().
         */
        System.out.println("========== LISTA ORDENADA ==========\n");

        for (Product p : lista) {
            System.out.println(p);
        }
    }
}