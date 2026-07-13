package interfaces.defaultMethods.model.services;


import java.security.InvalidParameterException;

public class UsaInterestService {

    private  double interestRate; //taxa de juros

    public UsaInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    /*
     * This class does not implement the InterestService interface,
     * so it cannot inherit the default payment() method.
     *
     * As a result, the payment() method must be implemented again here,
     * duplicating the same logic.
     *
     * If many classes need the same payment calculation, this approach
     * leads to code duplication and makes maintenance harder, because
     * any change to the calculation must be repeated in every class.
     */

    public double payment(double amount, int months) { // Default method
        if (months < 1) {
            throw new InvalidParameterException("Months must be greater than zero");
        }

        /*
         * Compound interest formula:
         *
         * payment = amount * (1 + interestRate / 100)^months
         *
         * Math.pow(base, exponent) calculates the exponentiation.
         */
        return amount * Math.pow(1.0 + interestRate / 100.0, months);
    }

    /*

    @Override
    public double getInterestRate() {
        return interestRate;
    }

     */
}
