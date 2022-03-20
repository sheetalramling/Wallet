import org.junit.jupiter.api.Test;
import java.util.Currency;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;


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

        assertThat(Wallet.minBalance, is(equalTo(new_balance)));

    }


    @Test
    void ShouldDebitFromWallet() throws InsufficientBalanceException {
        Money thirtyFiveRupees = new Money(35, Currency.getInstance("INR"));
        Wallet moneyToBeDebited = new Wallet(thirtyFiveRupees );

        double new_balance = moneyToBeDebited.debitAmountFromWallet();

        assertThat(Wallet.minBalance, is(equalTo(new_balance)));

    }

}