package com.techelevator;

public class CheckingAccount extends BankAccount {


    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int remainingBalance = super.getBalance();
        if (remainingBalance >= amountToWithdraw) {
            return super.withdraw(amountToWithdraw);
        }
        if (remainingBalance < 0 && remainingBalance > -100) {
            return super.withdraw(amountToWithdraw + 10);
        } else {
            return super.withdraw(0);
        }
    }
}
