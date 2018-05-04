public class Vehicle {

    private double miles;
    private double fuel;
    private double mpg;

    public Vehicle(double f, double mpg) {
	miles = 0;
	fuel = f;
	this.mpg = mpg;
    }

    // synchronized here is like synchronized(this) around the whole method
    public synchronized void drive(double dist) {
	double fuelNeeded = dist/mpg;
	// synchronized( this ) {
	    if (fuel > fuelNeeded) {
		try {
		    Thread.sleep(1);
		} catch(InterruptedException e) { /* nothing here */ }
		fuel -= fuelNeeded;
		miles += dist;
	    }
	    //}
    }

    public String toString() {
	return "Miles driven: " + miles + " fuel remaining: " + fuel;
    }

}

	

