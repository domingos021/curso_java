package progracaofuncional_lambda.apps;

/*
 * ============================================================
 * EXPRESSÕES LAMBDA
 * ============================================================
 *
 * Expressões Lambda foram introduzidas no Java 8 para
 * simplificar a implementação de Interfaces Funcionais.
 *
 * Uma Interface Funcional é uma interface que possui
 * apenas um único método abstrato.
 *
 * Exemplo:
 *
 * Comparator
 *      │
 *      ▼
 * compare(T o1, T o2)
 *
 * Como existe apenas um método abstrato, o compilador
 * consegue identificar automaticamente qual método
 * será implementado pela Expressão Lambda.
 *
 * Antes do Java 8, para implementar um Comparator,
 * normalmente utilizávamos:
 *
 * ✔ uma classe separada;
 *
 * ou
 *
 * ✔ uma Classe Anônima.
 *
 * A partir do Java 8 podemos substituir toda essa
 * estrutura por uma Expressão Lambda, reduzindo
 * significativamente a quantidade de código.
 *
 * ============================================================
 * EVOLUÇÃO
 * ============================================================
 *
 * 1) Classe Separada
 *
 * DefaultComparator
 *          │
 *          ▼
 * compare()
 *
 *
 * 2) Classe Anônima
 *
 * new Comparator<Product>() {
 *
 *      @Override
 *      public int compare(...) {
 *          ...
 *      }
 * }
 *
 *          │
 *          ▼
 * compare()
 *
 *
 * 3) Expressão Lambda
 *
 * (p1, p2) -> ...
 *
 *          │
 *          ▼
 * compare()
 *
 * Em todos os casos o comportamento é exatamente
 * o mesmo.
 *
 * Apenas a forma de escrever o código muda.
 */

import progracaofuncional_lambda.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * ============================================================
 * CLASSE CompExpressoesLambda
 * ============================================================
 *
 * Demonstra como implementar um Comparator através
 * de uma Expressão Lambda.
 *
 * Observe que não precisamos criar uma classe
 * separada nem uma Classe Anônima.
 *
 * O próprio compilador cria automaticamente um objeto
 * que implementa Comparator<Product>.
 */
public class CompExpressoesLambda {

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
         * Cada chamada ao método add()
         * cria um novo objeto Product
         * e o adiciona ao final da lista.
         */
        lista.add(new Product("Mouse Gamer Logitech", 250.00));
        lista.add(new Product("Notebook Dell Inspiron", 4500.00));
        lista.add(new Product("Teclado Mecânico Redragon", 380.00));
        lista.add(new Product("Monitor LG 27\"", 1350.00));
        lista.add(new Product("Smart TV Samsung 55\"", 3200.00));
        lista.add(new Product("SSD Kingston 1TB", 520.00));


        /*
         * ============================================================
         * EXPRESSÃO LAMBDA
         * ============================================================
         *
         * Uma Expressão Lambda é uma forma reduzida
         * de implementar uma Interface Funcional.
         *
         * Como Comparator possui apenas um único
         * método abstrato (compare), o compilador
         * sabe automaticamente que esta expressão
         * corresponde à implementação desse método.
         *
         * Sintaxe:
         *
         * (parâmetros) -> expressão
         *
         * ou
         *
         * (parâmetros) -> {
         *      bloco de código
         * }
         *
         * O operador ->
         *
         * separa duas partes da Lambda.
         *
         * À esquerda:
         *
         * os parâmetros recebidos.
         *
         * À direita:
         *
         * o código que será executado.
         *
         * (p1, p2) -> código
         *
         *          ▲
         *          │
         * recebe dois objetos Product
         *
         *                     ▼
         * executa a comparação
         */


        /*
         * ============================================================
         * LAMBDA SIMPLES
         * ============================================================
         *
         * Como existe apenas uma única expressão,
         * não precisamos utilizar chaves ({})
         * nem escrever a palavra return.
         *
         * O próprio Java entende que o resultado
         * desta expressão será automaticamente
         * retornado.
         *
         * Esta Lambda equivale ao método compare()
         * implementado anteriormente utilizando
         * Classe Anônima.
         */
        Comparator<Product> comp01 =
                (p1, p2) ->
                        p1.getName()
                                .toUpperCase()
                                .compareTo(
                                        p2.getName().toUpperCase()
                                );

        /*
         * DICA DE OTIMIZAÇÃO PERFORMANCE/MEMÓRIA:
         * A utilização de compareToIgnoreCase evita instanciar novas
         * instâncias de String na memória RAM (Garbage Collector agradece):
         *
         * Comparator<Product> comp01Otimizado =
         *         (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName());
         */


        /*
         * ============================================================
         * LAMBDA COM BLOCO DE CÓDIGO
         * ============================================================
         *
         * Quando desejamos executar mais de uma
         * instrução, utilizamos um bloco delimitado
         * por chaves { }.
         *
         * Diferentemente da Lambda simples,
         * aqui o return torna-se obrigatório.
         *
         * Isso permite:
         *
         * • criar variáveis locais;
         * • executar cálculos;
         * • utilizar estruturas condicionais;
         * • chamar outros métodos;
         * • executar qualquer lógica antes
         *   de retornar o resultado.
         *
         * Apesar da sintaxe ser diferente,
         * o comportamento continua sendo
         * exatamente o mesmo.
         */
        // por causa disso (->) pode ser chamada de arrow function
        Comparator<Product> comp02 =
                (p1, p2) -> {

                    return p1.getName()
                            .toUpperCase()
                            .compareTo(
                                    p2.getName().toUpperCase()
                            );
                };


