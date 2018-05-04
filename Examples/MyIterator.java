import java.util.*;

public class MyIterator<E> {

    private ArrayList<E> data;
    private int theSpot;

    public MyIterator(ArrayList<E> data) {
	this.data = data;
	theSpot = data.size() - 1;
    }
	
    
    public E next() {
	E item = data.get(theSpot);
	theSpot--;
	return item;
    }
    
    public boolean hasNext() {
	return theSpot >= 0;
    }

    public static void main(String[] args) {

	ArrayList<Integer> stuff = new ArrayList<Integer>();

	stuff.add(1);
	stuff.add(2);
	stuff.add(3);
	stuff.add(4);
	stuff.add(5);

	MyIterator<Integer> it = new MyIterator<Integer>(stuff);

	while (it.hasNext()) {
	    System.out.println(it.next());
	}
    }
}
