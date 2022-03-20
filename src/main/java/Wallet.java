public class Wallet {
    Money money;
    static double minBalance = 100;

    public Wallet(Money money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet that = (Wallet) o;

        if (money.currency.getCurrencyCode().equals("INR"))
            money.amount = money.RupeeToDollarConverter();
        if (money.currency.getCurrencyCode().equals("USD"))
            money.amount = money.DollarToRupeeConverter();

        return money.amount == that.money.amount;

    }

    public double creditAmountToWallet(){
        if(money.amount>0)
        minBalance = minBalance +money.amount;
        return minBalance;
    }

    public double debitAmountFromWallet() throws InsufficientBalanceException {
        if(minBalance ==0.0)
            throw new InsufficientBalanceException("No Sufficient Balance");
        minBalance = minBalance -money.amount;
        return minBalance;
    }

}
