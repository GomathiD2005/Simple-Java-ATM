import java.util.Scanner;

class UserAccount {
    private int pin;
    private double balance;

    public UserAccount(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean checkPin(int inputPin) {
        return inputPin == pin;
    }

    public void changePin(int newPin) {
        this.pin = newPin;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAccount account = new UserAccount(1234, 5000); // Default pin and balance

        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (!account.checkPin(enteredPin)) {
            System.out.println("Incorrect PIN. Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\nATM Menu:\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Change PIN\n5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    if (!account.withdraw(scanner.nextDouble()))
                        System.out.println("Insufficient balance or invalid amount.");
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    account.changePin(scanner.nextInt());
                    System.out.println("PIN changed successfully.");
                    break;
                case 5:
                    System.out.println("Thank you! Visit again.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
