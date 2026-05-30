package com.ozan.atm;

public class Bank {
    private int balance;
    private String name, accno;

    Bank(String accno, String name, int balance) {
        this.accno = accno;
        this.name = name;
        this.balance = balance;
    }

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        if (amount > balance) System.out.println("Balance doesn't enough!");
        else balance -= amount;
    }


    void transfer(int transferAmount, Bank receiver) {
        if (balance < transferAmount) System.out.println("Balance doesn't enough");
        else {
            receiver.deposit(transferAmount);
            this.withdraw(transferAmount);
        }
    }

    public int getBalance() {
        return balance;
    }

    public String getAccno() {
        return accno;
    }

    public static Bank findAccount(Bank[] customers, String searchAcc) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getAccno().equals(searchAcc)) {
                return customers[i];
            }
        }
        return null;
    }
}
