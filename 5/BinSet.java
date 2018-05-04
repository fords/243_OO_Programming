/*
 * $BinSet.java 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */
/*
 * Binary search in arraylist which takes log n time.The generic in arraylist ,which means any primitive type can be stored in arraylist
 * @zeyar Win
 */

import java.util.*;



public class BinSet<E extends Comparable<? super E>> extends AbstractSet<E> {

	private ArrayList<E> s = new ArrayList<E>();

	/*
	 *  Construct an empty BinSet.
	 * 
	 */
	
	public BinSet() {
		s = new ArrayList<E>();
	}

	/*
	 *  Construct a BinSet from the supplied collection.
	 *  @param Collection
	 */
	public BinSet(Collection<? extends E> c) {
		Object[] array = c.toArray();
		for (Object a : array) {
			s.add((E) a);
		}
	}

	/*
	 * search the element in arraylist via binary search
	 * @param int,int
	 * @return int
	 */
	private int binarySearch(int startindex, int endindex, E e) {
		int i = (startindex + endindex) / 2;
		E v = s.get(i);
		if (v.compareTo(e) == 0) {
			return i;

		} else if (startindex == endindex - 1) {
			return -1;
		} else if (v.compareTo(e) < 0) {
			return binarySearch(i, endindex, (E) e);
		} else {
			return binarySearch(startindex, i, (E) e);
		}

	}

	// if (v.compareTo(e) > 0)

	/* 
	 * Adds the specified element to this set if it is not already present.
	 * @param <E>
	 * @return boolean
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#add(java.lang.Object)
	 */
	public boolean add(E e) {
		if (contains(e)) {
			return false;
			
		}
		for (int i = 0; i < s.size(); i++) {

			if (s.get(i).compareTo(e) > 0) {
				s.add(i, e);
				return true;
			}

		}
		s.add(e);
		return true;
	}

	/*  Adds all of the elements in the specified collection 
	 * to this set if they're not already present	
	 * @param collection
	 * @return boolean
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends E> c) {
		boolean allAdded = false;
		for (Object e : c) {
			if (s.add((E) e)) {
				allAdded = true;
			}
		}
		return allAdded;
	}

	/*
	 * Removes all of the elements from this set.
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#clear()
	 */
	public void clear() {
		s.clear();
	}

	/*   Returns true if this set contains the specified element.
	 * @param Object
	 * @return boolean
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#contains(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean contains(Object o) {
		
		try {
			return binarySearch(0, s.size(), (E) o) != -1;
		} catch (ClassCastException x) {
			return false;
		}
	}

	/*
	 *    Returns true if this set contains all of the elements of the specified collection.
	 *    @param Collection
	 *    @return boolean
	 *    (non-Javadoc)
	 * @see java.util.AbstractCollection#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		for (Object element : c) {
			if (!contains(element)) {
				return false;
			}
		}
		return true;
	}

	/* return true if the set contains no elements
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#isEmpty()
	 */
	public boolean isEmpty() {
		return s.isEmpty();
	}

	/*Returns an iterator over the elements in this set.
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#iterator()
	 */
	public Iterator<E> iterator() {
		return s.iterator();
	}

	/*  Removes the specified element from this set if it is present.
	 * @param object
	 * @return boolean
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).equals(o)) {
				s.remove(i);
				return true;
			}
		}
		return false;
	}

	/*  Retains only the elements in th
	 * is set that are contained in the specified collection.
	 * @param collection
	 * @return boolean
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		boolean retainAll = false;
		ArrayList<E> array = new ArrayList<E>();
		for (E element : s) {
			if (c.contains(element)) {
				array.add(element);
			}
		}

		retainAll = s.size() != array.size();
		s = array;
		return retainAll;
	}

	/* return the size of element in this set
	* @return int
	*/
	public int size() {
		return s.size();
	}

	/*Returns an array containing all of the elements in this set.
	 */
	public Object[] toArray() {
		return s.toArray();
	}

	/*  Returns an array containing all of the elements in this set.
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#toArray(T[])
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		return s.toArray(a);
	}

	//  Returns a string representation of the set.
	public String toString() {
		return s.toString();
	}

	/**
	 * Displays a message followed by success or failure indicating whether or
	 * not a particular test was successful.
	 * 
	 * @param message
	 *            The String form of the message.
	 * 
	 * @param b
	 *            A boolean indicating whether the test was successful or not.
	 * 
	 */

	private static void resultTest(String message, boolean b) {
		if (b) {
			System.out.println(message + " success");
		} else {
			System.out.println(message + " failure");
		}
	}

	/**
	 * Runs a suite of tests to validate the implemenation of BinSet for Integer
	 * elements.
	 * 
	 */

	private static void testInteger() {
		Set<Integer> set = new BinSet<Integer>(Arrays.asList(1, 3));

		resultTest("constructor 1",
				Arrays.equals(set.toArray(), Arrays.asList(1, 3).toArray()));

		set.add(2);
		resultTest("add 1",
				Arrays.equals(set.toArray(), Arrays.asList(1, 2, 3).toArray()));

		resultTest("contains 1", set.contains(1));
		resultTest("contains 2", set.contains(2));
		resultTest("contains 3", set.contains(3));
		resultTest("contains 4", !set.contains(4));

		resultTest("size 1", set.size() == 3);

		set.clear();
		resultTest("clear/size", set.size() == 0);
		resultTest("clear/isEmpty", set.isEmpty());

		set.addAll(Arrays.asList(1, 2, 3));
		resultTest("addAll 1", set.size() == 3);

		resultTest("containsAll 1", set.containsAll(Arrays.asList(3, 2)));
		resultTest("containsAll 2", !set.containsAll(Arrays.asList(4, 3)));

		set.remove(2);
		resultTest("remove 1",
				Arrays.equals(set.toArray(), Arrays.asList(1, 3).toArray()));

		Integer[] a = { 1, 3 };
		int j = 0;
		for (Integer i : set) {
			resultTest("iterator " + i, i.equals(a[j]));
			j++;
		}

		set.retainAll(Arrays.asList(3, 4));
		resultTest("retainAll 1",
				Arrays.equals(set.toArray(), Arrays.asList(3).toArray()));

		resultTest("toArray(array) 1", Arrays.equals(
				set.toArray(new Integer[0]), Arrays.asList(3).toArray()));
	}

	/**
	 * The main method for BinSet. It runs any test scaffolding methods such as
	 * testInteger.
	 * 
	 * @param args
	 *            Command line arguments are not used.
	 * 
	 */

	public static void main(String[] args) {
		testInteger();
	}

}