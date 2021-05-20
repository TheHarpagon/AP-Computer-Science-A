public class CreditCardAccount extends Account {
  private double interestRate;
  private String description;

  public CreditCardAccount () {
    super();
    description = "Default";
  }

  public CreditCardAccount (String name, double balance, double interestRate, String description) {
    super(name, balance);
    this.interestRate = interestRate;
    this.description = description;
  }

  public void chargeInterest () {
    // prevents a negative balance, cancelled out
    // double amount = getBalance() + getBalance() * interestRate / 12;
    // if (getBalance() - amount < 0)
    //   withdraw(getBalance());
    // else
    //   withdraw(amount - getBalance());
    withdraw(getBalance() * interestRate / 12);
  }

  public void charge (double amount) {
    withdraw(amount);
  }

  public void pay (double amount) {
    deposit(amount);
  }
  
  @Override
  public String toString () {
    return String.format("Name: %s, %s Account: %d, Balance: $%f, Interest: %f", getName(), description, getAccountNumber(), getBalance(), getInterestRate());
  }

  public double getInterestRate () {
    return interestRate;
  }
}