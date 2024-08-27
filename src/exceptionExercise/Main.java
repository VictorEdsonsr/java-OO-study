package exceptionExercise;

import exceptionExercise.model.entities.Account;
import exceptionExercise.model.exceptions.AccountException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter account data: ");
            System.out.print("Number: ");
            int accountNumber = sc.nextInt();

            sc.nextLine();

            System.out.print("Holder: ");
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            Double initialBalance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(accountNumber,holder,initialBalance,withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            Double withdrawAmount = sc.nextDouble();
            account.withdraw(withdrawAmount);

            System.out.println("New balance: " + String.format("%.2f",account.getBalance()));
        }catch (AccountException error){
            System.out.println("Withdraw error: " + error.getMessage());
        }
        sc.close();
    }

}

