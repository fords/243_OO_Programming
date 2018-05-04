import java.util.*;

public class CollectionTests {

    public static void main(String[] args) {

	// programming to the interface:
	List<String> words = new ArrayList<String>();
	words.add("Friday");
	words.add("early");
	words.add("coffee");
	words.add("coffee");

	//	Collections.shuffle(words);

	Collections.sort(words,new StringLengthComp());

	for (String s : words) {
	    System.out.println(s);
	    //if (s.length() == 6)
	    //  words.remove(s);
	}

	Iterator<String> it = words.iterator();
	
	while (it.hasNext()) {
	    String s = it.next();
	    if (s.length() == 5)
		it.remove();
	}

	Collections.sort(words);

	System.out.println("foreach loop:");
	for (String s : words) {
	    System.out.println(s);
	}

	for (Iterator<String> anotherIt = words.iterator();
	     anotherIt.hasNext(); ) {
	    String s = anotherIt.next();
	    System.out.println(s);
	}


	// if you want to use special methods, can't program
	// to the interface
	LinkedList<String> morewords = new LinkedList<String>();

	morewords.add("zebra");
	morewords.addFirst("aardvark");

	System.out.println("-------set---------");

	// programming to the interface:
	SortedSet<String> swords = new TreeSet<String>();
	swords.add("Friday");
	swords.add("early");
	swords.add("cabbage");
	swords.add("duck");
	swords.add("apple");
	System.out.println(swords.add("coffee"));
	System.out.println(swords.add("coffee"));

	for (String s : swords.tailSet("cat")) {
	    System.out.println(s);
	}

	// maps have two generic parameters, key type then value type
	Map<String,Integer> phoneBook = new HashMap<String,Integer>();

	phoneBook.put("Butler",6155);
	phoneBook.put("Office",3005);
	phoneBook.put("Robot Lab",3405);

	for (String name : phoneBook.keySet()) {
	    System.out.println(name + ": " + phoneBook.get(name));
	}

	for (Map.Entry<String,Integer> entry : phoneBook.entrySet()) {
	    System.out.println(entry.getKey() + ": " + entry.getValue());
	}
    }

}
