package interfaces.defaultMethods.model.services;

public class BrazilInterestService implements InterestService {

    private double interestRate; // Interest rate

    public BrazilInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    /*
     * This class implements the InterestService interface,
     * so it inherits the default payment() method.
     *
     * As a result, only the interest rate needs to be provided,
     * while the payment calculation is reused from the interface.
     *
     * This avoids code duplication and makes maintenance easier,
     * since changes to the payment calculation are made in only
     * one place: the interface.
     */

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}