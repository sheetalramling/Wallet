import exceptions.InsufficientBalanceException;
import exceptions.InvalidMoneyException;
import org.junit.jupiter.api.Test;
import wallet.Money;
import wallet.Wallet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static wallet.Currencies.*;

public class WalletTest {

    @Test
    void zeroBalance() {
        Wallet wallet = new Wallet();
        Money money = new Money(10, INR);

        assertThrows(InsufficientBalanceException.class, () -> wallet.takeMoney(money));
    }

    @Test
    void shouldEquate74Point85ToOneDollar() {
        Money seventyFourPointEightRiveRupees = new Money(74.85, INR);
        Money oneDollar = new Money(1, USD);

        assertThat(seventyFourPointEightRiveRupees, is(equalTo(oneDollar)));
    }

    @Test
    void shouldEquateOneDollarTo74Point85() {
        Money seventyFourPointEightRiveRupees = new Money(74.85, INR);
        Money oneDollar = new Money(1, USD);

        assertThat(oneDollar, is(equalTo(seventyFourPointEightRiveRupees)));
    }


    @Test
    void shouldThrowInvalidMoneyException() throws InvalidMoneyException {
        Money minusThirtyFiveRupees = new Money(-35, INR);
        Wallet wallet = new Wallet();

        assertThrows(InvalidMoneyException.class, () -> wallet.addMoney(minusThirtyFiveRupees));

    }

    @Test
    void shouldAddMoneyInRupees() throws InvalidMoneyException {
        Wallet wallet = new Wallet();
        Money thirtyFiveRupees = new Money(35, INR);
        wallet.addMoney(thirtyFiveRupees);
        Money tenRupees = new Money(10, INR);
        wallet.addMoney(tenRupees);

        assertEquals(45, wallet.walletBalance());
    }

    @Test
    void shouldAddMoneyInDollars() throws InvalidMoneyException {
        Wallet wallet = new Wallet();
        Money oneDollar = new Money(1, USD);
        wallet.addMoney(oneDollar);

        assertEquals(1, wallet.walletBalance());
    }

    @Test
    void shouldTakeMoneyInRupees() throws InsufficientBalanceException, InvalidMoneyException {
        Wallet wallet = new Wallet();
        Money thirtyFiveRupees = new Money(35, INR);
        wallet.addMoney(thirtyFiveRupees);
        Money fiveRupees = new Money(5, INR);

        wallet.takeMoney(fiveRupees);

        assertEquals(30, wallet.walletBalance());
    }

    @Test
    void shouldTakeMoneyInDollars() throws InvalidMoneyException, InsufficientBalanceException {
        Wallet wallet = new Wallet();
        Money threeDollar = new Money(3, USD);
        wallet.addMoney(threeDollar);
        Money oneDollar = new Money(1, USD);
        wallet.takeMoney(oneDollar);

        assertEquals(2, wallet.walletBalance());
    }

    @Test
    void shouldThrowInsufficientBalance() throws InsufficientBalanceException, InvalidMoneyException {
        Wallet wallet = new Wallet();
        Money thirtyFiveRupees = new Money(35, INR);
        wallet.addMoney(thirtyFiveRupees);
        Money fortyFiveRupees = new Money(45, INR);


        assertThrows(InsufficientBalanceException.class, () -> wallet.takeMoney(fortyFiveRupees));
    }

    @Test
    void shouldGiveMoneyInPreferredCurrency() throws InvalidMoneyException {
        Wallet wallet = new Wallet();
        Money fiftyRupees = new Money(50, INR);
        wallet.addMoney(fiftyRupees);
        Money oneDollar = new Money(1, USD);
        wallet.addMoney(oneDollar);

        double moneyInPreferredCurrency = wallet.checkBalanceInPreferredCurrency(INR);

        assertEquals(124.85, moneyInPreferredCurrency);
    }

    @Test
    void shouldGiveMoneyInPreferredCurrencyForThreeMoneys() throws InvalidMoneyException {
        Wallet wallet = new Wallet();
        Money seventyFourPointEightFive = new Money(74.85, INR);
        wallet.addMoney(seventyFourPointEightFive);
        Money oneDollar = new Money(1, USD);
        wallet.addMoney(oneDollar);
        Money hundredAndFortyNinePointSeven = new Money(149.7, INR);
        wallet.addMoney(hundredAndFortyNinePointSeven);

        double moneyInPreferredCurrency = wallet.checkBalanceInPreferredCurrency(USD);

        assertEquals(4, moneyInPreferredCurrency);
    }
}




