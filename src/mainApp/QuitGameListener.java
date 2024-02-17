package mainApp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class QuitGameListener implements ActionListener {
private JFrame main;

public QuitGameListener(JFrame main) {
	this.main = main;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.main.dispatchEvent(new WindowEvent(this.main, WindowEvent.WINDOW_CLOSING));
	}

}
