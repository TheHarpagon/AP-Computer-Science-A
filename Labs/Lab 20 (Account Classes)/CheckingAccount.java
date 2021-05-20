public class CheckingAccount extends Account {
  public CheckingAccount () {
    super();
  }

  public CheckingAccount (String name, double balance) {
    super(name, balance);
  }
  
  @Override
  public String toString () {
    return String.format("Name: %s, Checking Account: %d, Balance: $%f", getName(), getAccountNumber(), getBalance());
  }
}