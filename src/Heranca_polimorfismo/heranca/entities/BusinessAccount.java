package Heranca_polimorfismo.heranca.entities;

// BusinessAccount herda atributos e métodos de Account
public class BusinessAccount extends Account {

    // Além de herdar, também pode possuir atributos e métodos próprios.
    // Nesse caso, o BusinessAccount tem 4 dados no total: 3 herdados da classe Account e um dado próprio, o loanLimit, criado internamente na classe.
    private Double loanLimit;

    //SUBCLASSE DE ACCOUNT
    public BusinessAccount() {
        super(); // Boa prática: chama o construtor padrão da classe mãe (Account)
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        /*
          A palavra-chave 'super' serve para reutilizar a lógica de inicialização da Superclasse.
          Em vez de você reescrever "this.number = number", você delega para quem já sabe fazer isso (Account).
        */
        super(number, holder, balance); // Chamando o construtor da superClass, no caso Account
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    //deposit(amount); //empréstimo, valor entra na conta por meio de um deposito
    //Metodo para operação de emprestimo
    public void loan(double amount) {
        //verifica se o valor do emprestimo e menor ou igual ao limite de emprestimo
        if (amount <= loanLimit) {
            balance += amount - 1; //aplica uma taxa de 1 real sobre o emprestimo}
        } else {
            System.out.println("Loan amount exceeds the limit.");
        }

    }
}

/*
Upcasting
Castingo da subclasse para superclasse (subindo para superclass
 Uso comum : polimorfismo

 DownCasting
 Casting da Superclasse para subclasse(descendo para subclasse)
 Palavra: instanceof
 Uso comum:metodos que recebem parametros genericos(ex:equals)

 */