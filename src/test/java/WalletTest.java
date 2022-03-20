import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Currency;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void ShouldEquate74Point85ToOneDollar() {

        Wallet seventyFourPointEightRiveRupees = new Wallet(new Money(74.85, Currency.getInstance("INR")));
        Wallet oneDollar = new Wallet(new Money(1, Currency.getInstance("USD")));

        assertThat(seventyFourPointEightRiveRupees, is(equalTo(oneDollar)));

    }

    @Test
    void ShouldEquateOneDollarTo74Point85() {

        Wallet seventyFourPointEightRiveRupees = new Wallet(new Money(74.85, Currency.getInstance("INR")));
        Wallet oneDollar = new Wallet(new Money(1, Currency.getInstance("USD")));

        assertThat(oneDollar, is(equalTo(seventyFourPointEightRiveRupees)));

    }

    @Test
    void ShouldCreditAmountToWallet() {
        Money seventyFourPointEightRiveRupees = new Money(74.85, Currency.getInstance("INR"));
        Wallet moneyToBeCredited = new Wallet(seventyFourPointEightRiveRupees);

        double new_balance = moneyToBeCredited.creditAmountToWallet();

        assertThat(Wallet.balance, is(equalTo(new_balance)));

    }


    @Test
    void ShouldDebitFromWallet() throws InsufficientBalanceException {
        Money thirtyFiveRupees = new Money(35, Currency.getInstance("INR"));
        Wallet moneyToBeDebited = new Wallet(thirtyFiveRupees );

        double new_balance = moneyToBeDebited.debitAmountFromWallet();

        assertThat(Wallet.balance, is(equalTo(new_balance)));




    }
//    @Test
//    void ShouldThrowInsufficientException() throws InsufficientBalanceException {
//        Money thirtyFiveRupees = new Money(35, Currency.getInstance("INR"));
//        Wallet moneyToBeDebited = new Wallet(thirtyFiveRupees);
//
//        assertThrows(InsufficientBalanceException.class, moneyToBeDebited::debitAmountFromWallet);
//
//    }


    @Test
    void ShouldDisplayAmountInPreferredCurrency() {
        Money[] moneyInDifferentCurrencies={new Money(50,Currency.getInstance("INR")),new Money(1,Currency.getInstance("USD"))};
        Wallet multipleCurrencies=new Wallet(moneyInDifferentCurrencies) ;

        double totalAmount=multipleCurrencies.checkBalance(moneyInDifferentCurrencies,Currency.getInstance("INR"));

        assertEquals(124.85,totalAmount);

    }

    @Test
    void ShouldDisplayAmountInPreferredCurrency1() {
        Money[] moneyInDifferentCurrencies={new Money(74.85,Currency.getInstance("INR")),new Money(1,Currency.getInstance("USD")), new Money(149.7,Currency.getInstance("INR"))};
        Wallet multipleCurrencies=new Wallet(moneyInDifferentCurrencies) ;

        double totalAmount=multipleCurrencies.checkBalance(moneyInDifferentCurrencies,Currency.getInstance("USD"));

        assertEquals(4,totalAmount);

    }
}