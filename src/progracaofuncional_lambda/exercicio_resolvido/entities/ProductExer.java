package progracaofuncional_lambda.exercicio_resolvido.entities;

public class ProductExer {
    private String name;
    private double price;

    public ProductExer() {
    }

    public ProductExer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductExer{" +
                "Nome: '" + name + '\'' +
                ", Preço: R$ " + String.format("%.2f", price) +
                '}';
    }
}
