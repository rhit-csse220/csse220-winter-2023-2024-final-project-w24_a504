package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;

public class NewGameListener implements ActionListener {
private JFrame frame;
private Level level;

public NewGameListener(Level level, JFrame frame ) {
	this.frame = frame;
	this.level = level;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.level.restartGame();
		try {	
			this.level.readFile("levels/level1.txt");
			
		}catch(InvalidLevelFormatException e1) {
			System.err.println("File not found!");
			System.exit(0);
		}
this.frame.setFocusable(true);
	}

}
