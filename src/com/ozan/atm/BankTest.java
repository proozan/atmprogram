package com.ozan.atm;

import java.util.Scanner;

public class BankTest {

    public static void main(String[] args) {
        int select = 0;
        int amount;
        String targetAccNo;

        Bank[] customers = new Bank[3];

        customers[0] = new Bank("0001", "Ozan",100);
        customers[1] = new Bank("0002", "Melih",1000000);
        customers[2] = new Bank("0003", "Onur",550);

        Scanner inp = new Scanner(System.in);
        System.out.println("Please enter your account number: ");
        String searchAcc = inp.next();

        Bank activeCustomer = Bank.findAccount(customers, searchAcc);

        if(activeCustomer == null) {
            System.out.println("Account Not Found!");
        }
        else {

                while (select != 6) {
                    try {
                    System.out.println("1- Withdraw");
                    System.out.println("2- Deposit");
                    System.out.println("3- Check Balance");
                    System.out.println("4- Transfer");
                    System.out.println("5- Check Different Account Balance");
                    System.out.println("6- Exit");
                    System.out.print("Your Choice: ");

                    select = inp.nextInt();
                    switch(select) {
                        case 1:
                            System.out.println("Enter amount to withdraw");
                            amount = inp.nextInt();
                            activeCustomer.withdraw(amount);
                            break;

                        case 2:
                            System.out.println("Enter amount to deposit");
                            amount = inp.nextInt();
                            activeCustomer.deposit(amount);
                            break;
                        case 3:
                            System.out.println("Your money is: " + activeCustomer.getBalance());
                            break;
                        case 4:
                            System.out.println("Enter destination account number:");
                            targetAccNo = inp.next();
                            Bank receiverAcc = Bank.findAccount(customers, targetAccNo);
                            if(receiverAcc == null) {
                                System.out.println("Account Not Found!");
                            }
                            else {
                                System.out.println("How much will be transferred?");
                                amount = inp.nextInt();
                                activeCustomer.transfer(amount,receiverAcc);

                            }
                            break;
                        case 5:
                            System.out.println("Enter account number you want to see");
                            targetAccNo = inp.next();
                            Bank findAcc = Bank.findAccount(customers, targetAccNo);
                            if(findAcc == null){
                                System.out.println("Account Not Found!");
                            }
                            else{
                                System.out.println("Checked Account Balance is:" + findAcc.getBalance());
                            }
                            break;
                        case 6:
                            System.out.println("Exiting... Have a nice day!");
                            break;
                        default:
                            System.out.println("Wrong choice!");
                    }
                }catch (Exception e){
                        System.out.println("Incorrect Entry! ");
                        inp.next();
                    }
            }
        }
        inp.close();
    }
}
