package EnumeracaoComposicao.composicao.ExercFixacao.Entities;

//👉 OrderItem depende de Product
public class OrderItem {

    // Quantidade daquele produto dentro do pedido
    private Product product;
    private Integer quantity;

    // Preço unitário do produto no momento do pedido
    private Double price;


    // Construtor padrão
    public OrderItem() {
    }


    // CORREÇÃO: Construtor ajustado para receber também o Product,
    // alinhando com a chamada: new OrderItem(productQuantity, productPrice, product)
    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }


    // ADIÇÃO: Getter e Setter para o Product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    /*
    Calcula o subtotal deste item.

    Exemplo:
    preço = 20.0
    quantidade = 3

    subtotal = 20.0 * 3 = 60.0
    */
    public Double subTotal() {
        return price * quantity;
    }

    // ADIÇÃO: Método toString para formatar a exibição da linha deste item no sumário do pedido
    // Exemplo: TV, $1000.00, Quantity: 2, Subtotal: $2000.00
    @Override
    public String toString() {
        return product.getName()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity
                + ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }
}