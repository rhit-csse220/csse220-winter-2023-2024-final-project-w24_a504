package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;

public class NewGameListener implements ActionListener {
private JFrame frame;
private Level level;
private String FileName;

public NewGameListener(Level level, JFrame frame ) {
	this.frame = frame;
	this.level = level;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.level.restartGame();
		try {
			
			this.level.readFile(FileName);
			
		}catch(InvalidLevelFormatException e1) {
			System.err.println("File not found!");
			System.exit(0);
		}
this.frame.setFocusable(true);
	}

}
