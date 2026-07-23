package progracaofuncional_lambda.interface_funcionais.apps;

/*
 * ============================================================
 * PREDICATE<T>
 * ============================================================
 *
 * Predicate é uma Interface Funcional pertencente ao pacote:
 *
 *      java.util.function
 *
 * Ela representa uma função que:
 *
 *      recebe um objeto
 *             │
 *             ▼
 *      executa uma condição
 *             │
 *             ▼
 *      retorna true ou false.
 *
 *
 * ============================================================
 * MÉTODO ABSTRATO
 * ============================================================
 *
 * Como toda Interface Funcional, Predicate possui
 * apenas um único método abstrato.
 *
 * boolean test(T t);
 *
 *
 * Estrutura:
 *
 * Predicate<T>
 *
 * recebe:
 *
 *      T
 *
 * retorna:
 *
 *      boolean
 *
 *
 * ============================================================
 * QUANDO UTILIZAR?
 * ============================================================
 *
 * Utilizamos Predicate quando desejamos testar uma condição
 * sobre um objeto para tomar uma decisão booleana.
 *
 * Exemplos:
 *
 * • filtrar coleções (removeIf, filter);
 * • validar atributos de um objeto;
 * • verificar regras de negócio (ex: preço >= valor);
 * • verificar estados (ex: está ativo, está em estoque).
 *
 *
 * ============================================================
 * IMPLEMENTAÇÃO TRADICIONAL
 * ============================================================
 *
 * Antes do Java 8 era comum criar uma classe
 * separada:
 *
 * public class ProductPredicate
 *          implements Predicate<Product>
 *
 *
 * Depois implementar:
 *
 * public boolean test(Product p){
 *      return p.getPrice() >= 500.0;
 * }
 *
 *
 * ============================================================
 * CLASSE ANÔNIMA
 * ============================================================
 *
 * Também era possível utilizar:
 *
 * new Predicate<Product>() {
 *
 *      @Override
 *      public boolean test(Product p){
 *          return p.getPrice() >= 500.0;
 *      }
 * }
 *
 *
 * ============================================================
 * EXPRESSÃO LAMBDA
 * ============================================================
 *
 * A partir do Java 8 podemos escrever:
 *
 * p -> p.getPrice() >= 500.0
 *
 *
 * O compilador cria automaticamente um objeto que
 * implementa Predicate<Product>.
 *
 *
 * ============================================================
 * DIFERENÇA ENTRE PREDICATE E CONSUMER
 * ============================================================
 *
 * Predicate
 *
 * recebe um objeto
 * retorna boolean
 *
 * boolean test(T t);
 *
 *
 * Consumer
 *
 * recebe um objeto
 * não retorna nada
 *
 * void accept(T t);
 *
 *
 * ============================================================
 * EXEMPLOS DE MÉTODOS QUE RECEBEM PREDICATE
 * ============================================================
 *
 * removeIf()
 *
 * lista.removeIf(
 *      p -> p.getPrice() >= 500.0
 * );
 *
 *
 * filter() (da Stream API)
 *
 * lista.stream().filter(
 *      p -> p.getPrice() >= 500.0
 * );
 *
 *
 * ============================================================
 * RESUMO
 * ============================================================
 *
 * Predicate
 *      Recebe → Retorna boolean
 *
 * Consumer
 *      Recebe → Executa uma ação
 *
 * Function
 *      Recebe → Retorna outro valor
 *
 * Supplier
 *      Não recebe → Retorna um valor
 *
 */

/*
 sintaxe
 public interface Predicate<T> {
    boolean test(T t); // recebe um argumento e retorna boolean (true/false)
 }
*/

