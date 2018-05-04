public abstract class Shape {

    // visible to self and subclasses
    protected int x, y;

    public void move(int dx, int dy) {
	x += dx;
	y += dy;
    }

    public Shape(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public abstract double area();

    public int getX() { 
	return x;
    }

    public String toString() {
	return "Just a shape.";
    }
}
