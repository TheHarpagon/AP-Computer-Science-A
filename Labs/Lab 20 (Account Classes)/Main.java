import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
    Account[] a = new Account[100];

		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to the bank. Choose: ");
		System.out.println("1. Create new account");
		System.out.println("2. Deposit/Pay");
    System.out.println("3. Withdraw/Charge");
    System.out.println("4. Print report of all accounts");
    System.out.println("5. Print all transactions");
    System.out.println("6. Exit");
    int input = 0;
    
    // using array lists as it
    // allows you to resize arrays
    ArrayList <Account> accounts = new ArrayList <Account> ();
    while (input != 6) {
      input = s.nextInt();
          ArrayList <String> t = new ArrayList <String> ();
          if (input == 1) {
            System.out.println("Input name, balance, and account type. 1 for Savings, 2 for Credit Card, and 3 for Checking");
            String name = s.nextLine();
            double balance = s.nextDouble();
            int accountType = s.nextInt();
            
            if (accountType == 1) {
              System.out.println("What is the interest?");
              double interest = s.nextDouble();
              SavingsAccount account = new SavingsAccount(name, balance, interest);
              account.setDescription("Savings");
              accounts.add(account);
            } 
            
            else if (accountType == 2) {
              System.out.println("What is the interest?");
              double interest = s.nextDouble();
              System.out.println("Card type?");
              CreditCardAccount account = new CreditCardAccount(name, balance, interest);
              account.setDescription("Credit Card Account");
              accounts.add(account);
            }
            
            else if (accountType == 3) {
              CheckingAccount account = new CheckingAccount(name, balance);
              account.setDescription("Checking Account");
              accounts.add(account);
            } 
            
            else
              System.out.println("Please try again");
          } 
          
          else if (input == 2) {
            System.out.println("Input account number to withdraw from: ");
            int accountNumber = s.nextInt();
            System.out.println("How much to withdraw?");
            double a = s.nextDouble();
            for (Account account : accounts) {
              if (account.getAccountNumber() == accountNumber)
                account.withdraw(a);
            }
            t.add("Withdrawn $" + a);
          } 
          
          else if (input == 4) {
            for (Account account: accounts) {
              System.out.println(account.toString());
            }
          } 
          
          else if (input == 5) {
            for (String transaction : t) {
              System.out.println(transaction);
            }
          } 
          
          else if (input == 6) {
            Scanner accountNumberSc = new Scanner(System.in);
            int accountNumberChoice = accountNumberSc.nextInt();
            System.out.println("Input account number: ");
            Scanner monthSc = new Scanner(System.in);
            int monthChoice = monthSc.nextInt();
            for (int i = 0; i < monthChoice; i++) {
              ((SavingsAccount) a[accountNumberChoice - 10000000]).applyInterest();
            }
            
          } 
          
          else
            System.out.println("Please try again");
    }
	}
}