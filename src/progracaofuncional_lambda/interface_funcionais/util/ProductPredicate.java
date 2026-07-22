package progracaofuncional_lambda.interface_funcionais.util;

import progracaofuncional_lambda.entities.Product;

import java.util.function.Predicate;

/*
 * ============================================================
 * IMPLEMENTAÇÃO DE UM PREDICATE COM CLASSE SEPARADA
 * ============================================================
 *
 * Antes do Java 8, uma forma comum de implementar uma
 * Interface Funcional era criar uma classe separada.
 *
 *
 * Aqui estamos criando uma classe que implementa:
 *
 * Predicate<Product>
 *
 *
 * A interface Predicate possui apenas um método abstrato:
 *
 * boolean test(T t);
 *
 *
 * Portanto, somos obrigados a implementar:
 *
 * boolean test(Product p)
 *
 *
 * ============================================================
 * EQUIVALÊNCIA COM LAMBDA
 * ============================================================
 *
 * Esta implementação:
 *
 * public class ProductPredicate
 *        implements Predicate<Product>
 *
 *
 * é equivalente à Lambda:
 *
 * produto -> produto.getPrice() >= 500.0
 *
 *
 * Ou seja:
 *
 * boolean test(Product produto){
 *
 *      return produto.getPrice() >= 500.0;
 *
 * }
 *
 *
 * A diferença é apenas a forma de escrever.
 *
 * Classe separada:
 *
 * ProductPredicate
 *        |
 *        ▼
 *        test()
 *
 *
 * Lambda:
 *
 * produto -> condição
 *
 *        |
 *        ▼
 *        test()
 *
 *
 * O comportamento é exatamente o mesmo.
 *
 */

public class ProductPredicate implements Predicate<Product> {


    @Override
    public boolean test(Product p) {

        return p.getPrice() >= 500.0;
    }
}