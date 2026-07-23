package progracaofuncional_lambda.interface_funcionais.apps;

/*
 * ============================================================
 * FUNCTION<T, R>
 * ============================================================
 *
 * Function é uma Interface Funcional pertencente ao pacote:
 *
 *      java.util.function
 *
 * Ela representa uma função que:
 *
 *      recebe um objeto (T)
 *             │
 *             ▼
 *      executa uma transformação/processamento
 *             │
 *             ▼
 *      RETORNA outro valor/objeto (R).
 *
 *
 * ============================================================
 * MÉTODO ABSTRATO
 * ============================================================
 *
 * Como toda Interface Funcional, Function possui
 * apenas um único método abstrato.
 *
 * R apply(T t);
 *
 *
 * Estrutura:
 *
 * Function<T, R>
 *
 * recebe:
 *
 *      T (Tipo de Entrada)
 *
 * retorna:
 *
 *      R (Tipo de Saída/Resultado)
 *
 *
 * ============================================================
 * CONCEITO DA FUNÇÃO .map() VS ESTRUTURA MAP
 * ============================================================
 *
 * A função 'map' (não confunda com a estrutura de dados Map) é uma
 * operação que aplica uma função (Function<T, R>) a todos os
 * elementos de uma Stream.
 *
 * Conversões fundamentais:
 *   • List para Stream  : .stream()
 *   • Stream para List  : .collect(Collectors.toList())
 *
 * Fluxo visual:
 *   [ Lista Original ] ──── .stream() ────> [ Esteira (Stream) ] ──── .map(Function) ────> [ Dados Transformados ] ──── .collect(...) ────> [ Nova Lista ]
 *
 * Exemplo prático:
 *   List<Product> listaProdutos = new ArrayList<>();
 *   // ... adiciona produtos ...
 *
 *   List<String> listaNomes = listaProdutos.stream() // 1. Converte a Lista para Stream (Entra na esteira)
 *           .map(p -> p.getName())                   // 2. Transforma cada Product (T) em String (R)
 *           .collect(Collectors.toList());           // 3. Converte a Stream de volta para Lista (Sai da esteira)
 *
 *
 * ============================================================
 * PARA QUE PRECISAMOS DESSAS TRANSFORMAÇÕES?
 * ============================================================
 *
 * No mundo real, usamos .map() + Function principalmente para:
 *
 * 1. Projeção (extrair atributos específicos, ex: pegar só os nomes);
 * 2. Conversão de Tipos / DTOs (converter Entidades do Banco em DTOs de API);
 * 3. Cálculos e Formatações (aplicar taxas/impostos a uma lista de preços);
 * 4. Imutabilidade (gera uma NOVA lista sem alterar os dados da lista original).
 *
 *
 * ============================================================
 * QUANDO UTILIZAR?
 * ============================================================
 *
 * Utilizamos Function quando desejamos TRANSFORMAR ou MAPEAR
 * um objeto em outro valor (do mesmo tipo ou de tipo diferente).
 *
 * Exemplos:
 *
 * • Mapear uma lista de Produtos para uma lista de Nomes (String);
 * • Converter um DTO em uma Entity (ou vice-versa);
 * • Extrair um atributo específico de um objeto;
 * • Aplicar um cálculo e retornar o resultado (ex: preco * quantidade).
 *
 *
 * ============================================================
 * IMPLEMENTAÇÃO TRADICIONAL
 * ============================================================
 *
 * Antes do Java 8 era comum criar uma classe separada:
 *
 * public class ProductFunction
 *          implements Function<Product, String>
 *
 * E implementar:
 *
 * public String apply(Product p) {
 *      return p.getName().toUpperCase();
 * }
 *
 *
 * ============================================================
 * CLASSE ANÔNIMA
 * ============================================================
 *
 * new Function<Product, String>() {
 *      @Override
 *      public String apply(Product p) {
 *          return p.getName().toUpperCase();
 *      }
 * }
 *
 *
 * ============================================================
 * EXPRESSÃO LAMBDA
 * ============================================================
 *
 * p -> p.getName().toUpperCase()
 *
 * O compilador cria automaticamente um objeto que
 * implementa Function<Product, String>.
 *
 *
 * ============================================================
 * EXEMPLO DE MÉTODO QUE RECEBE FUNCTION
 * ============================================================
 *
 * map() (da Stream API)
 *
 * List<String> nomes = list.stream()
 *      .map(p -> p.getName().toUpperCase())
 *      .collect(Collectors.toList());
 *
 *
 * ============================================================
 * RESUMO
 * ============================================================
 *
 * Predicate
 *      Recebe T → Retorna boolean
 *
 * Consumer
 *      Recebe T → Executa ação (void)
 *
 * Function
 *      Recebe T → Retorna R (Transformação)
 *
 * Supplier
 *      Não recebe → Retorna T
 *
 */

/*
 sintaxe
 public interface Function<T, R> {
    R apply(T t); // recebe T e retorna R
 }
*/

