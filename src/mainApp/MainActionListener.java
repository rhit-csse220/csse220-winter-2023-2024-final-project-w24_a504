package mainApp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainActionListener implements ActionListener{
	private MainAppComponent screen;
	
	public MainActionListener(MainAppComponent element) {
		this.screen = element;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.screen.update();
		this.screen.drawScreen();
	}

}
