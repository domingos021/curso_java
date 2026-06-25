package utilitarios;

public class CurrencyConverter {

    // Podemos criar uma constante estática para o IOF (6%) para o código ficar mais profissional
    public static final double IOF_PERCENTUAL = 6.0;

    public static double valorDolar(double quantidadeDolares, double cotacao) {
        double valorEmReais = quantidadeDolares * cotacao;
        // Aplica os 6% de IOF
        double iof = valorEmReais * IOF_PERCENTUAL / 100.0;
        return valorEmReais + iof;
    }

    // CORRIGIDO: O relatório não precisa receber o IOF por parâmetro. Ele calcula tudo sozinho!
    public static String gerarRelatorio(double quantidadeDolares, double cotacao) {
        double valorSemImposto = quantidadeDolares * cotacao;
        double valorTotalComIOF = valorDolar(quantidadeDolares, cotacao); // Chama o seu método lá de cima!
        double iofPago = valorTotalComIOF - valorSemImposto; // Descobre o valor do IOF em Reais

        return "============ RESULTADO (ESTÁTICO) ============\n" +
                String.format("QUANTIDADE EM DÓLAR: $ %.2f%n", quantidadeDolares) +
                String.format("COTAÇÃO DO DIA: R$ %.2f%n", cotacao) +
                String.format("VALOR DO IOF (6%%): R$ %.2f%n", iofPago) +
                String.format("VALOR SEM IMPOSTOS DE (R$ %.2f): R$ %.2f%n",iofPago, valorSemImposto) +
                String.format("TOTAL A PAGAR EM REAIS: R$ %.2f%n", valorTotalComIOF) +
                "==============================================";
    }
}