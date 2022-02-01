package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
private List<Accountable> accounts = new ArrayList<>(); // can get but not set accounts
private String name;
private String address;
private String phoneNumber;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Accountable> getAccountables() {
        return accounts; //return list of accountables
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Accountable[] getAccounts() {

        return accounts.toArray(new Accountable[accounts.size()]); //return an array of accounts
            //parameter for toArray: define what type of array & size
            //pass in new accountable with size: accounts.size
    }

    public void addAccount (Accountable newAccount){
        accounts.add(newAccount);
    }

    public boolean isVip(){
        int sum = 0;
       for (Accountable a : accounts){
           a.getBalance();
           sum += a.getBalance();
       }
        if (sum >= 25000) {
            return true;
        }
       return false;
    }
}
