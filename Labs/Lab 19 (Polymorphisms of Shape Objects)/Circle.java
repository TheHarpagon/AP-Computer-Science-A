public class Circle extends Shape{
  private final int NUMBER_OF_SIDES = 1;
  private double radius;
  private Point center;

  public Circle () {
    radius = 0;
    center = new Point(0, 0);
  }

  public Circle (double radius, Point center) {
    this.radius = radius;
    this.center = center;
  }

  @Override
  public double area () {
    return 3.14 * this.radius * this.radius;
  }

  @Override
  public double perimeter () {
    return 2 * 3.14 * this.radius;
  }

  public String toString () {
    return "Circle with 1 side, radius = " + this.radius + " and center = " + this.center.toString();
  }

  @Override
  public int getNumberOfSides () {
    return NUMBER_OF_SIDES;
  }

  public double getRadius () {
    return radius;
  }

  public Point getCenter () {
    return center;
  }

  public void setRadius (double radius) {
    this.radius = radius;
  }

  public void setCenter (Point center) {
    this.center = center;
  }
}