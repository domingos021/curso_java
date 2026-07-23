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
     * Getters e Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    /*
     * ============================================================
     * MÉTODOS PARA PREDICATE<T> (RETORNAM BOOLEAN)
     * ============================================================
     *
     * Métodos utilitários para uso em filtros, removeIf e streams.
     * Retornam true ou false.
     *
     * Estrutura esperada pelo Predicate:
     *   - Estático:   boolean nome(Product p)
     *   - Instância:  boolean nome()
     */

    // Método estático: recebe um produto como parâmetro
    // Utilização via Method Reference: Product::staticProductPredicate
    public static boolean staticProductPredicate(Product p) {
        System.out.println("[PREDICATE - ESTÁTICO] Testando condição para: " + p.getName());
        return p.getPrice() != null && p.getPrice() >= 500.0;
    }

    // Método comum (instância): trabalha direto com o 'this'
    // Utilização via Method Reference: Product::nonstaticProductPredicate
    public boolean nonstaticProductPredicate() {
        System.out.println("[PREDICATE - INSTÂNCIA] Testando condição para: " + this.name);
        return this.price != null && (this.price == 2000.0 || this.price < 500.0);
    }


    /*
     * ============================================================
     * MÉTODOS PARA CONSUMER<T> (RETORNAM VOID)
     * ============================================================
     *
     * Métodos utilitários para uso no forEach.
     * Executam uma ação de alteração/processamento e NÃO retornam nada (void).
     *
     * Estrutura esperada pelo Consumer:
     *   - Estático:   void nome(Product p)
     *   - Instância:  void nome()
     */

    // Método estático: recebe o objeto por parâmetro e altera o preço em 10%
    // Utilização via Method Reference: Product::staticPriceUpdate
    public static void staticPriceUpdate(Product p) {
        System.out.println("[CONSUMER - ESTÁTICO] Reajustando preço de: " + p.getName());
        p.setPrice(p.getPrice() * 1.10);
    }

    // Método de instância: altera o próprio 'this.price' em 10%
    // Utilização via Method Reference: Product::nonStaticPriceUpdate
    public void nonStaticPriceUpdate() {
        System.out.println("[CONSUMER - INSTÂNCIA] Reajustando preço de: " + this.name);
        this.price = this.price * 1.10;
    }

    /*
     * ============================================================
     * MÉTODOS PARA FUNCTION<T, R> (RECEBEM T, RETORNAM R)
     * ============================================================
     *
     * Métodos utilitários para mapeamento/transformação.
     * Recebem um objeto e RETORNAM um novo valor (outro tipo ou valor alterado).
     *
     * Estrutura esperada pela Function:
     *   - Estático:   R nome(Product p)
     *   - Instância:  R nome()
     */

    // Método estático: recebe um Product e retorna o nome em maiúsculas
    // Utilização via Method Reference: Product::staticUpperCaseName
    public static String staticUpperCaseName(Product p) {
        System.out.println("[FUNCTION - ESTÁTICO] Mapeando nome para maiúsculas: " + p.getName());
        return p.getName().toUpperCase();
    }

    // Método de instância: acessa o 'this.name' e retorna em maiúsculas
    // Utilização via Method Reference: Product::nonStaticUpperCaseName
    public String nonStaticUpperCaseName() {
        System.out.println("[FUNCTION - INSTÂNCIA] Mapeando nome para maiúsculas: " + this.name);
        return this.name.toUpperCase();
    }


    /*
     * ============================================================
     * MÉTODOS SOBRESCRITOS (TOSTRING, EQUALS, HASHCODE)
     * ============================================================
     */

    /*
     * Retorna uma representação textual do objeto com preço formatado.
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + String.format("%.2f", price) +
                '}';
    }

    /*
     * Garante que dois objetos com os mesmos valores sejam
     * considerados iguais em buscas, remoções e coleções Set/Map.
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