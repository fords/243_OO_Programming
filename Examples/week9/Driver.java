// alternately:
// public class Driver extends Person implements Runnable 
public class Driver extends Thread {

    private Vehicle v;

    public Driver(Vehicle v) {
	this.v = v;
    }

    public void run() {
	for (int i = 0; i < 10; i++) {
	    v.drive(10);
	    try {
		Thread.sleep(1);
	    } catch(InterruptedException e) { }
	}
	System.out.println(v);
    }
}