import progracaofuncional_lambda.entities.Product;
import progracaofuncional_lambda.interface_funcionais.interfaces.util.ProductFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionApp {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {

            // ============================================================
            // 1ª FORMA: Classe utilitária que implementa Function<Product, String>
            // ============================================================

            System.out.println("=================== 1ª FORMA: Function em Classe separada ===================");

         // Lista original de produtos (objetos).
            List<Product> list01 = new ArrayList<>();

            list01.add(new Product("Notebook Dell", 4500.0));
            list01.add(new Product("Mouse Gamer", 180.0));
            list01.add(new Product("Teclado Mecânico", 350.0));

            /*
             * Entendendo o conceito da Function<T, R> e da operação .map().
             *
             * Essa anotação sintetiza o principal superpoder da Function:
             * a capacidade de MUDAR o tipo de dado da coleção.
             *
             * Entra: List<Product>   (Lista de objetos do tipo Product)
             *           │
             *           ▼  .map(Function<Product, String>)
             *           │
             * Sai:   List<String>    (Nova lista apenas com as Strings/Nomes)
             */

            // A segunda lista transformada é uma lista de String,
            // ou seja, converte a lista de produtos em uma lista de nomes.

            // O método .map() da Stream API recebe uma Function<T, R>.
            List<String> nomes01 = list01.stream()          // .stream() -> converte a lista original para uma Stream (entra Product)
                    .map(new ProductFunction())             // .map() -> aplica a transformação em cada elemento (Product -> String)
                    .collect(Collectors.toList());          // .collect() -> converte a Stream<String> em List<String> (sai apenas os nomes)

            // Consumer usando referência para método (Method Reference).
            nomes01.forEach(System.out::println);


            // ============================================================
            // 2ª FORMA: Classe Anônima
            // ============================================================
            System.out.println("\n=================== 2ª FORMA: Classe Anônima ===================");
            List<Product> list02 = new ArrayList<>();
            list02.add(new Product("Notebook Dell", 4500.0));
            list02.add(new Product("Mouse Gamer", 180.0));
            list02.add(new Product("Teclado Mecânico", 350.0));

            List<String> nomes02 = list02.stream()
                    .map(new Function<Product, String>() {
                        @Override
                        public String apply(Product p) {
                            return p.getName().toUpperCase();
                        }
                    })
                    .collect(Collectors.toList());

            nomes02.forEach(System.out::println);


            // ============================================================
            // 3ª FORMA: Method Reference (Método ESTÁTICO)
            // ============================================================
            System.out.println("\n=================== 3ª FORMA: Method Reference (Método Estático) ===================");
            List<Product> list03 = new ArrayList<>();
            list03.add(new Product("Notebook Dell", 4500.0));
            list03.add(new Product("Mouse Gamer", 180.0));
            list03.add(new Product("Teclado Mecânico", 350.0));

            List<String> nomes03 = list03.stream()
                    .map(Product::staticUpperCaseName)
                    .collect(Collectors.toList());

            nomes03.forEach(System.out::println);


            // ============================================================
            // 4ª FORMA: Method Reference (Método NÃO Estático / Instância)
            // ============================================================
            System.out.println("\n=================== 4ª FORMA: Method Reference (Método de Instância) ===================");
            List<Product> list04 = new ArrayList<>();
            list04.add(new Product("Notebook Dell", 4500.0));
            list04.add(new Product("Mouse Gamer", 180.0));
            list04.add(new Product("Teclado Mecânico", 350.0));

            List<String> nomes04 = list04.stream()
                    .map(Product::nonStaticUpperCaseName)
                    .collect(Collectors.toList());

            nomes04.forEach(System.out::println);


            // ============================================================
            // 5ª FORMA: Expressão Lambda declarada numa Variável
            // ============================================================
            System.out.println("\n=================== 5ª FORMA: Lambda em Variável ===================");
            List<Product> list05 = new ArrayList<>();
            list05.add(new Product("Notebook Dell", 4500.0));
            list05.add(new Product("Mouse Gamer", 180.0));
            list05.add(new Product("Teclado Mecânico", 350.0));

            // Declarando a Function em uma variável explícita
            Function<Product, String> funcVar = p -> p.getName().toUpperCase();

            List<String> nomes05 = list05.stream()
                    .map(funcVar)
                    .collect(Collectors.toList());

            nomes05.forEach(System.out::println);


            // ============================================================
            // 6ª FORMA: Expressão Lambda Inline (Direta no map)
            // ============================================================
            System.out.println("\n=================== 6ª FORMA: Lambda Inline (A mais comum no dia a dia) ===================");
            List<Product> list06 = new ArrayList<>();
            list06.add(new Product("Notebook Dell", 4500.0));
            list06.add(new Product("Mouse Gamer", 180.0));
            list06.add(new Product("Teclado Mecânico", 350.0));

            // Transforma uma lista de Product em uma lista de String (Nomes) inline
            List<String> nomes06 = list06.stream()
                    .map(p -> p.getName().toUpperCase())
                    .collect(Collectors.toList());

            nomes06.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}

/*
 * ============================================================
 * RESUMO DAS FORMAS DE IMPLEMENTAR FUNCTION<T, R>
 * ============================================================
 *
 * 1) Classe Concreta Separada:
 *    public class ProductFunction implements Function<Product, String> { ... }
 *    list.stream().map(new ProductFunction()).collect(...);
 *
 * 2) Classe Anônima:
 *    list.stream().map(new Function<Product, String>() {
 *        public String apply(Product p) { return p.getName().toUpperCase(); }
 *    }).collect(...);
 *
 * 3) Method Reference (Método Estático):
 *    list.stream().map(Product::staticUpperCaseName).collect(...);
 *
 * 4) Method Reference (Método de Instância / Comum / Não Estático):
 *    list.stream().map(Product::nonStaticUpperCaseName).collect(...);
 *
 * 5) Expressão Lambda em Variável:
 *    Function<Product, String> func = p -> p.getName().toUpperCase();
 *    list.stream().map(func).collect(...);
 *
 * 6) Expressão Lambda Direta (Inline):
 *    list.stream().map(p -> p.getName().toUpperCase()).collect(...);
 *
 * ============================================================
 */