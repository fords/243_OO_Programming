import java.awt.*;
import javax.swing.*;

public class SimpleGUI {

    public static void main(String[] args) {

	// construct window object
	JFrame myWindow = new JFrame("My awesome window");

	// fill up the window

	JButton b = new JButton("Push me!");

	myWindow.add(b,BorderLayout.NORTH);

	JButton center = new JButton("Center!");
	JButton reallycenter = new JButton("Really center!");
	center.add(reallycenter);

	myWindow.add(center);

	//	myWindow.setSize(400,300);
	myWindow.pack();
	// can also do EXIT_ON_CLOSE if only one window
	myWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	// Go!
	myWindow.setVisible(true);

	JFrame another = new JFrame("Another window");
	another.setLayout(new GridLayout(2,2));
	another.add(new JButton("B1"));
	another.add(new JButton("B2"));
	another.add(new JTextField("Here is some text"));
	another.add(new JLabel("Just some text."));

	another.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	another.pack();
	another.setVisible(true);

	System.out.println("The end of main.");
    }

}