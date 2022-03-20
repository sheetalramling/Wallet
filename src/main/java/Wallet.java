import java.util.Currency;

public class Wallet {
    Money money;
    Money[] moneyInMultipleCurrencies;
    static double balance ;
    static double moneyInOtherCurrency;
    static double moneyInPreferredCurrency;

    public Wallet(Money money) {
        this.money = money;

    }

    public Wallet(Money[] moneyInMultipleCurrencies) {
        this.moneyInMultipleCurrencies = moneyInMultipleCurrencies;
    }

    public double checkBalance(Money[] moneyInMultipleCurrencies, Currency preferredCurrency) {

        for (Money money : moneyInMultipleCurrencies) {

            if (money.currency.getCurrencyCode().equals(preferredCurrency.getCurrencyCode())) {
                moneyInPreferredCurrency = money.amount;

            } else {
                if (money.currency.getCurrencyCode().equals("USD")) {
                    moneyInOtherCurrency = money.dollarToRupeeConverter();
                }
                if (money.currency.getCurrencyCode().equals("INR")) {
                    moneyInOtherCurrency = money.rupeeToDollarConverter();
                }
            }

            moneyInPreferredCurrency = moneyInPreferredCurrency + moneyInOtherCurrency;
        }

        return moneyInPreferredCurrency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet that = (Wallet) o;

        if (money.currency.getCurrencyCode().equals("INR")) money.amount = money.rupeeToDollarConverter();
        if (money.currency.getCurrencyCode().equals("USD")) money.amount = money.dollarToRupeeConverter();

        return money.amount == that.money.amount;

    }

    public double addMoneyToWallet() {
        if (money.amount > 0) balance = balance + money.amount;
        return balance;
    }

    public double takeMoneyFromWallet() throws InsufficientBalanceException {
        if (balance == 0.0) throw new InsufficientBalanceException("No Sufficient Balance");
        balance = balance - money.amount;
        return balance;
    }

}
