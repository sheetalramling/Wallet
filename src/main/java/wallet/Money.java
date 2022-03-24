package wallet;

import static wallet.Currencies.INR;
import static wallet.Currencies.USD;

public class Money {
    private static final double RUPEE = 74.85;
    static double amount;
    static Currencies currency;

    public Money(double amount, Currencies currency) {
        this.currency = Currencies.valueOf(String.valueOf(currency));
        this.amount = amount;
    }

    public static double rupeeToDollarConverter(double amount) {
        return amount / RUPEE;
    }

    public static double dollarToRupeeConverter(double amount) {
        return amount * RUPEE;
    }

    public static boolean inValidMoney() {
        if (amount < 0) return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {

        Money that = (Money) o;

        if (currency.equals(INR)) amount = rupeeToDollarConverter(amount);
        if (currency.equals(USD)) amount = dollarToRupeeConverter(amount);

        return amount == that.amount;

    }


}



