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
	
	private void runApp() {

        JFrame frame = new JFrame("JPJR");
        frame.setSize(1000,1000);
        MainAppComponent component = new MainAppComponent();
        Timer timer = new Timer(15, new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		component.update();
        	}
        });
        timer.start();
        
        frame.add(component, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	} // runApp
	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();
		
	} // main
}