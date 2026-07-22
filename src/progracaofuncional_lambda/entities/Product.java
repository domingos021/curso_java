package progracaofuncional_lambda.entities;

import java.util.Objects;

/*
 * ============================================================
 * CLASSE PRODUCT
 * ============================================================
 *
 * Representa um produto contendo:
 *
 * • nome;
 * • preço.
 *
 * Nota: Esta classe NÃO implementa a interface Comparable,
 * o que significa que ela não possui uma "ordem natural" padrão.
 *
 * Para ordenar uma lista contendo objetos Product, é
 * OBRIGATÓRIO informar explicitamente um Comparator
 * (seja via Expressão Lambda ou Method Reference).
 */
public class Product {

    /*
     * Nome do produto.
     */
    private String name;

    /*
     * Preço do produto.
     */
    private Double price;

    /*
     * Construtor padrão.
     */
    public Product() {
    }

    /*
     * Construtor com argumentos.
     */
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    /*
     * Retorna o nome do produto.
     */
    public String getName() {
        return name;
    }

    /*
     * Altera o nome do produto.
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Retorna o preço do produto.
     */
    public Double getPrice() {
        return price;
    }

    /*
     * Altera o preço do produto.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /*
     * ============================================================
     * MÉTODOS AUXILIARES PARA PREDICATE (METHOD REFERENCES)
     * ============================================================
     *
     * Ambos os métodos fazem a mesma verificação lógica,
     * mas com assinaturas e escopos diferentes:
     */

    // Método estático: trabalha com os dados do objeto passado via parâmetro.
    // Utilização via Method Reference: Product::staticProductPredicate
    public static boolean staticProductPredicate(Product p) {
        return p.getPrice() != null && p.getPrice() >= 500.0;
    }

    // Método comum (instância): trabalha com os dados da própria classe (this).
    // Utilização via Method Reference: Product::nonstaticProductPredicate
    public boolean nonstaticProductPredicate() {
        return this.price != null
                && (this.price == 2000.0 || this.price < 500.0);
    }


    /*
     * Retorna uma representação textual do objeto.
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /*
     * ============================================================
     * EQUALS E HASHCODE
     * ============================================================
     *
     * Garante que dois objetos com os mesmos valores sejam
     * considerados iguais em buscas, remoções (ex: removeIf)
     * e em coleções como Set e Map.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}