import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUICountView extends JFrame implements ViewControl {

    private JTextField tf;
    private final Counter model;

    public GUICountView(Counter model) {
	this.model = model;
	model.setView(this);

	JButton east = new JButton("+");
	east.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    GUICountView.this.model.bump(Direction.up);
		}
	    });
	add(east,BorderLayout.EAST);
	
	JButton west = new JButton("-");
	west.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    GUICountView.this.model.bump(Direction.down);
		}
	    });
	add(west,BorderLayout.WEST);

	tf = new JTextField(10);
	add(tf,BorderLayout.CENTER);

    }

    public void updateValue(int value) {
	tf.setText("" + value);
    }

    public static void main(String[] args) {
	Counter c = new Counter();
	GUICountView cv = new GUICountView(c);
	cv.setVisible(true);
    }
}
