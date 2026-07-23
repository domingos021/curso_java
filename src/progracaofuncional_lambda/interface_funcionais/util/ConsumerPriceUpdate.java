package progracaofuncional_lambda.interface_funcionais.util;

import progracaofuncional_lambda.entities.Product;

import java.util.function.Consumer;

/*
 * ============================================================
 * IMPLEMENTAÇÃO DE UM CONSUMER COM CLASSE SEPARADA
 * ============================================================
 *
 * Consumer é uma Interface Funcional que representa
 * uma operação sobre um objeto sem retornar nenhum valor.
 *
 * Método abstrato:
 *
 * void accept(T t);
 *
 *
 * Esta classe implementa:
 *
 * Consumer<Product>
 *
 *
 * Portanto, somos obrigados a implementar:
 *
 * void accept(Product p)
 *
 *
 * O objetivo deste Consumer é atualizar o preço
 * do produto, aplicando um aumento de 10%.
 *
 *
 * Esta implementação é equivalente à Expressão Lambda:
 *
 * p -> p.setPrice(p.getPrice() * 1.10);
 *
 */

public class ConsumerPriceUpdate implements Consumer<Product> {

    /*
     * O método accept() recebe um Product e executa
     * uma ação sobre ele.
     *
     * Neste exemplo:
     *
     * Novo preço = preço atual + 10%
     */

    @Override
    public void accept(Product p) {

        p.setPrice(p.getPrice() * 1.10);

    }
}