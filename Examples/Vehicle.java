public class Vehicle {

    // states - aka instance variables
    // in general, we make these private
    private double speed;
    private double fuelLevel;
    private double maxSpeed;
    private double mpg;
    private int numWheels;
    private int numPass;
    private boolean on;

    // constructor
    // called during construction process
    // generally used to initialize our instance variables
    // not a bad habit to put all instance variables here
    /*
    public Vehicle(double ms, double mpg) {
	maxSpeed = ms;
	this.mpg = mpg;
	numWheels = 4;
	speed = 0;
	fuelLevel = 10;
    }
    */
    // this constructor calls the other one:
    public Vehicle(double ms, double mpg) {
	this(4,ms,mpg);
    }

    // can have multiple constructors:
    public Vehicle(int w, double ms, double mpg) {
	maxSpeed = ms;
	this.mpg = mpg;
	numWheels = w;
	speed = 0;
	fuelLevel = 10;	
    }

    // behaviors - these are functions
    // in general, we make these public
    public void turnOn() {
	on = true;
    }

    public void accelerate(double increment) {
	speed = speed + increment;
	if (speed > maxSpeed) {
	    speed = maxSpeed;
	}
    }

    // this drives for one minute
    public void drive() {
	double distance = speed / 60;
	fuelLevel = fuelLevel - distance/mpg;

	if (fuelLevel <= 0) {
	    System.out.println("Out of gas!");
	    on = false;
	    speed = 0;
	}
    }

    public double getSpeed() {
	return speed;
    }
    
    // String version of object - no printing
    public String toString() {
	return "Vehicle with max speed " + maxSpeed + " and " +
	    fuelLevel + " gallons of gas.";
    }

    public boolean equals(Object other) {
	// two things to worry about:
	// 1. is it of right type?
	if (!(other instanceof Vehicle)) {
	    return false;
	}
	// 2. if so, we want to compare instance vars
	// in order to see them, must cast that object to my type
	Vehicle ov = (Vehicle)(other);
	return (speed == ov.maxSpeed) && (mpg == ov.mpg);
    }
}
