package progracaofuncional_lambda.interface_funcionais.interfaces.util;

import progracaofuncional_lambda.entities.Product;
import java.util.function.Function;

/*
 * Implementação tradicional de Function<Product, String> em classe separada.
 * Recebe um Product (T) e retorna o Nome em letras maiúsculas (R).
 * *
 * *UpperCaseName
 */
public class ProductFunction implements Function<Product, String> {

    @Override
    public String apply(Product p) {
        return p.getName().toUpperCase();
    }
}