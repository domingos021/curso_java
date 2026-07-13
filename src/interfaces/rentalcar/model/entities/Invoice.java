package interfaces.rentalcar.model.entities;

public class Invoice  {
    //invoice => fatura
    private Double basicPayment;
    private Double tax; //=>imposto

    public Invoice() {
    }

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public double getTotalPayment() {
        return basicPayment + getTax();
    }
}
