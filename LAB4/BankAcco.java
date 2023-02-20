package LAB4;

import java.util.Scanner;

public class BankAcco{
    private static int accountNumber;
    private static String accountHolderName;
    private static double accountBalance;

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeCustomer();
        int choice=0;
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Print transactions");
            System.out.println("4. Print account summary");
            System.out.println("5. Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    depositMoney();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    printTransactions();
                    break;
                case 4:
                    printAccountSummary();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    
    public static void initializeCustomer() {
        System.out.println("Enter account number:");
        accountNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter account holder name:");
        accountHolderName = scanner.nextLine();
        System.out.println("Enter account balance:");
        accountBalance = Double.parseDouble(scanner.nextLine());
        System.out.println("Account created with balance " + accountBalance);
    }
    
    public static void depositMoney() {
        System.out.println("Enter amount to deposit:");
        double amount =  Double.parseDouble(scanner.nextLine());
        accountBalance += amount;
        System.out.println("Deposit successful");
        addTransaction("Deposit of " + amount);
    }
    
    public static void withdrawMoney() {
        System.out.println("Enter amount to withdraw:");
        double amount =  Double.parseDouble(scanner.nextLine());
        if (amount > accountBalance) {
            System.out.println("Insufficient balance");
        } else {
            accountBalance -= amount;
            System.out.println("Withdrawal successful");
            addTransaction("Withdrawal of " + amount);
        }
    }
    
    public static void printTransactions() {
        System.out.println("Transaction history:");
        System.out.println(getTransactionDetails());
    }
    
    public static void printAccountSummary() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder name: " + accountHolderName);
        System.out.println("Account balance: " + accountBalance);
    }
    
    private static String transactionDetails = "";
    
    private static void addTransaction(String transaction) {
        transactionDetails += transaction + "\n";
    }
    
    private static String getTransactionDetails() {
        return transactionDetails;
    }
}
