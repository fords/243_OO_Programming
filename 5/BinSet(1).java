// Comments


import java.util.*;

// Comments

public class BinSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> s = new ArrayList<E>();

    // comments
    public BinSet(){}

    // comments
    public BinSet(Collection<? extends E> c){
	// YOUR CODE GOES HERE
    }
    
    // comments
    private int binarySearch(E e){
	// YOUR CODE GOES HERE
    }

    // comments
    public boolean add(E e) {
	// YOUR CODE GOES HERE
    }

    // comments
    public boolean addAll(Collection<? extends E> c) {
	// YOUR CODE GOES HERE
    }

    // comments
    public void clear() {
	// YOUR CODE GOES HERE
    }
     
    // comments
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
	// YOUR CODE GOES HERE
    }

    // comments
    public boolean containsAll(Collection<?> c) {
	// YOUR CODE GOES HERE
    }

    // comments
    public boolean isEmpty() {
	// YOUR CODE GOES HERE
    }
          
    // comments
    public Iterator<E> iterator() {
	// YOUR CODE GOES HERE
    }
    
    // comments
    public boolean remove(Object o) {
	// YOUR CODE GOES HERE
    }
     
    // comments
    public boolean retainAll(Collection<?> c) {
	// YOUR CODE GOES HERE
    }
    

    // comments
    public int size() {
	// YOUR CODE GOES HERE
    }
     
    // comments
    public Object[] toArray() {
	// YOUR CODE GOES HERE
    }
     
    
    // comments
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
	// YOUR CODE GOES HERE
    }

    // comments
    public String toString(){
	// YOUR CODE GOES HERE
    }

    /**
     * Displays a message followed by success or failure indicating
     * whether or not a particular test was successful.
     *
     * @param message The String form of the message.
     *
     * @param       b    A boolean indicating whether the test was successful or not.    
     *
     */

    private static void resultTest(String message, boolean b){
	if (b){
	    System.out.println(message + " success");
	} else {
	    System.out.println(message + " failure");
	}
    }
    
    /**
     * Runs a suite of tests to validate the implemenation of BinSet
     * for Integer elements.
     *
     */

    private static void testInteger(){
	Set<Integer> set = new BinSet<Integer>(Arrays.asList(1,3));
	
	resultTest("constructor 1",
		   Arrays.equals(set.toArray(), Arrays.asList(1,3).toArray()));
	
	set.add(2);
	resultTest("add 1",
		   Arrays.equals(set.toArray(), Arrays.asList(1,2,3).toArray()));
	
	resultTest("contains 1", set.contains(1));
	resultTest("contains 2", set.contains(2));
	resultTest("contains 3", set.contains(3));
	resultTest("contains 4", !set.contains(4));
	
	resultTest("size 1", set.size() == 3);
	
	set.clear();
	resultTest("clear/size", set.size() == 0);
	resultTest("clear/isEmpty", set.isEmpty());
	
	set.addAll(Arrays.asList(1,2,3));
	resultTest("addAll 1",set.size() == 3);
	
	resultTest("containsAll 1", set.containsAll(Arrays.asList(3,2)));
	resultTest("containsAll 2", !set.containsAll(Arrays.asList(4,3)));
	
	set.remove(2);
	resultTest("remove 1", 
		   Arrays.equals(set.toArray(), Arrays.asList(1,3).toArray()));
	
	Integer[] a = {1,3};
	int j = 0;
	for (Integer i : set){
	    resultTest("iterator " + i, i.equals(a[j]));
	    j++;
	}
	
	set.retainAll(Arrays.asList(3,4));
	resultTest("retainAll 1", 
		   Arrays.equals(set.toArray(), Arrays.asList(3).toArray()));
	
	resultTest("toArray(array) 1", 
		   Arrays.equals(set.toArray(new Integer[0]), 
				 Arrays.asList(3).toArray()));
    }

    /**
     * The main method for BinSet.  It runs any test scaffolding methods such as testInteger.
     *
     * @param args Command line arguments are not used.
     *
     */

    public static void main(String[] args){
	testInteger();
   }

}