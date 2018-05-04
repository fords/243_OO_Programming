public class Circle implements Shape, Comparable<Circle> {

    private double radius;

    public Circle(double r) {

	radius = r;

    }

    public int compareTo(Circle oc) {
	if (radius < oc.radius) {
	    return -1;
	} else if (radius > oc.radius) {
	    return 1;
	} else
	    return 0;
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
