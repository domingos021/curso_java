package Banco;

public class BancoClass {
    // Atributos privados e protegidos
    private final String conta; // Excelente uso do final para imutabilidade!
    private String nome;
    private double saldo;

    // Atributos para o resumo do fim do dia
    private double totalDepositos;
    private double totalSaques;
    private double totalTaxas;  // Vai guardar APENAS o acumulado das taxas de 5%

    // =========================================================================
    // CONSTRUTORES PRESERVADOS (Sobrecarga Inteligente)
    // =========================================================================

    // Construtor 1: Conta que já nasce com um depósito inicial
    public BancoClass(String conta, String nome, double depositoInicial) {
        this.conta = conta;
        this.nome = nome;
        this.saldo = depositoInicial;
        this.totalDepositos = depositoInicial; // O depósito inicial já conta no histórico!
        this.totalSaques = 0.0;
        this.totalTaxas = 0.0;
    }

    // Construtor 2: Conta que nasce com saldo zerado
    public BancoClass(String conta, String nome) {
        //alimentados pelo main via entrada next()
        this.conta = conta;
        this.nome = nome;

        //os atributos abaixo são preenchido internamente via metodo
        this.saldo = 0.0;
        this.totalDepositos = 0.0;
        this.totalSaques = 0.0;
        this.totalTaxas = 0.0;

    }

    // =========================================================================
    // GETTERS (Interface Pública de Leitura)
    // =========================================================================
    public String getConta() { return conta; }
    public String getNome() { return nome; }
    public double getSaldo() { return saldo; }
    public double getTotalDepositos() { return totalDepositos; }
    public double getTotalSaques() { return totalSaques; }
    public double getTotalTaxas() { return totalTaxas; }

    // =========================================================================
    // SETTERS SELETIVOS
    // =========================================================================
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }

    // =========================================================================
    // MÉTODOS DE NEGÓCIO (Alteram e acumulam os dados na Heap)
    // =========================================================================
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.totalDepositos += valor; // Alimenta o relatório
        }
    }

    public double sacar(double valor) { // Mudamos de void para double
        if (valor > 0) {
            double percentualTaxa = 0.05;
            double valorDaTaxa = valor * percentualTaxa;

            this.saldo -= (valor + valorDaTaxa);
            this.totalSaques += valor;
            this.totalTaxas += valorDaTaxa;

            return valorDaTaxa; // <--- A classe joga o valor da taxa de volta para a Main
            //retona o valor da taxa no mesmo comando que trouxe o valor para ser calculado aqui
        }
        return 0.0; // Se o valor for inválido, a taxa é zero
    }

    // =========================================================================
    // MÉTODO TOSTRING (Corrigido para o contexto do Banco)
    // =========================================================================
    @Override
    public String toString() {
        return "\n========================================="
                + "\n       RESUMO DAS OPERAÇÕES DO DIA       "
                + "\n========================================="
                + "\nConta Corrente : " + conta
                + "\nTitular        : " + nome
                + "\n-----------------------------------------"
                + "\n(+) Total de Depósitos : $ " + String.format("%.2f", totalDepositos)
                + "\n(+) TAXA DE SERVIÇO    : $ " + String.format("%.2f", totalTaxas)
                + "\n(-) Total de Saídas    : $ " + String.format("%.2f", totalSaques)
                + "\n-----------------------------------------"
                + "\n(=) SALDO FINAL NA HEAP: $ " + String.format("%.2f", saldo)
                + "\n=========================================";
    }
}