package Heranca_polimorfismo.classes_abstratas.exercfixacao02.entities;

public class CompanyTaxes extends TaxPayes {
    private Integer numberOfEmployees;

    public CompanyTaxes() {
        super();
    }

    public CompanyTaxes(String name, double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;

    }

    @Override
    public double tax() {
        // Inicializa a variável do imposto
        double tax = 0.0;

        // PASSO 1: Verifica o número de funcionários para definir a alíquota
        // Se a empresa tiver mais de 10 funcionários, a alíquota cai para 14% (0.14)
        if (getNumberOfEmployees() > 10) {
            tax = getAnualIncome() * 0.14;
        }
        // Caso contrário (10 funcionários ou menos), a alíquota é de 16% (0.16)
        else {
            tax = getAnualIncome() * 0.16;
        }

        // Retorna o valor do imposto calculado
        return tax;
    }
}


    /*
                   TaxPayes (abstrata)
                  -----------------------
                  - name
                  - anualIncome
                  -----------------------
                  + tax() (abstrato)
                         ▲
             ┌───────────┴───────────┐
             │                       │
             │                       │
    IndividualTaxPay         CompanyTaxes
     */