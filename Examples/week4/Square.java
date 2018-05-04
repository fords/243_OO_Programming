public class Square extends Rectangle {

    // maybe not good design but whatever.

    public Square(int side, int x, int y) {
	super(side,side,x,y);
    }


    public boolean equals(Object other) {
	if (!(other instanceof Square))
	    return false;
	Square or = (Square)(other);
	return height == or.height;
    }
    
}