import generals_utils.utils.Leitor;
import progracaofuncional_lambda.entities.Product;
import progracaofuncional_lambda.interface_funcionais.util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateApp {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {

            // ============================================================
            // 1ª FORMA: Classe utilitária que implementa Predicate<Product>
            // ============================================================
            System.out.println("=================== 1ª FORMA: Predicate em Classe Separada ===================");
            List<Product> list01 = new ArrayList<>();
            list01.add(new Product("Tv", 2000.0));
            list01.add(new Product("Mouse", 150.0));
            list01.add(new Product("Teclado", 300.0));
            list01.add(new Product("Notebook", 4500.0));
            list01.add(new Product("Monitor", 1200.0));

            System.out.println("--- Lista Original ---");
            list01.forEach(System.out::println);

            // Cria um objeto ProductPredicate que implementa Predicate<Product> e envia para removeIf()
            list01.removeIf(new ProductPredicate());

            System.out.println("\n--- Após removeIf com ProductPredicate ---");
            list01.forEach(System.out::println);


            // ============================================================
            // 2ª FORMA: Classe Anônima
            // ============================================================
            System.out.println("\n=================== 2ª FORMA: Classe Anônima ===================");
            List<Product> list02 = new ArrayList<>();
            list02.add(new Product("Celular", 2500.0));
            list02.add(new Product("Cabo USB", 50.0));
            list02.add(new Product("Carregador", 120.0));
            list02.add(new Product("Notebook Gamer", 7000.0));

            System.out.println("--- Lista Original ---");
            list02.forEach(System.out::println);

            list02.removeIf(new Predicate<Product>() {
                @Override
                public boolean test(Product produto) {
                    return produto.getPrice() < 200.0;
                }
            });

            System.out.println("\n--- Após removeIf com Classe Anônima (Preço < 200) ---");
            list02.forEach(System.out::println);


            // ============================================================
            // 3ª FORMA: Method Reference (Método ESTÁTICO)
            // ============================================================
            System.out.println("\n=================== 3ª FORMA: Method Reference (Método Estático) ===================");
            List<Product> list03 = new ArrayList<>();
            list03.add(new Product("TV", 2000.0));
            list03.add(new Product("Mouse", 150.0));
            list03.add(new Product("Notebook", 4500.0));
            list03.add(new Product("Teclado", 300.0));

            System.out.println("--- Lista Original ---");
            list03.forEach(System.out::println);

            // Passa a referência do método estático Product::staticProductPredicate
            list03.removeIf(Product::staticProductPredicate);

            System.out.println("\n--- Após removeIf com Método Estático ---");
            list03.forEach(System.out::println);


            // ============================================================
            // 4ª FORMA: Method Reference (Método NÃO Estático / Instância)
            // ============================================================
            System.out.println("\n=================== 4ª FORMA: Method Reference (Método de Instância) ===================");
            List<Product> list04 = new ArrayList<>();
            list04.add(new Product("TV", 2000.0));
            list04.add(new Product("Mouse", 150.0));
            list04.add(new Product("Notebook", 4500.0));
            list04.add(new Product("Teclado", 300.0));
            list04.add(new Product("Teclado02", 400.0));
            list04.add(new Product("Tiled", 1400.0));

            System.out.println("--- Lista Original ---");
            list04.forEach(System.out::println);

            // Executa o método não estático 'nonstaticProductPredicate' em cada elemento
            list04.removeIf(Product::nonstaticProductPredicate);

            System.out.println("\n--- Após removeIf com Método de Instância ---");
            list04.forEach(System.out::println);


            // ============================================================
            // 5ª FORMA: Expressão Lambda declarada numa Variável
            // ============================================================
            System.out.println("\n=================== 5ª FORMA: Lambda em Variável ===================");
            List<Product> list05 = new ArrayList<>();
            list05.add(new Product("TV Smart", 2000.0));
            list05.add(new Product("Fone Bluetooth", 80.0));
            list05.add(new Product("Mouse Gamer", 250.0));
            list05.add(new Product("Cadeira Gamer", 1200.0));
            list05.add(new Product("Notebook Dell", 4500.0));

            System.out.println("--- Lista Original ---");
            list05.forEach(System.out::println);

            System.out.println();
            Double valorInformado = Leitor.lerNumeroDouble(sc, "Digite um valor de preço limite para remoção: ");

            // Declara a expressão e armazena na variável 'predVar'
            Predicate<Product> predVar = p -> p.getPrice() >= valorInformado;

            // Passa a variável de predicado para o método removeIf()
            list05.removeIf(predVar);

            System.out.println("\n--- Após removeIf com Lambda em Variável ---");
            list05.forEach(System.out::println);


            // ============================================================
            // 6ª FORMA: Expressão Lambda Inline (Direta no removeIf)
            // ============================================================
            System.out.println("\n=================== 6ª FORMA: Lambda Inline (A mais comum no dia a dia) ===================");
            List<Product> list06 = new ArrayList<>();
            list06.add(new Product("TV Smart", 2000.0));
            list06.add(new Product("Fone Bluetooth", 80.0));
            list06.add(new Product("Mouse Gamer", 250.0));
            list06.add(new Product("Cadeira Gamer", 1200.0));
            list06.add(new Product("Notebook Dell", 4500.0));

            System.out.println("--- Lista Original ---");
            list06.forEach(System.out::println);

            // A Lambda abaixo implementa o método test(Product p) diretamente no parâmetro
            list06.removeIf(p -> p.getPrice() >= 1000.0);

            System.out.println("\n--- Após removeIf com Lambda Inline (Preço >= 1000.0) ---");
            list06.forEach(System.out::println);


            // ============================================================
            // OUTRAS FORMAS DE USAR PREDICATE (EXEMPLOS AVANÇADOS)
            // ============================================================
            /*
             * FORMA A: Lambda declarada inline com bloco de código { }
             * Permite colocar mais lógica antes do return.
             *
             * list06.removeIf(p -> {
             *     double limite = 500.0;
             *     return p.getPrice() > limite;
             * });
             *
             * FORMA B: Composição de Predicates (Inversão / Negação com .negate())
             * Remove os produtos que NÃO atendem à condição (inverte true <-> false).
             *
             * Predicate<Product> ehBarato = p -> p.getPrice() < 200.0;
             * list06.removeIf(ehBarato.negate()); // Remove os que NÃO são baratos
             *
             * FORMA C: Composição de Predicates (E Lógico com .and() / OU Lógico com .or())
             * Permite combinar duas ou mais condições funcionais.
             *
             * Predicate<Product> precoAlto = p -> p.getPrice() >= 500.0;
             * Predicate<Product> nomeComC = p -> p.getName().startsWith("C");
             * list06.removeIf(precoAlto.and(nomeComC)); // Remove se preço >= 500 E nome começa com 'C'
             */

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}

/*
 * ============================================================
 * RESUMO DAS FORMAS DE IMPLEMENTAR PREDICATE<T>
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
 * 3) Method Reference (Método Estático):
 *    lista.removeIf(Product::staticProductPredicate);
 *
 * 4) Method Reference (Método de Instância / Comum / Não Estático):
 *    lista.removeIf(Product::nonstaticProductPredicate);
 *
 * 5) Expressão Lambda em Variável:
 *    Predicate<Product> pred = p -> p.getPrice() >= 100;
 *    lista.removeIf(pred);
 *
 * 6) Expressão Lambda Direta (Inline):
 *    lista.removeIf(p -> p.getPrice() >= 100);
 *
 * ============================================================
 */