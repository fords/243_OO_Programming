import javax.swing.*;
import java.awt.*;

public class EmacsWindow extends JFrame {

    public EmacsWindow() {

	// make top row of stuff
	JPanel toprow = new JPanel();
	toprow.add(new JButton("New"));
	toprow.add(new JButton("Open"));
	toprow.add(new JLabel("..."));
	toprow.add(new JButton("Help"));

	add(toprow,BorderLayout.NORTH);

	// center is some text
	add(new JTextArea(10,80));

	// bottom is some sort of label?
	add(new JLabel("File name here"),BorderLayout.SOUTH);

    }

    public static void main(String[] args) {

	EmacsWindow ew = new EmacsWindow();
	ew.pack();
	ew.setVisible(true);
    }
}