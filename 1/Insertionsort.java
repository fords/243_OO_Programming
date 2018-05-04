import java.util.ArrayList;

public class Insertionsort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// add the integers to arraylist .java accept the argument as integer type. I change this type to string type and call insertionSort function
		ArrayList<Integer> array;
		array = new ArrayList<Integer>();
		for (String a : args) {
			array.add(Integer.parseInt(a));

		}
		insertionSort(array);
	}

	public static void insertionSort(
	// sort the ArrayList and print this
			java.util.ArrayList<java.lang.Integer> array) {
		String d = StringFromArrayList(array);
		System.out.println(d);

		for (int i = 0; i < array.size(); i++) {
			for (int j = i; j > 0; j--) {

				if (array.get(j) < array.get(j - 1)) {
					// swap it

					int a = array.get(j);
					int b = array.get(j - 1);

					array.set(j, b);
					array.set(j - 1, a);

				}
			}
		}

		String a = StringFromArrayList(array);
		System.out.println(a);
	}

	public static String StringFromArrayList(
	// convert the ArrayList to String and return the String 
			java.util.ArrayList<java.lang.Integer> array) {
		String a = "";

		a = "[" + Integer.toString(array.get(0)) + ", ";
		for (int i = 1; i < array.size() - 1; i++) {

			a += Integer.toString(array.get(i)) + ", ";
		}
		a += Integer.toString(array.get(array.size() - 1)) + "]";

		return a;
	}

}
