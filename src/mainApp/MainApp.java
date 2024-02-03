package mainApp;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class: MainApp
 * @author W504
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp{
	
	private static final int PANEL_HEIGHT = 800;
	private static final int PANEL_WIDTH = 800;
	public static final int startingLevel = 1;
	
	public MainApp() throws InvalidLevelFormatException {

        JFrame frame = new JFrame("JPJR");
        frame.setSize(1000,1000);
        MainAppComponent component = new MainAppComponent(frame);
        frame.add(component, BorderLayout.CENTER);
       
        
        frame.addKeyListener(new MainKeyboardListener(1,component.level.player));
        
        
        frame.setVisible(true);
        UpdateActionListener updateListener = new UpdateActionListener(component);
        Timer timer = new Timer(50, updateListener);
        timer.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	} // runApp
	/**
	 * ensures: runs the application
	 * @param args unused
	 * @throws InvalidLevelFormatException 
	 */
	public static void main(String[] args) throws InvalidLevelFormatException {
		 new MainApp();
	} // main
}