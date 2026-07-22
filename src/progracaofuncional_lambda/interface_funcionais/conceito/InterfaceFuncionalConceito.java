package progracaofuncional_lambda.interface_funcionais.conceito;

/*
 * ============================================================
 * INTERFACES FUNCIONAIS
 * ============================================================
 *
 * Uma Interface Funcional é uma interface que possui
 * exatamente UM único método abstrato.
 *
 * Ela é a base para o uso de Expressões Lambda no Java.
 *
 * Como existe apenas um método abstrato, o compilador
 * consegue saber qual método a Lambda deve implementar.
 *
 *
 * Exemplo:
 *
 * Comparator<T>
 *
 * possui o método:
 *
 * int compare(T o1, T o2);
 *
 *
 * Portanto podemos substituir uma implementação tradicional:
 *
 * new Comparator<Product>() {
 *
 *      @Override
 *      public int compare(Product p1, Product p2) {
 *          return ...
 *      }
 * }
 *
 *
 * Por uma Expressão Lambda:
 *
 * (p1, p2) -> ...
 *
 *
 * ============================================================
 * ANOTAÇÃO @FunctionalInterface
 * ============================================================
 *
 * O Java possui a anotação @FunctionalInterface para indicar
 * que uma interface deve possuir apenas um método abstrato.
 *
 * Exemplo:
 *
 * @FunctionalInterface
 * public interface Calculadora {
 *
 *      int calcular(int a, int b);
 *
 * }
 *
 *
 * Se alguém tentar adicionar outro método abstrato:
 *
 * int somar(int a, int b);
 * int multiplicar(int a, int b);
 *
 *
 * O compilador apresentará erro.
 *
 *
 * ============================================================
 * INTERFACES FUNCIONAIS PRÓPRIAS DO JAVA
 * ============================================================
 *
 * O pacote java.util.function possui várias interfaces
 * funcionais prontas.
 *
 *
 * Predicate<T>
 *
 * Recebe um objeto e retorna boolean.
 *
 * Exemplo:
 *
 * Predicate<Product> verificar =
 *      p -> p.getPrice() > 1000;
 *
 *
 *
 * Consumer<T>
 *
 * Recebe um objeto e não retorna valor.
 *
 * Exemplo:
 *
 * Consumer<Product> imprimir =
 *      p -> System.out.println(p);
 *
 *
 *
 * Function<T,R>
 *
 * Recebe um valor e retorna outro.
 *
 * Exemplo:
 *
 * Function<Product, String> nome =
 *      p -> p.getName();
 *
 *
 *
 * Supplier<T>
 *
 * Não recebe parâmetros e retorna um valor.
 *
 * Exemplo:
 *
 * Supplier<Double> aleatorio =
 *      () -> Math.random();
 *
 *
 * ============================================================
 * RELAÇÃO COM O PARADIGMA FUNCIONAL
 * ============================================================
 *
 * As Interfaces Funcionais permitem que o Java trabalhe
 * com conceitos da programação funcional:
 *
 * ✔ funções como valores;
 *
 * ✔ passar comportamento como argumento;
 *
 * ✔ criar funções anônimas;
 *
 * ✔ composição de operações.
 *
 *
 * Exemplo:
 *
 * lista.sort(
 *      (p1, p2) -> p1.getName().compareTo(p2.getName())
 * );
 *
 *
 * A Lambda representa o comportamento,
 * e a Interface Funcional define o contrato.
 *
 */
public class InterfaceFuncionalConceito {

}