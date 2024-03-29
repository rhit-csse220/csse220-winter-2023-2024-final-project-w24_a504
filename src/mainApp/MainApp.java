package mainApp;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class: MainApp
 * @author W24_a504
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp{
	public static final int startingLevel = 1;
	
	public MainApp() throws InvalidLevelFormatException {
        JFrame frame = new JFrame("JPJR");
        frame.setSize(1000,1000);
        MainAppComponent component = new MainAppComponent(frame);
        frame.add(component, BorderLayout.CENTER);
        JPanel gameButtons = new JPanel();
        frame.add(gameButtons, BorderLayout.SOUTH);
        
        frame.addKeyListener(new MainKeyboardListener(component.level.player, component.level));
        frame.setFocusable(true);
        
        frame.setVisible(true);
        UpdateActionListener updateListener = new UpdateActionListener(component);
        Timer timer = new Timer(50, updateListener);
        timer.start();
        JButton quitGame = new JButton("Quit Game");
        quitGame.addActionListener(new QuitGameListener(frame));
        gameButtons.add(quitGame);
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new NewGameListener(component.level, frame));
        gameButtons.add(newGame);
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