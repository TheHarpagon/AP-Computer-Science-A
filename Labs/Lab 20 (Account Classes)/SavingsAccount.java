public class SavingsAccount extends Account {
  private double interestRate;

  public SavingsAccount () {
    super();
  }
  
  public SavingsAccount (String name, double balance, double interestRate) {
    super(name, balance);
    this.interestRate = interestRate;
  }

  public void applyInterest() {
    double amount = getBalance() * interestRate / 12;
    deposit(amount - getBalance());
  }

  @Override
  public String toString () {
    return String.format("Name: %s, Savings Account: %d, Balance: $%f, Interest: %f", getName(), getAccountNumber(), getBalance(), getInterestRate());
  }

  public double getInterestRate () {
    return interestRate;
  }
}