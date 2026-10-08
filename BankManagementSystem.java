import java.util.Scanner;

class BankAccount {
    
    String accountNumber;
    String accountHolderName;
    double balance;

    
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount!");
        }
    }


    public double checkBalance() {
        return balance;
    }

    
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankManagementSystem {

    
    public static void performDeposit(BankAccount account, Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
    }

    
    public static void performWithdrawal(BankAccount account, Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter Account Number: ");
        String accNum = scanner.next();
        scanner.nextLine(); 

        System.out.print("Enter Account Holder Name: ");
        String accName = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initBalance = scanner.nextDouble();

        
        BankAccount myAccount = new BankAccount(accNum, accName, initBalance);

        
        performDeposit(myAccount, scanner);

        
        performWithdrawal(myAccount, scanner);

    
        myAccount.displayAccount();

        scanner.close();
    }
}
