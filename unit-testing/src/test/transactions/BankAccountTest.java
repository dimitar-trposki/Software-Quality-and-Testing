package test.transactions;

import main.transactions.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(100.0);
    }

    @Test
    void testGetBalance() {
        Assertions.assertEquals(100.0, bankAccount.getBalance(), "Initial balance should be 100.0");
    }

    @Test
    void testDepositValidAmount() {
        bankAccount.deposit(50.0);
        Assertions.assertEquals(150.0, bankAccount.getBalance(), "After depositing 50.0, balance should be 150.0");
    }

    @Test
    void testDepositNegativeAmountThrowsExceptionType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-10.0));
    }

    @Test
    void testDepositNegativeAmountThrowsExceptionMessage() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-10.0));
        Assertions.assertEquals("Deposit must be positive", exception.getMessage());
    }

    @Test
    void testWithdrawalValidAmount() {
        bankAccount.withdraw(30.0);
        Assertions.assertEquals(70.0, bankAccount.getBalance(), "After withdrawing 30.0, balance should be 70.0");
    }

    @Test
    void testWithdrawalNegativeAmountThrowsExceptionMessage() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-10.0));
        Assertions.assertEquals("Withdraw must be positive", exception.getMessage());
    }

    @Test
    void testWithdrawInsufficientFundsThrowsExceptionType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(200.0));
    }

    @Test
    void testWithdrawInsufficientFundsThrowsExceptionMessage() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(200.0));
        Assertions.assertEquals("Insufficient funds.", exception.getMessage());
    }
}
