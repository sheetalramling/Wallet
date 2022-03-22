import java.util.Currency;

public class Money {
    static private final double RUPEE = 74.85;
    double amount;
    Currency currency;

    public Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public double rupeeToDollarConverter() {
        return amount / RUPEE;
    }

    public double dollarToRupeeConverter() {
        return amount * RUPEE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money that = (Money) o;

        if (currency.getCurrencyCode().equals("INR")) amount = rupeeToDollarConverter();
        if (currency.getCurrencyCode().equals("USD")) amount = dollarToRupeeConverter();

        return amount == that.amount;

    }
}
