package mainApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class: MainApp
 * @author W504
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp extends JPanel {
	private Player player; 
	public MainApp() {
        player = new Player(3, 0, 0, 5); // Example starting values
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    player.moveUp();
                }
                if (e.getKeyCode() == KeyEvent.VK_U) {
                    loadLevel("level2.txt"); // Example level change
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    loadLevel("level1.txt"); // Example level change
                }
            }
        });
}
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
        frame.add(this);
        frame.setVisible(true);
		
	} // runApp
	private void loadLevel(String levelFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(levelFile));
            String line;
            while ((line = reader.readLine()) != null) {
               
            }
        } catch (IOException e) {
            System.err.println("Error reading level file: " + e.getMessage());
        }
    }
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }
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