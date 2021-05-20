public class Account {
  private String name;
  public static int numberOfAccounts = 0;
  private int accountNumber;
  private double balance;
  public String[] transactions;
  private String description;

  public Account () {
    name = "None";
    accountNumber = 10000000 + numberOfAccounts;
    numberOfAccounts++;
    balance = 0;
    transactions = null;
  }

  public Account (String name, double balance) {
    this.name = name;
    accountNumber = 10000000 + numberOfAccounts;
    numberOfAccounts++;
    this.balance = balance;
    transactions = null;
  }

  public String toString () {
    return String.format("Name: %s, Acct: %d, Balance: $%f", name, accountNumber, balance);
  }

  public void deposit (double amount) {
    balance += amount;
    
    // dealing with transactions[] here
    // because I don't want to deal with it seperately in other classes
    if (transactions == null)
      transactions = new String[]{"deposit " + amount};
    else {
      String[] newTransactions = new String[transactions.length + 1];
      for (int i = 0; i < transactions.length; i++) {
        newTransactions[i] = transactions[i];
      }
      newTransactions[newTransactions.length - 1] = "deposit " + amount;
      transactions = newTransactions;
    }
  }

  public double withdraw (double amount) {
    
    balance -= amount;
    // prevents a negative balance, cancelled out
    // if (balance - amount < 0) {
    //   amount = balance;
    //   balance = 0;
    // }
    // else
    //   balance -= amount;
    
    // dealing with transactions[] here
    // because I don't want to deal with it seperately in other classes
    if (transactions == null)
      transactions = new String[]{"withdraw " + amount};
    else {
      String[] newTransactions = new String[transactions.length + 1];
      for (int i = 0; i < transactions.length; i++) {
        newTransactions[i] = transactions[i];
      }
      newTransactions[newTransactions.length - 1] = "withdraw " + amount;
      transactions = newTransactions;
    }
    return balance;
  }

  public String getName () {
    return name;
  }

  public int getAccountNumber () {
    return accountNumber;
  }

  public double getBalance () {
    return balance;
  }
  
  public void setDescription (String description) {
		this.description = description;
	}
}