package interfaces.defaultMethods.model.services;

public class UsaInterestService implements InterestService {

    private double interestRate; // Interest rate

    public UsaInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    /*
     * This class implements the InterestService interface,
     * so it inherits the default payment() method.
     *
     * Instead of implementing the payment calculation again,
     * it only provides its own interest rate through the
     * getInterestRate() method.
     *
     * This promotes code reuse, avoids duplication, and makes
     * maintenance easier because the payment logic is defined
     * only once in the interface.
     */
    @Override
    public double getInterestRate() {
        return interestRate;
    }
}