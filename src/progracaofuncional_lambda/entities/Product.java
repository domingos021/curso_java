package progracaofuncional_lambda.entities;

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
 * Esta classe implementa a interface Comparable,
 * permitindo que objetos Product sejam ordenados
 * automaticamente.
 *
 * Comparable define a chamada ORDEM NATURAL dos objetos.
 *
 * Neste exemplo, a ordem natural será pelo nome
 * do produto em ordem alfabética.
 *
 * Caso desejemos ordenar por outro critério
 * (preço, quantidade, código etc.),
 * utilizaremos um Comparator.
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
     * compareTo()
     * ============================================================
     *
     * Método definido pela interface Comparable.
     *
     * É aqui que definimos a ORDEM NATURAL da classe.
     *
     * Sempre que utilizarmos:
     *
     * Collections.sort(lista);
     *
     * este método será chamado automaticamente para
     * comparar dois objetos Product.
     *
     * Fluxo:
     *
     * Collections.sort(lista)
     *          │
     *          ▼
     * compareTo(produto1, produto2)
     *          │
     *          ▼
     * Retorna:
     *
     * < 0  → this vem antes de p
     * = 0  → objetos equivalentes
     * > 0  → p vem antes de this
     *
     * Neste exemplo estamos comparando apenas o nome
     * dos produtos.
     *
     * O método toUpperCase() transforma ambos os nomes
     * em letras maiúsculas antes da comparação.
     *
     * Assim:
     *
     * notebook
     * Notebook
     * NOTEBOOK
     *
     * serão considerados iguais para fins de ordenação,
     * tornando a comparação independente de letras
     * maiúsculas e minúsculas.
     * *
     * *Comparação por nomes, ignorando maiúsculos e minuscule
     */



}