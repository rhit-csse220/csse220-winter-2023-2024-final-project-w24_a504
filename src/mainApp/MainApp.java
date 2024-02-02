package mainApp;
import javax.swing.JFrame;
import java.awt.Dimension;

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
        MainAppComponent panel = new MainAppComponent(PANEL_HEIGHT, PANEL_WIDTH,frame, startingLevel);
        panel.setPreferredSize(new Dimension(PANEL_HEIGHT, PANEL_WIDTH));
      
       
		
        try {
        	panel.loadLevel();
        } catch(InvalidLevelFormatException e) {
        	System.err.print("One of the strings are off by " + e.distanceOff());
        }
        
        MainKeyboardListener key = new MainKeyboardListener(panel);
        frame.addKeyListener(key);
        panel.addKeyListener(key);
        panel.setFocusable(true);
        
        frame.add(panel);
        frame.pack();
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