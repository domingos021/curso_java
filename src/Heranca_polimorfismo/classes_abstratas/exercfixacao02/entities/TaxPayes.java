package Heranca_polimorfismo.classes_abstratas.exercfixacao02.entities;

public abstract class TaxPayes {
   private String name;
   private double anualIncome;

    public TaxPayes() {
    }

    public TaxPayes(String name, double anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnualIncome() {
        return anualIncome;
    }

    public void setAnualIncome(double anualIncome) {
        this.anualIncome = anualIncome;
    }

    public abstract double tax();
}
