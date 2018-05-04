import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleWin extends JFrame {

    private JTextField tf;

    public SimpleWin() {
	JButton east = new JButton("East");
	//	SimpleListener sl = new SimpleListener();
	MyListener ml = new MyListener();
	east.addActionListener(ml);
	add(east,BorderLayout.EAST);
	
	JButton west = new JButton("West");
	west.addActionListener(ml);
	add(west,BorderLayout.WEST);

	tf = new JTextField(50);
	add(tf,BorderLayout.CENTER);

	JButton south = new JButton("Make it blue");
	// anonymous class as a listener
	south.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tf.setForeground(Color.BLUE);
		}
	    });
	add(south,BorderLayout.SOUTH);

	// give myself a window listener
	// use the adapter to avoid writing seven methods.
	addWindowListener( new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    // a good place to do cleanup.
		    // but we'll do something annoying instead.
		    JOptionPane.showMessageDialog(null,
						  "You tried to close, you fool.");
		}
	    });

	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
	SimpleWin sw = new SimpleWin();
	sw.pack();
	sw.setVisible(true);
    }

    // inner class as opposed to a separate class
    class MyListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    tf.setText("You pushed the " + e.getActionCommand() + " button.");
	}
    }
}