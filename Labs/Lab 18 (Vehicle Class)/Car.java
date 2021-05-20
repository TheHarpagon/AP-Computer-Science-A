public class Car extends Vehicle {
  private int numberOfDoors;
  private String engineOrMotorType;
  
  public Car () {
    super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
	this.numberOfDoors = 1;
	this.engineOrMotorType = "4 cylinder";
  }

  public Car (int numberOfSeats, int numberOfPassengers, Point currentPosition, Point destination, int topSpeed, int numberOfDoors, String engineOrMotorType) {
    super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
    this.numberOfDoors = numberOfDoors;
    this.engineOrMotorType = engineOrMotorType;
  }

  @Override
  public String communicate () {
    return "Honk honk!";
  }

  @Override
  public String toString () {
    return String.format("This is a %s car with %d doors.", engineOrMotorType, numberOfDoors);
  }
}