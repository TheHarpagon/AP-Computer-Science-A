public class Triangle extends Shape{
  private final int NUMBER_OF_SIDES = 3;
  private double sideA;
  private double sideB;
  private double sideC;
  private double base;
  private double height;

  public Triangle () {
    this.sideA = 0;
    this.sideB = 0;
    this.sideC = 0;
    this.base = 0;
    this.height = 0;
  }
  
  public Triangle (double sideA, double sideB, double sideC, double base, double height) {
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
    this.base = base;
    this.height = height;
  }

  public String toString () {
    return "Triangle with 3 sides, side lengths = " + this.sideA + ", " + this.sideB + ", " + this.sideC + ", base = " + this.base + ", height = " + this.height;
  }

  @Override
  public double area () {
    return 0.5 * this.base * this.height;
  }

  @Override
  public double perimeter () {
    return this.sideA + this.sideB + this.sideC;
  }

  @Override
  public int getNumberOfSides () {
    return NUMBER_OF_SIDES;
  }

  // getters and setters
  public double getSideA () {
    return sideA;
  }

  public double getSideB () {
    return sideB;
  }

  public double getSideC () {
    return sideC;
  }

  public double getBase () {
    return base;
  }

  public double getHeight () {
    return height;
  }

  public void setSideA (double sideA) {
    this.sideA = sideA;
  }

  public void setSideB (double sideB) {
    this.sideB = sideB;
  }

  public void setSideC (double sideC) {
    this.sideC = sideC;
  }

  public void setBase (double base) {
    this.base = base;
  }

  public void setHeight (double height) {
    this.height = height;
  }
}