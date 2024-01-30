package mainApp;

import javax.swing.JFrame;

/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	
	
	private void runApp() {
		System.out.println("Write your cool arcade game here!");	
		System.out.println("Write your cool arcade game here!");	
		System.out.println("Write your cool arcade game here!");
		final String frameTitle = "Graphics Display";
        final int frameWidth = 1000;
        final int frameHeight = 600;
        final int frameXLoc = 200;
        final int frameYLoc = 100;

        // Creating the JFrame
        JFrame frame = new JFrame();
        frame.setTitle(frameTitle);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(frameXLoc, frameYLoc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();
		//test
	} // main

}