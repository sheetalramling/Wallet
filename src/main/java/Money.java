import java.util.Currency;

public class Money {
    static final double RUPEE = 74.85;
    double amount;
    Currency currency;

    public Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public double RupeeToDollarConverter() {

        double convertedAmount = amount / RUPEE;
        return convertedAmount;
    }

    public double DollarToRupeeConverter() {

        double convertedAmount = amount * RUPEE;
        return convertedAmount;
    }


}
