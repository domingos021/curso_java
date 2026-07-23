package progracaofuncional_lambda.interface_funcionais.apps;

/*
 * ============================================================
 * CONSUMER<T>
 * ============================================================
 *
 * Consumer é uma Interface Funcional pertencente ao pacote:
 *
 *      java.util.function
 *
 * Ela representa uma operação que:
 *
 *      recebe um objeto
 *             │
 *             ▼
 *      executa alguma ação
 *             │
 *             ▼
 *      NÃO retorna nenhum valor.
 *
 *
 * ============================================================
 * MÉTODO ABSTRATO
 * ============================================================
 *
 * Como toda Interface Funcional, Consumer possui
 * apenas um único método abstrato.
 *
 * void accept(T t);
 *
 *
 * Estrutura:
 *
 * Consumer<T>
 *
 * recebe:
 *
 *      T
 *
 * retorna:
 *
 *      void
 *
 *
 * ============================================================
 * QUANDO UTILIZAR?
 * ============================================================
 *
 * Utilizamos Consumer quando desejamos executar
 * alguma ação sobre um objeto sem produzir um
 * valor de retorno.
 *
 * Exemplos:
 *
 * • imprimir informações;
 * • alterar atributos;
 * • enviar mensagens;
 * • gravar dados;
 * • atualizar objetos;
 * • modificar elementos de uma coleção.
 *
 *
 * ============================================================
 * IMPLEMENTAÇÃO TRADICIONAL
 * ============================================================
 *
 * Antes do Java 8 era comum criar uma classe
 * separada:
 *
 * public class ProductConsumer
 *          implements Consumer<Product>
 *
 *
 * Depois implementar:
 *
 * public void accept(Product p){
 *      ...
 * }
 *
 *
 * ============================================================
 * CLASSE ANÔNIMA
 * ============================================================
 *
 * Também era possível utilizar:
 *
 * new Consumer<Product>() {
 *
 *      @Override
 *      public void accept(Product p){
 *          ...
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
 * p -> ...
 *
 * Exemplo:
 *
 * Consumer<Product> consumer =
 *      p -> System.out.println(p);
 *
 *
 * O compilador cria automaticamente um objeto que
 * implementa Consumer<Product>.
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
 * EXEMPLOS DE MÉTODOS QUE RECEBEM CONSUMER
 * ============================================================
 *
 * forEach()
 *
 * lista.forEach(
 *      p -> System.out.println(p)
 * );
 *
 *
 * replaceAll()
 *
 * lista.replaceAll(
 *      p -> ...
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
 public interface Consumer<T> {
    void accept( T t); // é um void, executa uma ação e não retorna nada
 }
*/

import progracaofuncional_lambda.entities.Product;
import progracaofuncional_lambda.interface_funcionais.interfaces.util.ConsumerPriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerConceito {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {

            // ============================================================
            // 1ª FORMA: Classe utilitária que implementa Consumer<Product>
            // ============================================================
            System.out.println("=================== 1ª FORMA: Consumer em Classe separada ===================");
            List<Product> list01 = new ArrayList<>();
            list01.add(new Product("Notebook Dell", 4500.0));
            list01.add(new Product("Mouse Gamer", 180.0));
            list01.add(new Product("Teclado Mecânico", 350.0));
            list01.add(new Product("Monitor LG 27\"", 1400.0));
            list01.add(new Product("Headset HyperX", 420.0));

            // Instancia a classe que implementa Consumer e passa no forEach
            list01.forEach(new ConsumerPriceUpdate());
            list01.forEach(System.out::println);


            // ============================================================
            // 2ª FORMA: Method Reference (Método ESTÁTICO)
            // ============================================================
            System.out.println("\n=================== 2ª FORMA: Method Reference (Método Estático) ===================");
            List<Product> list02 = new ArrayList<>();
            list02.add(new Product("Notebook Dell", 4500.0));
            list02.add(new Product("Mouse Gamer", 180.0));
            list02.add(new Product("Teclado Mecânico", 350.0));
            list02.add(new Product("Monitor LG 27\"", 1400.0));
            list02.add(new Product("Headset HyperX", 420.0));

            // Passa a referência ao método estático Product.staticPriceUpdate(Product p)
            list02.forEach(Product::staticPriceUpdate);
            list02.forEach(System.out::println);


            // ============================================================
            // 3ª FORMA: Method Reference (Método NÃO Estático / Instância)
            // ============================================================
            System.out.println("\n=================== 3ª FORMA: Method Reference (Método de Instância) ===================");
            List<Product> list03 = new ArrayList<>();
            list03.add(new Product("Notebook Dell", 4500.0));
            list03.add(new Product("Mouse Gamer", 180.0));
            list03.add(new Product("Teclado Mecânico", 350.0));
            list03.add(new Product("Monitor LG 27\"", 1400.0));
            list03.add(new Product("Headset HyperX", 420.0));

            // Chama o método de instância nonStaticPriceUpdate() para cada objeto
            list03.forEach(Product::nonStaticPriceUpdate);
            list03.forEach(System.out::println);


            // ============================================================
            // 4ª FORMA: Expressão Lambda declarada numa Variável
            // ============================================================
            System.out.println("\n=================== 4ª FORMA: Lambda em Variável ===================");
            List<Product> list04 = new ArrayList<>();
            list04.add(new Product("Notebook Dell", 4500.0));
            list04.add(new Product("Mouse Gamer", 180.0));
            list04.add(new Product("Teclado Mecânico", 350.0));
            list04.add(new Product("Monitor LG 27\"", 1400.0));
            list04.add(new Product("Headset HyperX", 420.0));

            double fator = 1.10;
            Consumer<Product> cons = p -> p.setPrice(p.getPrice() * fator);

            list04.forEach(cons);
            // Method Reference (Referência a Método):             // É um atalho para a expressão lambda 'p -> System.out.println(p)'.
            // O Java pega automaticamente cada elemento retornado pelo forEach e passa como argumento para oprintln.
            list04.forEach(System.out::println);


            // ============================================================
            // 5ª FORMA: Expressão Lambda Inline (Direta no forEach)
            // ============================================================
            System.out.println("\n=================== 5ª FORMA: Lambda Inline (A mais comum no dia a dia) ===================");
            List<Product> list05 = new ArrayList<>();
            list05.add(new Product("Notebook Dell", 4500.0));
            list05.add(new Product("Mouse Gamer", 180.0));
            list05.add(new Product("Teclado Mecânico", 350.0));
            list05.add(new Product("Monitor LG 27\"", 1400.0));
            list05.add(new Product("Headset HyperX", 420.0));

            // Escreve a regra diretamente dentro dos parênteses do forEach
            list05.forEach(p -> p.setPrice(p.getPrice() * 1.10));
            list05.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}