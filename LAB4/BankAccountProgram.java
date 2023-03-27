


import java.util.Scanner;

public class BankAccountProgram {
    private static int accountNumber;
    private static String accountHolderName;
    private static double accountBalance;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Bank Account Program");
            System.out.println("--------------------");
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display account details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    createAccount(input);
                    break;
                case 2:
                    deposit(input);
                    break;
                case 3:
                    withdraw(input);
                    break;
                case 4:
                    displayAccountDetails();
                    break;

                    case 5:
                    printTransactionDetails();
                    break;
                    
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
            System.out.println();
        } while (choice != 5);
        
        input.close();
    }
    
    private static void createAccount(Scanner input) {
        System.out.print("Enter account number: ");
        accountNumber = input.nextInt();
        input.nextLine(); // Consume the new line character
        System.out.print("Enter account holder name: ");
        accountHolderName = input.nextLine();
        System.out.print("Enter account balance: ");
        accountBalance = input.nextDouble();
        System.out.println("Account created successfully.");
    }
    
    private static void deposit(Scanner input) {
        System.out.print("Enter amount to deposit: ");
        double amount = input.nextDouble();
        double previousBalance = accountBalance;
        accountBalance += amount;
        System.out.println("Deposit successful.");
        printTransactionDetails(previousBalance, amount, accountBalance);
    }
    
    private static void withdraw(Scanner input) {
        System.out.print("Enter amount to withdraw: ");
        double amount = input.nextDouble();
        double previousBalance = accountBalance;
        if (amount > accountBalance) {
            System.out.println("Insufficient balance.");
        } else {
            accountBalance -= amount;
            System.out.println("Withdrawal successful.");
            printTransactionDetails(previousBalance, -amount, accountBalance);
        }
    }
    
    private static void displayAccountDetails() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder name: " + accountHolderName);
        System.out.println("Account balance: " + accountBalance);
    }
    
    private static void printTransactionDetails(double previousBalance, double transactionAmount, double newBalance) {
        System.out.println("Previous balance: " + previousBalance);
        System.out.println("Transaction amount: " + transactionAmount);
        System.out.println("New balance: " + newBalance);
    }
}
