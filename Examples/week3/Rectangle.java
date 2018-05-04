public class Rectangle implements Shape {

    private double height, width;

    public Rectangle(double h, double w) {
	height=h;width=w;
    }

    public double area() {
	return height*width;
    }

    public double perimeter() {
	return 2 * (height + width);
    }

}