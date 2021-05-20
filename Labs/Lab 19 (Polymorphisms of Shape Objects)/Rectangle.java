public class Rectangle extends Shape {
  private final int NUMBER_OF_SIDES = 4;
  private double length;
  private double width;

  public Rectangle () {
    length = 0;
    width = 0;
  }

  public Rectangle (double length, double width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public double area () {
    return this.length * this.width;
  }

  @Override
  public double perimeter () {
    return 2 * this.length + 2 * this.width;
  }

  public String toString () {
    return "Rectangle with 4 sides, length = " + this.length + " and width = " + this.width;
  }

  @Override
  public int getNumberOfSides () {
    //Override getNumberOfSides function to return Rectangle's NUMBER_OF_SIDES
    return NUMBER_OF_SIDES;
  }

  public double getLengt () {
    return length;
  }

  public double getWidth () {
    return width;
  }

  public void setLength (double length) {
    this.length = length;
  }

  public void setWidth (double width) {
    this.width = width;
  }
}