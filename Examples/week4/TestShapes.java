import java.util.ArrayList;

public class TestShapes {

    public static void main(String[] args) {
	
	Circle c = new Circle(5, 20, 20);
	//Shape sh = new Shape(10, 50);

	ArrayList<Shape> shapes = new ArrayList<Shape>();
	shapes.add(c);
	shapes.add(new Rectangle(20, 10, 50, 50));
	Square sq = new Square(25, 0, 0);
	shapes.add(sq);

	for (Shape s : shapes) {
	    s.move(2,2);
	    System.out.println(s);
	    System.out.println("Area is: " + s.area());
	}

	Rectangle r = new Rectangle(25,25,0,0);
	System.out.println(r.equals(sq));
	System.out.println(sq.equals(r));
    }
}