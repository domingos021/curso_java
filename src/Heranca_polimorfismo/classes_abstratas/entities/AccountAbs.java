package Heranca_polimorfismo.classes_abstratas.entities;

/**
 * SUPERCLASSE GENÉRICA (CLASSE MÃE)
 * * ====================================================================================
 * O CONCEITO DE CLASSE ABSTRATA (SEM MÉTODOS ABSTRATOS)
 * ====================================================================================
 * * 1. O QUE SIGNIFICA A PALAVRA 'abstract' AQUI?
 * Significa que esta classe passou a ser um "conceito" dentro do sistema. Ela serve
 * puramente como uma fôrma, um molde seguro para as classes filhas.
 * * 2. QUAL É A TRAVA DE SEGURANÇA? (O QUE NÃO PODEMOS FAZER?)
 * O Java agora PROÍBE terminantemente a instanciação direta desta classe. Se você tentar
 * fazer "new AccountAbs(...)" em qualquer lugar do sistema, o Java vai barrar e dar
 * erro de compilação. Isso impede a criação de uma "conta fantasma/genérica", pois no
 * mundo real toda conta deve ter um tipo (ex: Poupança ou Empresarial).
 * * 3. O QUE AS OUTRAS CLASSES PODEM FAZER? (HERANÇA ATIVA)
 * As classes filhas (BusnessAccountAbs, SavingsAccountAbs) continuam herdando tudo
 * normalmente através do 'extends'. Todos os atributos e métodos estão 100% funcionais
 * e prontos para serem reaproveitados pelas filhas, poupando repetição de código.
 * * 4. O SUPERPODER DO POLIMORFISMO (O REQUISITO DA LISTA):
 * Embora você não possa criar um OBJETO do tipo AccountAbs, você PODE usar AccountAbs
 * como um TIPO de variável ou coleção. É isso que permite criar, por exemplo, uma
 * "List<AccountAbs>" contendo variáveis genéricas da mãe que apontam para os objetos
 * reais das classes filhas. Quando os métodos forem chamados, o Java executará o
 * comportamento específico de cada filha (Modo Polimórfico).
 * ====================================================================================
 */
public abstract class AccountAbs {

    private Integer number;
    private String holder;
    protected Double balance; // protected: permite acesso direto apenas às classes filhas

    // Construtor padrão
    public AccountAbs() {
    }

    // Construtor com argumentos
    public AccountAbs(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    // --- GETTERS E SETTERS ---

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

    // --- MÉTODOS DA CONTA (MÉTODOS COMUNS / CONCRETOS) ---

    /**
     * Realiza um depósito somando o valor diretamente ao saldo.
     */
    public void deposit(Double amount) {
        balance += amount;
    }

    /**
     * Realiza um saque aplicando uma taxa padrão de R$ 5.00.
     * Este método tem corpo e lógica ativa. Ele funciona perfeitamente para as contas
     * padrão, mas será sobrescrito (@Override) na Conta Poupança para ignorar essa taxa.
     */
    public boolean withdraw(Double amount) {
        if (balance >= amount + 5.0) {
            balance -= (amount + 5.0);
            return true; // Saque permitido e realizado
        }
        return false; // Saldo insuficiente para o saque + taxa
    }
}