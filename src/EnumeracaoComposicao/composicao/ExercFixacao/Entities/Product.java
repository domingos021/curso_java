package EnumeracaoComposicao.composicao.ExercFixacao.Entities;

//👉 Product NÃO depende de OrderItem
//1. Product representa o catálogo de produtos da loja.
//2. OrderItem representa um item específico de um pedido, com uma quantidade e preço unitário,
// que pode ser diferente do preço atual do produto (por exemplo, devido a promoções ou
public class Product {
    // Nome do produto
    private String name;
    // Preço atual do produto
    private Double price;

    // Construtor padrão
    public Product() {
    }

    // Construtor com os dados do produto
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
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

    // ADIÇÃO: Método toString para facilitar a exibição isolada do produto, se necessário
    @Override
    public String toString() {
        return name + ", $" + String.format("%.2f", price);
    }
}