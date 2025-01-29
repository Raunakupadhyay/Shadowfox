package shadowfox_intern_project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank_account_Management_system {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(accountNumber, initialBalance);

        while (true) {
            System.out.println("Choose an option: 1. Deposit 2. Withdraw 3. Check Balance 4. Transaction History 5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Transaction History: " + account.getTransactionHistory());
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }
}
