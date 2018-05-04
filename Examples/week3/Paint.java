import java.util.ArrayList;
import java.util.Collections;

public class Paint {

    public static void main(String[] args) {

	ArrayList<Shape> shapes = new ArrayList<Shape>();

	shapes.add(new Circle(5));
	shapes.add(new Rectangle(6,8));
	//shapes.add(new Shape()); // NO CAN DO!

	for (Shape s : shapes) {
	    System.out.println("Area is: " + s.area());
	}

	ArrayList<Circle> circles = new ArrayList<Circle>();
	circles.add(new Circle(5));
	circles.add(new Circle(3));
	circles.add(new Circle(15));
	circles.add(new Circle(8));
	circles.add(new Circle(9.263));
	Collections.sort(circles);

	for (Circle c : circles) {
	    System.out.println("Diameter is: " c.diameter());
	    System.out.println("Area is: " + c.area());
	}

	GenericQueue<Circle> q = new LinkedQueue<Circle>();
	//	GenericQueue<Circle> q = new SuperAwesomeQueue<Circle>();
	//	LinkedQueue<Circle> lq = new LinkedQueue<Circle>();

	q.add(new Circle(5));
	// etc...

    }
}