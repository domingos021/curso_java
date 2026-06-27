package Heranca_polimorfismo.classes_abstratas.entities;

public class BusnessAccountAbs extends AccountAbs {
    private Double loanLimit;


    public BusnessAccountAbs() {
        super();
    }

    public BusnessAccountAbs(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }



    public void loan(double amount) {
        if (amount <= loanLimit) {
            balance += amount - 1;
        } else {
            System.out.println("Loan amount exceeds the limit.");
        }
    }
}
