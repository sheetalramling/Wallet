import java.util.Currency;

public class Wallet {
    Money money;
    Money[] moneyInMultipleCurrencies;
    private  double balance = 100;
    private static double moneyInPreferredCurrency;
    private static double moneyInOtherCurrency;

    public Wallet(Money money) {
        this.money = money;
    }

    public Wallet(Money[] moneyInMultipleCurrencies) {
        this.moneyInMultipleCurrencies = moneyInMultipleCurrencies;
    }

    public double checkBalanceInPreferredCurrency(Money[] moneyInMultipleCurrencies, Currency preferredCurrency) {

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


    public double addMoneyToWallet() {
        if (money.amount > 0)
            if (money.currency.getCurrencyCode().equals("USD"))
                money.amount = money.dollarToRupeeConverter();
        balance = balance + money.amount;
        return balance;
    }

    public double takeMoneyFromWallet() throws InsufficientBalanceException {

        balance = balance - money.amount;
        System.out.println(balance);
        if (balance <= 0)
            throw new InsufficientBalanceException("No Sufficient Balance");
        else
            return balance;
    }

}
