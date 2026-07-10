package interfaces.exercFixacao.model.sevices;

public interface OnlinePaimentService {

    /**
     * Calcula a taxa de pagamento sobre um determinado valor.
     */
    double paymentFee(double amount);

    /**
     * Calcula os juros com base no valor e na quantidade de meses.
     */
    double interest(double amount, int months);
}