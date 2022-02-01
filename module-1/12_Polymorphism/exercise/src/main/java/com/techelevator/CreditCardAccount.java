package com.techelevator;

public class CreditCardAccount implements Accountable{

    // Needs to implement Accountables methods
    @Override
    public int getBalance() {
        return -debt;
    }

    public CreditCardAccount(String accountHolder, String accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    //private instance variable: debt, ba
    private String accountHolder; // accountHolder

    public String getAccountHolder() {
        return accountHolder;
    }

    private String accountNumber; //account number

    public String getAccountNumber() {
        return accountNumber;
    }

    private int debt; // amount customer owes

    public int getDebt() {
        return debt;
    }

    public int pay(int amountToPay){
        //removes amountToPay from amountOwed
        //returns new total amount oweed
        debt =-amountToPay;
        return debt; //placeholder for now
    }

    public int charge(int amountToCharge){
        //adds amountToCharge to amount owed
        //returns new total amount owed
        debt+=amountToCharge;
        return debt;
    }





}
