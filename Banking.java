import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Account {
    int accountNumber;
    String name;
    double balance;
    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        }
    }
    void displayAccount() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Name           : " + name);
        System.out.println("Balance        : Rs." + balance);
    }
}
public class Banking {
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static Account findAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid balance!");
            return;
        }
        Account account = new Account(accountNumber, name, balance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully!");
    }
    static void depositMoney() {

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }
    static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();

        account.withdraw(amount);
    }
    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("Current Balance: Rs." + account.balance);
    }
    static void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available!");
            return;
        }
        System.out.println("\n----- All Accounts -----");
        for (Account account : accounts.values()) {
            account.displayAccount();
            System.out.println("------------------------");
        }
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    System.out.println(
                        "Thank you for using Banking System!"
                    );
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
