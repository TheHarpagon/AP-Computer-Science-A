public class Circle {
    double x;
    double y;
    double radius;
    
    public Circle () {
        this.x = 0;
		this.y = 0;
		this.radius = 5;
    }
    
    public Circle (double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        if (radius <= 0)
            radius = 1;
    }
}