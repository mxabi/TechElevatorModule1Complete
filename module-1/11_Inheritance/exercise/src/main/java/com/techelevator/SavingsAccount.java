package com.techelevator;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int remainingBalance = super.getBalance() - amountToWithdraw;
        if (remainingBalance >= 2) {
            if (remainingBalance <= 150) {
                return super.withdraw(amountToWithdraw + 2);
            }
            else {
                return super.withdraw(amountToWithdraw);
            }
        }
        return super.getBalance();
    }
}
