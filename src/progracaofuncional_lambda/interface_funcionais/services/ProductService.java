package progracaofuncional_lambda.interface_funcionais.services;

import progracaofuncional_lambda.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    /**
     * ABORDAGEM RÍGIDA (Hardcoded)
     * Percorre a lista e soma os preços apenas dos produtos
     * cujo nome começa com a letra 'T'.
     */
    public double filterSum(List<Product> list) {
        double sum = 0.0;

        for (Product p : list) {
            // Regra fixa diretamente no código: verifica se começa com 'T'
            if (p.getName().charAt(0) == 'T') {
                sum += p.getPrice();
            }
        }

        return sum;
    }

    /**
     * ABORDAGEM FLEXÍVEL (Programação Funcional)
     * Recebe um critério de comparação (Predicate) de fora,
     * permitindo filtrar e somar por qualquer regra definida pelo chamador.
     */
    public double filterSoma(List<Product> list, Predicate<Product> comparisonCriteria) {
        double soma = 0.0;

        for (Product p : list) {
            // Executa o teste genérico passado via expressão Lambda ou Method Reference
            if (comparisonCriteria.test(p)) {
                soma += p.getPrice();
            }
        }

        return soma;
    }

    /**
     * ABORDAGEM MODERNA (Java Streams)
     * Faz o mesmo filtro e soma funcional, mas sem utilizar a estrutura manual de 'for' e 'if'.
     */
    public double filterSomaStream(List<Product> list, Predicate<Product> comparisonCriteria) {
        return list.stream()                        // Transforma a lista em uma Stream
                .filter(comparisonCriteria)       // Aplica o filtro dinâmico
                .mapToDouble(Product::getPrice)   // Extrai apenas o preço de cada produto
                .sum();                           // Soma todos os valores extraídos
    }
}