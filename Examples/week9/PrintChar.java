public class PrintChar extends Thread {

    private char myChar;
    private int numTimes;

    public PrintChar(char c, int i) {
	myChar = c;
	numTimes = i;
    }

    public void run() {

	for (int t = 0; t < numTimes; t++) {
	    System.out.println(myChar);
	}

	// what if I wanted to update my GUI (if I had one)?
	// create a runnable thing but put it back on the
	// event handling thread
	// SwingUtilities.invokeLater(thatRunnableGUIModifyingThing);
    }

}