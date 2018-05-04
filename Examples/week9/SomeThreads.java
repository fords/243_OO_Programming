public class SomeThreads {

    public static void main(String[] args) {

	PrintChar pc1 = new PrintChar('a', 5000);
	// don't do this:
	// pc1.run();
	// do this instead:
	pc1.start();
	
	PrintChar pc2 = new PrintChar('w',3000);
	// If this is commented out, no w's will appear:
	pc2.start();

	(new PrintChar('g',4000)).start();

	// let's wait for some of those threads to finish first.
	/*
	while (pc1.isAlive() || pc2.isAlive()) {
	    // twiddle thumbs
	    System.out.println("Twiddling thumbs...");
	    // or better yet, give back our time
	    // Thread.yield();
	    // or we could sleep for a while
	    try {
		Thread.sleep(500);
	    } catch (InterruptedException e) {
		System.out.println("This should never happen.");
	    }
	}
	*/

	// if we just want to wait, there's a better way:
	try {
	    pc1.join();
	    pc2.join();
	} catch (InterruptedException e) {
	    System.out.println("This should never happen.");
	}

	// now I continue my own business:
	for (int i = 0; i < 50; i++) {
	    System.out.println(i);
	}
    }

}

