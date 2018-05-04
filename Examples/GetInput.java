import java.util.Scanner;

public class GetInput {

    public static void main(String[] args) {

	for (String a : args) {
	    System.out.println("An arg is " + a);
	}

	int i = 0;
	while (i < args.length) {
	    System.out.println("Arg number " + i + " is " + args[i]);
	    i += 1;
	}

	// declare our variable:
	Scanner infoGetter;
	
	// make the Scanner object
	infoGetter = new Scanner(System.in);

	String word = infoGetter.next();

	System.out.print("Please type an integer: ");
	int num = infoGetter.nextInt();

	int t = twice(num);

	System.out.println("Twice your number is " + twice(num));
    }

    // return-type func-name(params-with-types) { ... }
    public static int twice(int i) {
	return i*2;
    }
    
}