import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    @Test
    void checkForEquality() {
        Wallet Rupees = Wallet.rupees(74.85);
        Wallet Dollar = Wallet.dollar(1);

        assertThat(Rupees, is((equalTo(Dollar))));

    }

    @Test
    void checkForEquality2() {
        Wallet Rupees = Wallet.rupees(74.85);
        Wallet Dollar = Wallet.dollar(1);

        assertThat(Dollar, is((equalTo(Rupees))));

    }

    @Test
    void checkForEquality3() {
        Wallet Dollar = Wallet.dollar(2);
        Wallet Dollar2 = Wallet.dollar(2);

        assertThat(Dollar, is((equalTo(Dollar2))));

    }


    // put  money in wallet
    @Test
    void putMoneyInWallet()
    {
        Wallet Ruppes = Wallet.rupees(50);
        Wallet Dollar2 = Wallet.dollar(1);
        Wallet Rupees = Wallet.rupees(124.85);

        assertThat(Rupees, is((equalTo( Ruppes.putMoney(Dollar2)))));
   }

    @Test
    void takeMoneyOut() {

        Wallet Ruppes = Wallet.rupees(50);
        Wallet Dollar2 = Wallet.dollar(1);
        Wallet Rupees = Wallet.rupees(124.85);

        assertThat(Rupees, is((equalTo( Ruppes.putMoney(Dollar2)))));
    }
    

    @Test
    void test4 () {

        Wallet Dollar = Wallet.dollar(1);
        Wallet rupees = Wallet.rupees(74.85);

        Wallet firstfinalDollar = Dollar.putMoney(rupees);
        System.out.println("firstfinalDollar "+firstfinalDollar.toString());

        Wallet rupees2 = Wallet.rupees(149.7);

        Wallet finalDollar = Wallet.dollar(4);
        assertThat(finalDollar, is((equalTo( firstfinalDollar.putMoney(rupees2)))));

    }

    @Test
    void removeMoneyFromWallet() throws Exception {
        Wallet twodollar = Wallet.dollar(2);
        Wallet oneRupess = Wallet.rupees(74.85);
        
        Wallet resultamunt = Wallet.dollar(1);

        assertThat(resultamunt, is((equalTo( twodollar.take(oneRupess)))));

    }

    @Test
    void sufficient() throws Exception {
        Wallet twodollar = Wallet.dollar(1);
        Wallet oneRupess = Wallet.rupees(100);


        assertThrows(Exception.class, () -> twodollar.take(oneRupess));

    }

    @Test
    void sufficientRS() throws Exception {
        Wallet Rs200 = Wallet.rupees(200);
        Wallet Rs500 = Wallet.rupees(500);

        assertThrows(Exception.class, () -> Rs200.take(Rs500));
    }
}
