package interfaces.defaultMethods.model.services;
import java.security.InvalidParameterException;

public interface InterestService {

    double getInterestRate();   // Abstract method

    default double payment(double amount, int months) { // Default method
        if (months < 1) {
            throw new InvalidParameterException("Months must be greater than zero");
        }
        return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
    }
}
