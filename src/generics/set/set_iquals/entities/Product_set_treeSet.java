package generics.set.set_iquals.entities;

import java.util.Objects;

public class Product_set_treeSet implements Comparable<Product_set_treeSet> {

    private String name;
    private Double price;

    public Product_set_treeSet(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    /*
     * Implementa a interface Comparable para permitir que
     * o TreeSet saiba como ordenar os objetos.
     *
     * O TreeSet utiliza o compareTo() para:
     * - Organizar os elementos.
     * - Verificar se um elemento já existe no conjunto.
     *
     * Neste caso, a comparação será feita pelo nome
     * do produto em ordem alfabética.
     */
    @Override
    public int compareTo(Product_set_treeSet other) {
        return name.toUpperCase().compareTo(other.getName().toUpperCase());
    }

    /*
     * Compara dois objetos pelo conteúdo, e não pela
     * referência de memória.
     *
     * Aqui consideramos dois produtos iguais quando
     * possuem o mesmo nome e o mesmo preço.
     *
     * Observação:
     * O TreeSet não utiliza equals() para controlar
     * duplicidade, ele utiliza compareTo().
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Product_set_treeSet other = (Product_set_treeSet) obj;

        return Objects.equals(name, other.name)
                && Objects.equals(price, other.price);
    }

    /*
     * Gera o código hash baseado nos atributos do objeto.
     *
     * Regra do Java:
     * Se dois objetos são iguais pelo equals(),
     * eles devem possuir o mesmo hashCode().
     *
     * É muito utilizado por HashSet e HashMap.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return String.format(
                "Product: %s | Price: %.2f",
                name,
                price
        );
    }
}
