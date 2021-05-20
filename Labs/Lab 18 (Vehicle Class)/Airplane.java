public class Airplane extends Vehicle {
  private String flightNumber;
  
  public Airplane () {
    super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
	this.flightNumber = "A101";
  }

  public Airplane (int numberOfSeats, int numberOfPassengers, Point currentPosition, Point destination, int topSpeed, String flightNumber) {
    super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
    this.flightNumber = flightNumber;
  }

  @Override
  public String communicate () {
    return String.format("Tower, this is flight %s. Requesting permissions to land.", flightNumber);
  }

  @Override
  public String toString () {
    return String.format("This is an airplane, flight number %s.", flightNumber);
  }
}