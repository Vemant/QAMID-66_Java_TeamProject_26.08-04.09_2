package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    // ТЕСТЫ КОНСТРУКТОРА
    // Balance < -Limit; IllegalArgumentException
    @Test
    public void constructorBalanceIsLessThanNegativeLimit() {
        int exceptionCounter = 0; // счётчик ошибки
        try {
            CreditAccount account = new CreditAccount(
                    -10_000,
                    5_000,
                    15
            );
            exceptionCounter++; // если конструктор создался успешно счётчик равен 1
        } catch (IllegalArgumentException e) {
            exceptionCounter--; // если вывелась ошибка IllegalArgumentException, счёьчик равен -1
        }

        int expected = -1;
        int actual = exceptionCounter;

        Assertions.assertEquals(expected, actual);
    }

    // Balance = -Limit; IllegalArgumentException
    @Test
    public void constructorBalanceIsEqualNegativeLimit() {
        int exceptionCounter = 0; // счётчик ошибки
        try {
            CreditAccount account = new CreditAccount(
                    -5_000,
                    5_000,
                    15
            );
            exceptionCounter++; // если конструктор создался успешно счётчик равен 1
        } catch (IllegalArgumentException e) {
            exceptionCounter--; // если вывелась ошибка IllegalArgumentException, счёьчик равен -1
        }

        int expected = -1;
        int actual = exceptionCounter;

        Assertions.assertEquals(expected, actual);

    }

    // Limit < 0; IllegalArgumentException
    @Test
    public void constructorLimitIsNegative() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(
                    5_000,
                    -5_000,
                    15
            );
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }

        int expected = -1;
        int actual = exceptionCounter;

        Assertions.assertEquals(expected, actual);

    }

    // Limit = 0; IllegalArgumentException
    @Test
    public void constructorLimitIsEqualZero() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(
                    5_000,
                    0,
                    15
            );
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }

        int expected = -1;
        int actual = exceptionCounter;

        Assertions.assertEquals(expected, actual);
    }

    // Rate < 0; IllegalArgumentException
    @Test
    public void constructorRateIsNegative() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    -15
            );
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }

        int expected = -1;
        int actual = exceptionCounter;

        Assertions.assertEquals(expected, actual);
    }

    // Rate = 0; IllegalArgumentException
    @Test
    public void constructorRateIsEqualZero() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    0
            );
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }

        int expected = -1;
        int actual = exceptionCounter;

        Assertions.assertEquals(expected, actual);
    }

    // Корректные данные для конструктора
    @Test
    public void shouldCreateCreditAccountWithCorrectValues() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    15
            );
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }

        int expected = 1;
        int actual = exceptionCounter;

        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ pay
    // amount < 0; false
    @Test
    public void payAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(-6_000);

        Assertions.assertEquals(expected, actual);
    }

    // amount = 0; false
    @Test
    public void payAmountIsZero() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    // Balance > 0; Amount < CreditLimit + Balance; return true
    @Test
    public void payBalanceIsPositiveAmountIsLessThanLimitPlusBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        boolean expected = true;
        boolean actual = account.pay(2_000);

        Assertions.assertEquals(expected, actual);
    }

    // Balance > 0; Amount = CreditLimit + Balance; return true
    @Test
    public void payBalanceIsPositiveAmountIsEqualLimitPlusBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        boolean expected = true;
        boolean actual = account.pay(8_000);

        Assertions.assertEquals(expected, actual);
    }

    // Balance > 0; Amount > CreditLimit + Balance; return false
    @Test
    public void payBalanceIsPositiveAmountIsMoreThanLimitPlusBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(10_000);

        Assertions.assertEquals(expected, actual);
    }

    // Balance = 0; Amount < CreditLimit; return true
    @Test
    public void payBalanceIsZeroAmountIsLessThanLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = true;
        boolean actual = account.pay(2_000);

        Assertions.assertEquals(expected, actual);
    }

    // Balance = 0; Amount = CreditLimit; return true
    @Test
    public void payBalanceIsZeroAmountIsEqualLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = true;
        boolean actual = account.pay(5_000);

        Assertions.assertEquals(expected, actual);
    }

    // Balance = 0; Amount > CreditLimit; return false
    @Test
    public void payBalanceIsZeroAmountIsMoreThanLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(10_000);

        Assertions.assertEquals(expected, actual);
    }

    // Balance < 0; Amount < CreditLimit + Balance; return true
    @Test
    public void payBalanceIsNegativeAmountIsLessThanLimitMinusBalance() {
        CreditAccount account = new CreditAccount(
                -3_000,
                5_000,
                15
        );

        boolean expected = true;
        boolean actual = account.pay(1_000);

        Assertions.assertEquals(expected, actual);
    }

    // Balance < 0; Amount = CreditLimit + Balance; return true
    @Test
    public void payBalanceIsNegativeAmountIsEqualThanLimitMinusBalance() {
        CreditAccount account = new CreditAccount(
                -3_000,
                5_000,
                15
        );

        boolean expected = true;
        boolean actual = account.pay(2_000);

        Assertions.assertEquals(expected, actual);
    }

    // Balance < 0; Amount > CreditLimit + Balance; return false
    @Test
    public void payBalanceIsNegativeAmountIsMoreThanLimitMinusBalance() {
        CreditAccount account = new CreditAccount(
                -3_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(4_000);

        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ add
    // Amount > 0; return true
    @Test
    public void addAmountIsPositive() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = true;
        boolean actual = account.add(3_000);

        Assertions.assertEquals(expected, actual);
    }

    // Amount = 0; return false
    @Test
    public void addAmountIsZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);
    }

    // Amount < 0; return false
    @Test
    public void addAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.add(-1_000);

        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ yearChange
    // Balance > 0; return 0
    @Test
    public void yearChangeBalanceIsPositive() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    // Balance = 0; return 0
    @Test
    public void yearChangeBalanceIsZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    // Balance < 0; return по формуле метода
    @Test
    public void yearChangeBalanceIsNegative() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        int expected = account.balance * account.rate / 100;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

}

