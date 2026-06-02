package bankmanager.src;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Account account1 = new Account();
        account1.setId("001");
        account1.setBalance(1000);

        Account account2 = new Account();
        account2.setId("002");
        account2.setBalance(500);

        System.out.println("Enter your account ID:");
        String id = sc.nextLine();
        Account selectedAccount = account1.getId().equals(id) ? account1 : account2.getId().equals(id) ? account2 : null;
        menu(sc, selectedAccount);
    }

    public static void menu (Scanner sc, Account account1) {
        System.out.println("1 - Check Balance");
        System.out.println("2 - Check Limit Special Checking");
        System.out.println("3 - Deposit");
        System.out.println("4 - Withdraw");
        System.out.println("5 - Payment");
        String answer = sc.nextLine();
        switch (answer) {
            case "1":
                checkBalance(account1);
                replaymenu(sc, account1);
                break;
            case "2":
                checkLimitSpecialChecking(account1);
                replaymenu(sc, account1);
                break;
            case "3":
                System.out.println("Enter the amount to deposit:");
                double amountDeposit = sc.nextDouble();
                sc.nextLine();
                deposit(account1, amountDeposit);
                replaymenu(sc, account1);
                break;
            case "4":
                System.out.println("Enter the amount to withdraw:");
                double amountWithdraw = sc.nextDouble();
                sc.nextLine();
                withdraw(account1, amountWithdraw);
                replaymenu(sc, account1);
                break;
            case "5":
                System.out.println("Enter the amount to pay:");
                double amountPayment = sc.nextDouble();
                sc.nextLine();
                payment(account1, amountPayment);
                replaymenu(sc, account1);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static void replaymenu (Scanner sc, Account account1
    ) {
        System.out.println("Do you want to perform another operation? (Y/N)");
        String answer = sc.nextLine();
        if(answer.equalsIgnoreCase("Y")) {
            menu(sc, account1);
        } else {
            System.out.println("Thank you for using our services!");
        }
    }

    public static void checkBalance (Account account) {
        System.out.println("Balance: " + account.getBalance());
    }

    public static void checkLimitSpecialChecking (Account account) {
        System.out.println("Limit Special Checking: " + account.getLimitSpecialChecking());
    }

    public static void deposit (Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public static void withdraw (Account account, double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            System.out.println("Your'e using your special checking limit");
            Double availableAmount = amount - account.getBalance();
            account.setBalance(0);
            account.setLimitSpecialChecking(account.getLimitSpecialChecking() - availableAmount*0.2);
        }
    }

    public static void payment (Account account, double amount) {
        if (account.getBalance() + account.getLimitSpecialChecking() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

}
