public class Train extends Vehicle {
  private int numberOfBoxcars;
  
  public Train () {
	super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
	this.numberOfBoxcars = 1;
  }

  public Train (int numberOfSeats, int numberOfPassengers, Point currentPosition, Point destination, int topSpeed, int numberOfBoxcars) {
    super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
    this.numberOfBoxcars = numberOfBoxcars;
  }
  
  @Override
  public String communicate () {
    return "I think I can, I think I can!";
  }

  @Override
  public String toString () {
    return "This is a train, all aboard!";
  }
}