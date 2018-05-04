import java.util.LinkedList;

public class Hello { 

    public static void main(String[] args) {

	System.out.println("Hello world");

	// Declare variables before use
	int grade;
	grade = 90;
	/* 
	   Can't redeclare a variable to a different type
	   String grade;
	   grade = "A";
	*/

	// can also declare and use in one statement
	double hightemp = 58; // type conversion hiding here!
	System.out.println("High temp is: " + (hightemp + 2));
	hightemp = 60.5/3;
	System.out.println("High temp is: " + hightemp);

	// to go from double to int needs a cast
	grade = (int)(hightemp + 2);
	System.out.println("Grade is: " + grade);

	boolean passing = true;

	if (passing == true) {
	    System.out.println("Congrats!");
	    System.out.println("You passed.");
	} else {
	    System.out.println("Please try again.");
	}


	while (grade < 70) {
	    System.out.println("Working...");
	    grade = grade + 5;
	}

	String name;
	name = new String("zjb"); // don't need new with Strings

	// but we do need new for other classes
	LinkedList<String> studentNames;
	studentNames = new LinkedList<String>();
	studentNames.add("Bob");
	studentNames.add("Diane");
	
	// foreach loop:
	// Python: for name in studentNames:

	for (String sname : studentNames) {
	    System.out.println(sname + " is in class.");
	}
    }

}
