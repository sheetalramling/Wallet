package wallet;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidMoneyException;

import static wallet.Currencies.INR;
import static wallet.Currencies.USD;
import static wallet.Money.*;

public class Wallet {

    private double balance = 0;
    private double balanceInRupees = 0;
    private double balanceInDollars = 0;

    public double walletBalance() {
        return balance;
    }

    public void addMoney(Money money) throws InvalidMoneyException {
        if (inValidMoney()) {
            throw new InvalidMoneyException("Invalid Money Value");
        }
        if (money.currency.equals(INR)) {
            balanceInRupees += amount;
            balance = balanceInRupees;
        }
        if (currency.equals(USD)) {
            balanceInDollars += amount;
            balance = balanceInDollars;
        }
    }

    public void takeMoney(Money money) throws InsufficientBalanceException {
        if (balance < amount || balance ==0) throw new InsufficientBalanceException("No Sufficient Balance");

        if (currency.equals(INR)) {
            balanceInRupees -= amount;
            balance = balanceInRupees;
        }
        if (currency.equals(USD)) {
            balanceInDollars -= amount;
            balance = balanceInDollars;
        }
    }


    public double checkBalanceInPreferredCurrency(Currencies preferredCurrency) {
        if (preferredCurrency.equals(INR))
            balance = balanceInRupees + dollarToRupeeConverter(balanceInDollars);
        if (preferredCurrency.equals(USD))
            balance = rupeeToDollarConverter(balanceInRupees) + balanceInDollars;
        return balance;
    }
}

