package Heranca_polimorfismo.classes_abstratas.entities;

import Heranca_polimorfismo.heranca.entities.Account;

public class SavingsAccountAbs extends AccountAbs {
    private Double interestRate;//taxa de juros
    public SavingsAccountAbs() {}

    public SavingsAccountAbs(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
    public void updateBalance() {
        balance += balance * interestRate;//calculo da taxa de juros
    }

    //sobrescrevendo o método withdraw existente na classe Account
    //@Override=> indica para o compilador que esta sobrescrevendo
    // um método da superclasse. Se houver algum erro, o compilador avisará.
    // @Override //compilador procura esse método na superclasse, se não encontrar, ele avisa que não é uma sobrescrita
    // Sobrescrito o método withdraw na classe SavingsAccount
    @Override
    public boolean withdraw(Double amount) { // Mudou de void para boolean
        if (this.balance >= amount) {
            this.balance -= amount;
            return true; // Saque deu certo!
        } else {
            System.out.println(">>> OPERAÇÃO NEGADA: Saldo insuficiente na Poupança! <<<");
            return false; // Saque falhou!
        }
    }

    @Override
    public void deposit(Double amount) {
        super.deposit(amount); // Executa a lógica padrão da classe Account
        // Você poderia adicionar algo exclusivo da poupança aqui se quisesse, como um bônus:
        // this.balance += amount * interestRate;
    }
}
