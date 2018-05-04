public class DriveACar {

    public static void main(String[] args) {

	// declare a variable of type Vehicle:
	Vehicle v;
	// construct the Vehicle object with certain parameters
	v = new Vehicle(110,30);
	v.turnOn();
	v.accelerate(50);
	v.drive();
	System.out.println("Traveling at " + v.getSpeed() + " mph.");

	Vehicle scooter = new Vehicle(2,60,100);
	System.out.println(scooter);

	Vehicle otherScooter = new Vehicle(2,60,100);
	System.out.println(otherScooter);

	System.out.println("equal? " + (scooter == otherScooter));
	System.out.println("equal? " + (scooter.equals(otherScooter)));
	String s1 = new String("hello");
	String s2 = new String("hello");
	System.out.println("string equal? " + (s1 == s2));
	System.out.println("string equal? " + (s1.equals(s2)));
	

    }

}