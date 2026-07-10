package interfaces.exercFixacao.model.sevices;

public class PaypalService implements OnlinePaimentService {

    // Taxa de pagamento padrão de 2%
    private static final double FEE_PERCENTAGE = 0.02;

    // Juros simples mensal de 1%
    private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public double paymentFee(double amount) {
        // Calcula 2% sobre o valor passado
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double interest(double amount, int months) {
        // Calcula 1% de juros simples multiplicado pela quantidade de meses
        // Exemplo: 1 mês = 1%, 2 meses = 2%, etc.
        return amount * MONTHLY_INTEREST * months;
    }
}