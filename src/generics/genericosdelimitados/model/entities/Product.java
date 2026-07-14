package generics.genericosdelimitados.model.entities;

/*
 * IMPORTANTE PARA OS SEUS ESTUDOS:
 * * - ABORDAGEM A (Nativa do Java): Deixe o import abaixo COMENTADO.
 * O Java usará automaticamente a interface 'java.lang.Comparable'.
 * * - ABORDAGEM B (Personalizada): DESCOMENTE o import abaixo para forçar
 * a sua classe Product a usar a sua própria interface de estudos.
 */
// import interfaces.interface_comparable.model.Comparable;

/**
 * Representa um produto no sistema.
 * * Ao usar "implements Comparable<Product>", estamos assinando um contrato que diz:
 * "Um objeto do tipo Product sabe como se comparar com outro objeto do tipo Product".
 */
public class Product implements Comparable<Product> {

    private String name;
    private Double price;
    private Integer quantity;

    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Define a representação textual elegante do objeto Product.
     * Alinhado com o padrão visual minimalista de chaves { } e divisórias '|'.
     */
    @Override
    public String toString() {
        return String.format("{ %s | Preço: R$ %.2f | Qtd: %d }",
                name, price, quantity);
    }

    /**
     * Implementação obrigatória do contrato da interface Comparable.
     * Aqui definimos a "ordem natural" de comparação dos nossos produtos.
     * * Neste caso, a comparação é baseada no PREÇO do produto.
     * * @param other O outro produto com o qual este será comparado.
     * @return
     * < 0 : Se o preço deste produto for MENOR que o do outro.
     * 0 : Se os preços forem IGUAIS.
     * > 0 : Se o preço deste produto for MAIOR que o do outro.
     */
    @Override
    public int compareTo(Product other) {
        // Como o atributo 'price' é um Double (que é uma classe nativa do Java),
        // nós podemos simplesmente delegar a comparação para o compareTo nativo do Double!
        return price.compareTo(other.getPrice());
    }
}