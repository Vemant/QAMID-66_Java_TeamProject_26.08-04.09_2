package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    // ТЕСТЫ КОНСТРУКТОРА
    // Корректные данные; true
    @Test
    public void constructorCorrectValues() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    100,
                    900,
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

    // minBalance < 0; false
    @Test
    public void constructorMinBalanceIsNegative() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    -100,
                    900,
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
    // minBalance = 0; false
    @Test
    public void constructorMinBalanceIsZero() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    0,
                    900,
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
    // maxBalance < 0; false
    @Test
    public void constructorMaxBalanceIsNegative() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    100,
                    -900,
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
    // maxBalance = 0; false
    @Test
    public void constructorMaxBalanceIsZero() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    100,
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
    // minBalance > maxBalance; false
    @Test
    public void constructorMinBalanceLessThanMaxBalance() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    500,
                    100,
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
    // minBalance = maxBalance; false
    @Test
    public void constructorMinBalanceEqualMaxBalance() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    500,
                    500,
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
    // initialBalance < 0; false
    @Test
    public void constructorInitialBalanceIsNegative() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    -500,
                    100,
                    900,
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
    // initialBalance = 0; false
    @Test
    public void constructorInitialBalanceIsZero() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    0,
                    100,
                    900,
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
    // initialBalance > maxBalance; false
    @Test
    public void constructorInitialBalanceMoreThanMaxBalance() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    1000,
                    100,
                    900,
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
    // initialBalance = maxBalance; true
    @Test
    public void constructorInitialBalanceEqualMaxBalance() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    900,
                    100,
                    900,
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
    // initialBalance < minBalance; false
    @Test
    public void constructorInitialBalanceLessThanMinBalance() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    50,
                    100,
                    900,
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
    // initialBalance = minBalance; true
    @Test
    public void constructorInitialBalanceEqualMinBalance() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    100,
                    100,
                    900,
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
    // rate < 0; false
    @Test
    public void constructorRateIsNegative() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    100,
                    900,
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
    // rate = 0; false
    @Test
    public void constructorRateIsZero() {
        int exceptionCounter = 0;
        try {
            SavingAccount account = new SavingAccount(
                    500,
                    100,
                    900,
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


    // ТЕСТЫ pay
    // amount < 0; false
    @Test
    public void payAmountIsNegative() {
        SavingAccount account = new SavingAccount(
                500,
                100,
                900,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(-100);

        Assertions.assertEquals(expected, actual);
    }

    // amount = 0; false
    @Test
    public void payAmountIsZero() {
        SavingAccount account = new SavingAccount(
                500,
                100,
                900,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);
    }
    // amount > 0; amount > balance - minBalance; false
    @Test
    public void payAmountMoreThanBalanceMinusMinBalance() {
        SavingAccount account = new SavingAccount(
                700,
                100,
                900,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(900);

        Assertions.assertEquals(expected, actual);
    }
    // amount > 0; amount = balance - minBalance; true
    @Test
    public void payAmountEqualBalanceMinusMinBalance() {
        SavingAccount account = new SavingAccount(
                700,
                100,
                900,
                15
        );

        boolean expected = true;
        boolean actual = account.pay(account.getBalance() - account.getMinBalance());

        Assertions.assertEquals(expected, actual);
    }
    // amount > 0; amount < balance - minBalance; true
    @Test
    public void payAmountLessThanBalanceMinusMinBalance() {
        SavingAccount account = new SavingAccount(
                700,
                100,
                900,
                15
        );

        boolean expected = true;
        boolean actual = account.pay(500);

        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ add
    // amount < 0; false
    @Test
    public void addAmountIsNegative() {
        SavingAccount account = new SavingAccount(
                500,
                100,
                900,
                15
        );

        boolean expected = false;
        boolean actual = account.add(-100);

        Assertions.assertEquals(expected, actual);
    }
    // amount = 0; false
    @Test
    public void addAmountIsZero() {
        SavingAccount account = new SavingAccount(
                500,
                100,
                900,
                15
        );

        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);
    }
    // amount > 0; amount > maxBalance - balance; false
    @Test
    public void addAmountMoreThanMaxBalanceMinusBalance() {
        SavingAccount account = new SavingAccount(
                400,
                100,
                900,
                15
        );

        boolean expected = false;
        boolean actual = account.add(550);

        Assertions.assertEquals(expected, actual);
    }
    // amount > 0; amount = maxBalance - balance; true
    @Test
    public void addAmountEqualMaxBalanceMinusBalance() {
        SavingAccount account = new SavingAccount(
                400,
                100,
                900,
                15
        );

        boolean expected = true;
        boolean actual = account.add(account.getMaxBalance() - account.getBalance());

        Assertions.assertEquals(expected, actual);
    }
    // amount > 0; amount < maxBalance - balance; true
    @Test
    public void addAmountLessThanMaxBalanceMinusBalance() {
        SavingAccount account = new SavingAccount(
                400,
                100,
                900,
                15
        );

        boolean expected = true;
        boolean actual = account.add(400);

        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ yearChange
    @Test
    public void yearChangeCalculate() {
        SavingAccount account = new SavingAccount(
                500,
                100,
                900,
                15
        );

        int expected = account.balance * account.rate / 100;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ геттеров и сеттеров
    @Test
    public void shouldSetAndSetRate() {
        SavingAccount account = new SavingAccount(
                500,
                100,
                900,
                15
        );

        account.setRate(20);
        Assertions.assertEquals(20, account.getRate());
    }
}

