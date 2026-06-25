package Heranca_polimorfismo.heranca.entities;

//SUPERCLASSE/MÃE
public class Account {
    private Integer number;
    private String holder;
          /*
        PRIVATE
        → Acesso totalmente restrito.
        → Só pode ser acessado dentro da própria classe em que foi declarado.
        → Nem subclasses conseguem acessar diretamente.

        PROTECTED
        → Acesso restrito, mas menos fechado que private.
        → Pode ser acessado:
           1. Dentro da própria classe;
           2. Por classes do mesmo package;
           3. Por subclasses, mesmo que estejam em outro package.

        Exemplo:

        class Account {

            private Double balance;
            protected Double loanLimit;
        }

        class BusinessAccount extends Account {

            public void example() {

                // balance = 100.0;
                // ❌ Não pode acessar diretamente, pois balance é private.

                loanLimit = 1000.0;
                // ✔ Pode acessar, pois loanLimit é protected.
            }
        }
        */

    protected Double balance; //saldo

    public Account() {super();}

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    //Metodos, operação de saque
    public boolean withdraw(Double amount) {
        // Exemplo: se na mãe desconta taxa de 5.0, a validação muda um pouco
        if (this.balance >= amount + 5.0) {
            this.balance -= (amount + 5.0);
            return true;
        }
        return false;
    }
    //Metodos, operação de deposito
    public void deposit(Double amount) {
        this.balance += amount;
    }

}
