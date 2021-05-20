public class Point {
  private double x;
  private double y;
  
  public Point () {
    this.x = 0;
	this.y = 0;
  }

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public String toString() {
    return String.format("(%d, %d)", x, y);
  }
  
  public double distance (Point p) {
    return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - x, 2));
  }
}