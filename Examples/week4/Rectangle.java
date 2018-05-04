public class Rectangle extends Shape {

    protected double height, width;

    public Rectangle(double h, double w, int x, int y) {
	super(x,y);
	height=h;width=w;
    }

    public double area() {
	return height*width;
    }

    public double perimeter() {
	return 2 * (height + width);
    }

    public String toString() {
	return "Rectangle at " + getX() + "," + y;
    }

    public boolean equals(Object other) {
	if (!(other instanceof Rectangle))
	    return false;
	/*  this one makes squares and rectangles never equal
	if (!(getClass().equals(other.getClass())))
	    return false;
	*/
	Rectangle or = (Rectangle)(other);
	return height == or.height && width == or.width;
    }
}