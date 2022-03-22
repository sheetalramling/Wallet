import org.junit.jupiter.api.Test;

import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class WalletTest {
    @Test
    void shouldEquate74Point85ToOneDollar() {
        Money seventyFourPointEightRiveRupees = new Money(74.85, Currency.getInstance("INR"));
        Money oneDollar = new Money(1, Currency.getInstance("USD"));

        assertThat(seventyFourPointEightRiveRupees, is(equalTo(oneDollar)));

    }

    @Test
    void shouldEquateOneDollarTo74Point85() {
        Money seventyFourPointEightRiveRupees = new Money(74.85, Currency.getInstance("INR"));
        Money oneDollar = new Money(1, Currency.getInstance("USD"));

        assertThat(oneDollar, is(equalTo(seventyFourPointEightRiveRupees)));

    }

    @Test
    void shouldAddMoneyToWallet() {
        Money seventyFourPointEightRiveRupees = new Money(74.85, Currency.getInstance("INR"));
        Wallet moneyToBeCredited = new Wallet(seventyFourPointEightRiveRupees);

        double newBalance = moneyToBeCredited.addMoneyToWallet();

        assertEquals(174.85, newBalance);

    }

    @Test
    void ShouldDebitMoneyFromAccount() throws InsufficientBalanceException {
        Money thirtyFiveRupees = new Money(35, Currency.getInstance("INR"));
        Wallet moneyToBeDebited = new Wallet(thirtyFiveRupees);

        double newBalance = moneyToBeDebited.takeMoneyFromWallet();

        assertEquals(65, newBalance);

    }


    @Test
    void shouldDisplayAmountInPreferredCurrencyForTwoMoneyValues() {
        Money[] moneyInDifferentCurrencies = {new Money(50, Currency.getInstance("INR")), new Money(1, Currency.getInstance("USD"))};
        Wallet multipleCurrencies = new Wallet(moneyInDifferentCurrencies);

        double totalAmount = multipleCurrencies.checkBalanceInPreferredCurrency(moneyInDifferentCurrencies, Currency.getInstance("INR"));

        assertEquals(124.85, totalAmount);

    }

    @Test
    void shouldDisplayAmountInPreferredCurrencyForThreeMoneyValues() {
        Money[] moneyInDifferentCurrencies={new Money(74.85,Currency.getInstance("INR")),new Money(1,Currency.getInstance("USD")), new Money(149.7,Currency.getInstance("INR"))};
        Wallet multipleCurrencies=new Wallet(moneyInDifferentCurrencies) ;

        double totalAmount=multipleCurrencies.checkBalanceInPreferredCurrency(moneyInDifferentCurrencies,Currency.getInstance("USD"));

        assertEquals(4,totalAmount);

    }

}