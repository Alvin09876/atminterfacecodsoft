import java.util.Scanner;
        
class BankAccount {
    private double balance;

    public BankAccount(double StartBalance) {
        balance = StartBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance = balance + amt;
    }

    public boolean withdrawl(double amt) {
        if (amt <= balance) {
            balance =balance - amt;
            return true;
        }
        return false;
    }
}      

class ATM {
    private BankAccount account;

    public ATM(BankAccount bankAccount) {
        account = bankAccount;
    }

    public void displayMenu() {
        System.out.println("WELCOME to the ATM ");
        System.out.println("1. Check Balance ");
        System.out.println("2. Deposit Amount ");
        System.out.println("3. Withdraw Amount ");
        System.out.println("4. Exit the ATM");
    }       

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print(" select an option: ");
            int ch= scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Your balance is: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to be deposited: ");
                    double AmountDeposit = scanner.nextDouble();
                    account.deposit(AmountDeposit);
                    System.out.println("Deposit successful. Your balance is: Rs. " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to be withdrawn: ");
                    double AmountWithdrwan = scanner.nextDouble();
                    if (account.withdrawl(AmountWithdrwan)) {
                        System.out.println("Withdrawal successful. Your balance is: Rs. " + account.getBalance());
                    } else {
                        System.out.println("Insufficient Balance in your account.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    scanner.close();
                    return;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }
}       

public class atminterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}           