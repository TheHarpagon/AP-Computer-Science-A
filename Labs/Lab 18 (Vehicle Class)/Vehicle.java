public class Vehicle {
  public int numerOfSeats;
  public int numberOfPassengers;
  public Point currentPosition;
  public Point destination;
  public int topSpeed;
  
  public Vehicle () {
	this.numberOfSeats = 1;
	this.numberOfPassengers = 1;
	this.currentPosition = new Point ();
	this.destination = new Point ();
	this.topSpeed = 1;
  }

  public Vehicle (int numberOfSeats, int numberOfPassengers, Point currentPosition, Point destination, int topSpeed) {
    this.numberOfSeats = numberOfSeats;
    this.numberOfPassengers = numberOfPassengers;
    this.currentPosition = currentPosition;
    this.destination = destination;
    this.topSpeed = topSpeed;
  }

  public String communicate() {
    return "Hey you!";
  }

  public String toString() {
    return "This is a vehicle.";
  }

  public int speedCompareTo (Vehicle v) {
    return this.topSpeed - v.topSpeed;
  }

  public double distanceTo (Vehicle v) {
    return currentPosition.distance(v.currentPosition);
  }
}