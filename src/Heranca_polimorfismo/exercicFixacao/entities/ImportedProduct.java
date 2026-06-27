package Heranca_polimorfismo.exercicFixacao.entities;

public class ImportedProduct extends ProductSup {
    private Double customsFee; // taxa de importação

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    // Método auxiliar para calcular o preço total (Preço base + Taxa)
    public Double totalPrice() {
        return getPrice() + (getPrice() * customsFee / 100.0);
    }

    @Override
    public String priceTag() {
        return getName()
                + " $ "
                + String.format("%.2f", totalPrice())
                + " (Customs fee: "
                + String.format("%.2f", customsFee)
                + "%)";
    }
}