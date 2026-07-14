package interfaces.defaultMethods.model.services;

import java.security.InvalidParameterException;

public interface InterestService {

    //method that return the interestRate
    double getInterestRate();   // Abstract method
    //interface não pode ter construtor

    /*
     * Default method shared by all implementations of this interface.
     *
     * Instead of forcing every class to implement the same payment()
     * logic, the interface provides a single reusable implementation.
     *
     * The calculation depends on getInterestRate(), which is implemented
     * by each class to provide its own interest rate.
     */
    // methods that returns the calculation
    default double payment(double amount, int months) { // Default method
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
        return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
    }
}