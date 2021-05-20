public class Main {
	// declaration of a double variable impervious to any change
    public static final double PI = 3.14;
	
	public static void main (String[] args) {
        System.out.println("Lab #10 (Circle Class)");
        
        // circle area and circumference with a set radius
        System.out.println("\nCircle Area & Circumference\n");
        for (int i = 3; i <= 19; i += 2) {
            System.out.println("Radius: " + i);
            System.out.println("area(): " + area(new Circle (0, 0, i)));
            System.out.println("circumference(): " + circumference(new Circle (0, 0, i)) + "\n");
        }
        
        System.out.println("Circle Intersection\n");
        String defaultCircle = "Circle 1 [Coordinates: (0, 0) | Radius: 5]";
        
        // circles that intersect at one point
        System.out.println(defaultCircle);
        System.out.println("Circle 2 [Coordinates: (10, 0) | Radius: 5]");
        System.out.println("isTangent():\n" + isTangent(new Circle (0, 0, 5), new Circle (10, 0, 5)) + "\n");
        
        // circles that don't intersect at one point
        System.out.println(defaultCircle);
        System.out.println("Circle 2 [Coordinates: (11, 0) | Radius: 5]");
        System.out.println("isTangent():\n" + isTangent(new Circle (0, 0, 5), new Circle (11, 0, 5)) + "\n");
        
        // circles that overlap (touch at two points)
        System.out.println(defaultCircle);
        System.out.println("Circle 2 [Coordinates: (9, 0) | Radius: 5]");
        System.out.println("isOverlap():\n" + isOverlap(new Circle (0, 0, 5), new Circle (9, 0, 5)) + "\n");
        
        // circles that don't overlap
        System.out.println(defaultCircle);
        System.out.println("Circle 2 [Coordinates: (10, 0) | Radius: 5]");
        System.out.println("isOverlap():\n" + isOverlap(new Circle (0, 0, 5), new Circle (10, 0, 5)) + "\n");
    }

    public static double area (Circle c) {
        // circle area: πr²
        return PI * c.radius * c.radius;
    }

    public static double circumference (Circle c) {
        // circle circumference: 2πr
        return 2 * PI * c.radius;
    }

    public static boolean isTangent (Circle a, Circle b) {
        // distance formula √((X₂ - X₁)² + (Y₂ - Y₁)²)
        double distance = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
        double radiusSum = a.radius + b.radius;
        
        // if the distance is equal to the sum of the radii
        // the circles touch at one point
        return distance == radiusSum;
    }

    public static boolean isOverlap (Circle a, Circle b) {
        // distance formula √((X₂ - X₁)² + (Y₂ - Y₁)²)
        double distance = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
        double radiusSum = a.radius + b.radius;
        
        // if the distance is less than the sum of the radii
        // the circles interect at two points
        // an intersection at two points indicates the circles overlapping
        return distance < radiusSum;
    }
}