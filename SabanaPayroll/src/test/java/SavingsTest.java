import entities.Savings;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class SavingsTest {

    @Test
    public void shouldGetDepositDiscount() {
        Savings account = new Savings();

        assertTrue(Double.compare(2000, account.getDepositDiscount()) == 0);
    }

    @Test
    public void shouldDepositAmount() {
        Savings account = new Savings();
        boolean result = account.deposit(10000);

        assertTrue(result);
        assertTrue(Double.compare(8000, account.getBalance()) == 0);
    }

    @Test
    public void shouldNotDepositAmount() {
        Savings account = new Savings();

        assertFalse(account.deposit(1000));
        assertFalse(account.deposit(500));
        assertTrue(Double.compare(0, account.getBalance()) == 0);
    }

    @Test
    public void shouldDepositMonthlyInterests() throws Exception {
        Savings account = new Savings();

        assertTrue(account.deposit(4000));

        assertEquals(20,account.depositMontlyInterest());
        assertEquals(2020,account.getBalance());
    }

    @Test
    public void shouldKeepBalance() throws Exception {
        Savings account = new Savings();

        assertTrue(account.deposit(11000)); //9000
        assertFalse(account.deposit(1000));
        assertFalse(account.deposit(500));
        assertTrue(account.deposit(21000)); // 19000


        assertTrue(Double.compare(28000, account.getBalance()) == 0);
        assertEquals(280,account.depositMontlyInterest());
        assertEquals(28280,account.getBalance());
    }

}
