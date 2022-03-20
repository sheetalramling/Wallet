public class Wallet {
    Money money;
    static double balance = 0;

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

}