        /*
         * ============================================================
         * O QUE A VARIÁVEL comp01 ARMAZENA?
         * ============================================================
         *
         * A variável comp01 NÃO armazena um método.
         *
         * Ela armazena um objeto que implementa
         * Comparator<Product>.
         *
         * Esse objeto foi criado automaticamente
         * pelo compilador a partir da Expressão
         * Lambda.
         *
         * Posteriormente esse objeto será enviado
         * para o método sort().
         */


        /*
         * ============================================================
         * ORDENAÇÃO DA LISTA
         * ============================================================
         *
         * O método sort() pertence à interface List.
         *
         * Sua função é reorganizar os elementos
         * armazenados na lista.
         *
         * Entretanto, o método sort() não sabe
         * como comparar objetos Product.
         *
         * Por isso ele recebe um Comparator.
         *
         * Neste exemplo estamos enviando
         * a variável comp01.
         *
         * Durante a ordenação o método sort()
         * executará a Expressão Lambda diversas
         * vezes.
         *
         * A quantidade de chamadas depende do
         * algoritmo interno de ordenação do Java
         * e da quantidade de elementos existentes
         * na lista.
         *
         * Fluxo completo:
         *
         * lista.sort(comp01)
         *          │
         *          ▼
         * sort()
         *          │
         *          ▼
         * Comparator
         *          │
         *          ▼
         * Expressão Lambda
         *          │
         *          ▼
         * compare(p1, p2)
         *          │
         *          ▼
         * retorna:
         *
         * < 0
         *      p1 vem antes
         *
         * = 0
         *      possuem a mesma ordem
         *
         * > 0
         *      p2 vem antes
         *
         *          │
         *          ▼
         * sort() reorganiza toda a lista
         *          │
         *          ▼
         * Lista ordenada
         */
        //lista.sort(comp01);

        // Opção alternativa enviando a variável da lambda com bloco:
        // lista.sort(comp02);

        /*
        4) Lambda diretamente no método
        Sem criar variável:
         */
        lista.sort((p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        // Opção 4 Otimizada (sem alocação de memória para novas Strings):
        // lista.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        /*
        5) Usando método estático Comparator.comparing()
        Forma mais moderna:
         */
        lista.sort(
                Comparator.comparing(Product::getName)
        );

        //também pode
        lista.sort(comp01);

        /*
        5.1) Usando Comparator.comparing com suporte a Case Insensitive (ordem alfabética ignorando maiúsculas/minúsculas):
        lista.sort(
                Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER)
        );
        */

        /*
        6) [NOVA OPÇÃO DE SORT] ORDENAÇÃO DECRESCENTE (Z-A)
        Usando encadeamento funcional com o método .reversed():
        lista.sort(
                Comparator.comparing(Product::getName).reversed()
        );
        */

        /*
        7) [NOVA OPÇÃO DE SORT] ORDENAÇÃO POR TIPO PRIMITIVO / NUMÉRICO
        Ordenando por preço do produto (Double):
        lista.sort(
                Comparator.comparingDouble(Product::getPrice)
        );
        */


        /*
         * ============================================================
         * EXIBIÇÃO DA LISTA
         * ============================================================
         *
         * Neste momento todos os produtos já
         * estão ordenados.
         *
         * O for-each percorre toda a lista,
         * exibindo cada objeto Product.
         *
         * Para cada objeto encontrado,
         * o Java chama automaticamente
         * o método toString().
         */
        System.out.println("========== LISTA ORDENADA ==========\n");

        for (Product p : lista) {
            System.out.println(p);
        }
    }
}

/*
 * ============================================================
 * SINTAXE DE UMA EXPRESSÃO LAMBDA
 * ============================================================
 *
 * Uma Expressão Lambda pode ser entendida como uma
 * função anônima, ou seja, uma função que não possui
 * um nome.
 *
 * Ela é utilizada para implementar o único método
 * abstrato de uma Interface Funcional.
 *
 * Sintaxe geral:
 *
 * InterfaceFuncional<T> variavel = (parâmetros) -> {
 *      código
 * };
 *
 * Exemplo com Comparator:
 *
 * Comparator<Product> comp = (p1, p2) -> {
 *      // código de comparação
 *      return ...;
 * };
 *
 * Onde:
 *
 * Comparator<Product>
 *      Tipo da variável. Indica que ela armazenará
 *      um objeto que implementa Comparator<Product>.
 *
 * comp
 *      Nome da variável que armazenará o objeto
 *      criado pela Expressão Lambda.
 *
 * (p1, p2)
 *      Parâmetros recebidos pelo método compare().
 *
 * ->
 *      Operador Lambda. Separa os parâmetros do
 *      código que será executado.
 *
 * { ... }
 *      Corpo da função (bloco de código).
 *      Quando utilizamos chaves, o return é
 *      obrigatório para devolver um valor.
 */

    /*
    1 - Classe separada

    class ProductComparator implements Comparator<Product>


            ↓


    2 - Classe anônima

    new Comparator<Product>() {

        public int compare(...)

    }


            ↓


    3 - Lambda

    (p1,p2) -> ...


            ↓


    4 - Method Reference

    Comparator.comparing(Product::getName)
     */