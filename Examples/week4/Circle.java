public class Circle extends Shape {

    private double radius;

    public Circle(double r, int x, int y) {
	// please use the Shape(int, int) constructor with these args:
	super(x,y);
	radius = r;
    }

    public double area() {
	return Math.PI * radius * radius;
    }

    public double perimeter() {
	return 2 * Math.PI * radius;
    }

    public double diameter() {
	return 2 * radius;
    }
}