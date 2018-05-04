import java.awt.event.*;

public class SimpleListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
	System.out.println("You pushed the " + e.getActionCommand() + " button.");
    }
}
