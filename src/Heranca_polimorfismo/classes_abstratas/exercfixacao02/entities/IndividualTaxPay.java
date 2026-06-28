package Heranca_polimorfismo.classes_abstratas.exercfixacao02.entities;

public class IndividualTaxPay extends TaxPayes   {
    private Double healthExpenditures; //gastos com a saude

    public IndividualTaxPay() {
        super();
    }

    public IndividualTaxPay(String name, double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }
    @Override
    public double tax() {
        // Inicializa a variável que vai armazenar o valor final do imposto
        double tax = 0.0;

        // PASSO 1: Define a alíquota com base na renda anual
        // Se a renda anual for menor que 20.000, cobra 15% de imposto
        if (getAnualIncome() < 20000.00) {
            tax = getAnualIncome() * 0.15;
        }
        // Caso contrário (renda igual ou maior que 20.000), cobra 25% de imposto
        else {
            tax = getAnualIncome() * 0.25;
        }

        // PASSO 2: Aplica o abatimento de saúde
        // Subtrai do imposto atual 50% do valor gasto com saúde
        tax -= healthExpenditures * 0.50;

        // PASSO 3: Validação de segurança
        // Math.max compara o imposto calculado com 0.0 e retorna o maior deles.
        // Isso garante que, se o desconto de saúde for maior que o imposto,
        // o resultado final seja 0.0 em vez de um número negativo.
        return Math.max(tax, 0.0);
    }
}
