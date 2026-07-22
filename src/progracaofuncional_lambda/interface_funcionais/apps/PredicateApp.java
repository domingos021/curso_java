package progracaofuncional_lambda.interface_funcionais.apps;

import generals_utils.utils.Leitor;
import progracaofuncional_lambda.entities.Product;
import progracaofuncional_lambda.interface_funcionais.util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateApp {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            /*
             * ============================================================
             * PREDICATE<T>
             * ============================================================
             *
             * Predicate é uma Interface Funcional do pacote
             * java.util.function.
             *
             * Ela representa uma função que:
             *
             * recebe um objeto
             *        |
             *        ▼
             * executa uma condição
             *        |
             *        ▼
             * retorna true ou false
             *
             *
             * Método abstrato:
             *
             * boolean test(T t);
             *
             * ============================================================
             */


            List<Product> lista = new ArrayList<>();


            lista.add(new Product("Tv", 2000.0));
            lista.add(new Product("Mouse", 150.0));
            lista.add(new Product("Teclado", 300.0));
            lista.add(new Product("Notebook", 4500.0));
            lista.add(new Product("Monitor", 1200.0));


            System.out.println("========== LISTA ORIGINAL ==========");

            for (Product p : lista) {
                System.out.println(p);
            }



            /*
             * ============================================================
             * EVOLUÇÃO DA IMPLEMENTAÇÃO DO PREDICATE
             * ============================================================
             *
             * 1) CLASSE SEPARADA
             *
             * Antes do Java 8, poderíamos criar uma classe:
             *
             * ProductPredicate implements Predicate<Product>
             *
             *
             * Essa classe implementa o método:
             *
             * boolean test(Product p)
             *
             *
             * Ela é equivalente à Lambda:
             *
             * p -> p.getPrice() >= 500.0
             *
             *
             * ============================================================
             */


            // Cria um objeto ProductPredicate que implementa Predicate<Product>
            // e envia esse objeto for removeIf()
            lista.removeIf(new ProductPredicate());


            System.out.println("\n========== APÓS PRODUCTPREDICATE ==========");

            for (Product p : lista) {
                System.out.println(p);
            }



            /*
             * ============================================================
             * 2) CLASSE ANÔNIMA
             * ============================================================
             *
             * Outra forma antes do Java 8 era criar uma implementação
             * diretamente dentro do método.
             *
             *
             * O código abaixo é equivalente a:
             *
             * p -> p.getPrice() >= 500.0
             *
             */


            List<Product> lista2 = new ArrayList<>();

            lista2.add(new Product("Celular", 2500.0));
            lista2.add(new Product("Cabo USB", 50.0));
            lista2.add(new Product("Carregador", 120.0));
            lista2.add(new Product("Notebook Gamer", 7000.0));


            System.out.println("\n========== SEGUNDA LISTA ==========");
            System.out.println(lista2);


            lista2.removeIf(
                    new Predicate<Product>() {

                        @Override
                        public boolean test(Product produto) {

                            return produto.getPrice() < 200;
                        }
                    }
            );


            System.out.println("\n========== APÓS CLASSE ANÔNIMA ==========");
            System.out.println(lista2);



            /*
             * ============================================================
             * 3) EXPRESSÃO LAMBDA DIRETAMENTE
             * ============================================================
             *
             * A partir do Java 8 podemos substituir toda a estrutura
             * anterior por uma Expressão Lambda.
             *
             *
             * Não precisamos:
             *
             * - criar uma classe;
             * - criar uma classe anônima;
             * - implementar manualmente o método test().
             *
             *
             * O compilador cria automaticamente um objeto que
             * implementa Predicate<Product>.
             *
             */


            List<Product> lista3 = new ArrayList<>();

            lista3.add(new Product("TV", 2000.0));
            lista3.add(new Product("Mouse", 150.0));
            lista3.add(new Product("Notebook", 4500.0));
            lista3.add(new Product("Teclado", 300.0));


            System.out.println("\n========== TERCEIRA LISTA ==========");
            System.out.println(lista3);


            // Lambda implementando o método test() do Predicate
            lista3.removeIf(
                    p -> p.getPrice() > 1000
            );


            System.out.println("\n========== APÓS LAMBDA ==========");
            System.out.println(lista3);



            /*
             * ============================================================
             * COMPARAÇÃO FINAL
             * ============================================================
             *
             * Todas as formas abaixo fazem a mesma coisa:
             *
             *
             * 1) Classe separada:
             *
             * lista.removeIf(new ProductPredicate());
             *
             *
             * 2) Classe anônima:
             *
             * lista.removeIf(
             *      new Predicate<Product>() {
             *
             *          public boolean test(Product p){
             *              return p.getPrice() >= 500;
             *          }
             *      }
             * );
             *
             *
             * 3) Lambda:
             *
             * lista.removeIf(
             *      p -> p.getPrice() >= 500
             * );
             *
             *
             * A diferença está apenas na quantidade de código.
             *
             * O comportamento é o mesmo porque todas implementam:
             *
             * boolean test(Product p);
             *
             * ============================================================
             */


            List<Product> lista4 = new ArrayList<>();

            lista4.add(new Product("TV", 2000.0));
            lista4.add(new Product("Mouse", 150.0));
            lista4.add(new Product("Notebook", 4500.0));
            lista4.add(new Product("Teclado", 300.0));


            System.out.println("\n========== TERCEIRA LISTA ==========");
            for (Product p : lista4) {
                System.out.println(p);
            }



            /*
             * ============================================================
             * USANDO MÉTODO DA CLASSE PRODUCT
             * ============================================================
             *
             * A Lambda recebe cada Product da lista.
             *
             * Depois chama o método:
             *
             * p.expensiveProduct()
             *
             *
             * Equivale a:
             *
             * Predicate<Product> predicate =
             *
             *      p -> p.expensiveProduct();
             *
             */

            lista4.removeIf(
                    Product::staticProductPredicate
            );


            System.out.println("\n========== APÓS USAR MÉTODO DO PRODUCT ==========");
            for (Product p : lista4) {
                System.out.println(p);
            }


            /*
             * ============================================================
             * USANDO MÉTODO COMUM (DE INSTÂNCIA / NÃO ESTÁTICO) DO PRODUCT
             * ============================================================
             *
             * Aqui utilizamos Method Reference apontando para um método
             * comum (que não possui a palavra-chave 'static').
             *
             * Sintaxe:
             *
             * Product::nonstaticProductPredicate
             *
             * Como funciona internamente?
             *
             * O Java entende que o objeto 'p' da lista será a própria
             * instância que chamará o método:
             *
             * p -> p.nonstaticProductPredicate()
             */

            List<Product> lista5 = new ArrayList<>();

            lista5.add(new Product("TV", 2000.0));
            lista5.add(new Product("Mouse", 150.0));
            lista5.add(new Product("Notebook", 4500.0));
            lista5.add(new Product("Teclado", 300.0));
            lista5.add(new Product("Teclado02", 400.0));

            System.out.println("\n========== QUARTA LISTA (ANTES DO MÉTODO COMUM) ==========");
            for (Product p : lista5) {
                System.out.println(p);
            }

            lista5.add(new Product("Tiled", 1400.0));

            System.out.println("\n========== LISTA COM NOVO ITEM (TILED) ==========");
            for (Product p : lista5) {
                System.out.println(p);
            }

            // Executa o método não estático 'nonstaticProductPredicate' em cada elemento
            lista5.removeIf(
                    Product::nonstaticProductPredicate
            );

            System.out.println("\n========== APÓS USAR MÉTODO COMUM (NÃO ESTÁTICO) ==========");
            for (Product p : lista5) {
                System.out.println(p);
            }


            /*
             * ============================================================
             * 4) OUTRAS FORMAS DE USAR PREDICATE E METHOD REFERENCE
             * ============================================================
             *
             * Abaixo estão demonstradas todas as formas alternativas
             * de passar um Predicate para o método removeIf().
             */

            List<Product> listaExemplo = new ArrayList<>();
            listaExemplo.add(new Product("Fone de Ouvido", 80.0));
            listaExemplo.add(new Product("Webcam", 250.0));
            listaExemplo.add(new Product("Cadeira Gamer", 1200.0));

            /*
             * FORMA A: Lambda declarada em uma variável local
             * Atribui a expressão a uma variável do tipo Predicate<Product>.
             */
            Predicate<Product> predVar = p -> p.getPrice() >= 100.0;
            // listaExemplo.removeIf(predVar);

            /*
             * FORMA B: Method Reference com Método Estático da Classe Product
             * Assinatura esperada no Product: public static boolean staticProductPredicate(Product p)
             */
            // listaExemplo.removeIf(Product::staticProductPredicate);

            /*
             * FORMA C: Method Reference com Método NÃO Estático (de Instância) da Classe Product
             * Assinatura esperada no Product: public boolean nonstaticProductPredicate()
             * O Java entende automaticamente que deve executar esse método na instância 'p' recebida.
             */
            // listaExemplo.removeIf(Product::nonstaticProductPredicate);

            /*
             * FORMA D: Lambda declarada inline com bloco de código { }
             * Permite colocar mais lógica antes do return.
             */
            // listaExemplo.removeIf(p -> {
            //     double limite = 500.0;
            //     return p.getPrice() > limite;
            // });

            /*
             * FORMA E: Composição de Predicates (Inversão / Negação com .negate())
             * Remove os produtos que NÃO atendem à condição (inverte true <-> false).
             */
            // Predicate<Product> ehBarato = p -> p.getPrice() < 200.0;
            // listaExemplo.removeIf(ehBarato.negate()); // Remove os que NÃO são baratos (ou seja, preço >= 200.0)

            /*
             * FORMA F: Composição de Predicates (E Lógico com .and() / OU Lógico com .or())
             * Permite combinar duas ou mais condições funcionais.
             */
            // Predicate<Product> precoAlto = p -> p.getPrice() >= 500.0;
            // Predicate<Product> nomeComC = p -> p.getName().startsWith("C");
            // listaExemplo.removeIf(precoAlto.and(nomeComC)); // Remove se preço >= 500 E nome começa com 'C'


            /*
             * ============================================================
             * EXPRESSÃO LAMBDA DECLARADA EM VARIÁVEL (PREDICADO)
             * ============================================================
             *
             * Aqui a lógica de filtragem é atribuída explicitamente a
             * uma variável do tipo Predicate<Product>.
             *
             * Vantagem: Permite reutilizar a mesma regra de remoção
             * em diversas partes do código ou compor com outros predicados.
             */
            List<Product> listaTestePreco = new ArrayList<>();

            listaTestePreco.add(new Product("TV Smart", 2000.0));
            listaTestePreco.add(new Product("Fone Bluetooth", 80.0));
            listaTestePreco.add(new Product("Mouse Gamer", 250.0));
            listaTestePreco.add(new Product("Cadeira Gamer", 1200.0));
            listaTestePreco.add(new Product("Notebook Dell", 4500.0));


            System.out.println("\n========== LISTA ANTES (PREDICADO EM VARIÁVEL) ==========");
            for (Product p : listaTestePreco) {
                System.out.println(p);
            }

            System.out.println();
            Double valor = Leitor.lerNumeroDouble(sc, "Digite um valor preço: ");

            // Declara a expressão e armazena na variável 'predVar2'
            //Predicate<Product> predVar2 = p -> p.getPrice() >= valor; //IMPORTANDO: declaração da expressão lambda

            // Passa a variável de predicado para o método removeIf()
            //listaTestePreco.removeIf(predVar2); IMPORTANTE: uso da variável Expressão lambda declarada
            /*
             * ============================================================
             * EXPRESSÃO LAMBDA INLINE (PREDICATE)
             * ============================================================
             *
             * Não é obrigatório criar uma variável Predicate.
             *
             * Podemos passar a Expressão Lambda diretamente
             * para o método removeIf().
             *
             * O compilador cria automaticamente um objeto que
             * implementa Predicate<Product>.
             *
             * A Lambda abaixo implementa o método:
             *
             * boolean test(Product p){
             *      return p.getPrice() >= valor;
             * }
             *
             * Para cada objeto Product da lista:
             *
             * true  -> remove o produto
             * false -> mantém o produto
             *
             */

            listaTestePreco.removeIf(
                    p -> p.getPrice() >= valor
            );




            System.out.println("\n========== LISTA DEPOIS (REMOVIDOS PREÇOS >= 1000) ==========");
            for (Product p : listaTestePreco) {
                System.out.println(p);
            }

        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}

/*
 * ============================================================
 * RESUMO DAS 5 FORMAS DE IMPLEMENTAR PREDICATE<T>
 * ============================================================
 *
 * 1) Classe Concreta Separada:
 *    public class ProductPredicate implements Predicate<Product> { ... }
 *    lista.removeIf(new ProductPredicate());
 *
 * 2) Classe Anônima:
 *    lista.removeIf(new Predicate<Product>() {
 *        public boolean test(Product p) { return p.getPrice() >= 100; }
 *    });
 *
 * 3) Expressão Lambda Direta (Inline):
 *    lista.removeIf(p -> p.getPrice() >= 100);
 *
 * 4) Method Reference (Método Estático):
 *    lista.removeIf(Product::staticProductPredicate);
 *
 * 5) Method Reference (Método de Instância / Comum / Não Estático):
 *    lista.removeIf(Product::nonstaticProductPredicate);
 *
 * ============================================================
 */