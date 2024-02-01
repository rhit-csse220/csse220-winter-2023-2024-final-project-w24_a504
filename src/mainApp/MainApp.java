package mainApp;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class: MainApp
 * @author W504
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp extends JPanel {
	private ArrayList<Obstacle> Obstacles;
	private Player player; 
	private int levelNum;
	private int screenHeight;
	private int screenWidth;
	private JFrame On;
	private int Lives = 3;
	private boolean objects = false;
	private static final int TILES_ON_SCREEN = 16;
	private static final int TILES_ON_LEVEL = 64;
	private static final Color TOKEN_COLOR = (Color.YELLOW);
	private int tokens = 0;
	
	private static final int delay = 35;
	private static final int PANEL_Height = 800;
	private static final int PANEL_Width = 800;
	public static final int startingLevel = 1;
	
	private void runApp() {

        JFrame frame = new JFrame("JPJR");
        MainApp panel = new MainApp(PANEL_Height, PANEL_Width,frame, startingLevel);
        panel.setPreferredSize(new Dimension(PANEL_Height, PANEL_Width));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
		
        try {
        	panel.loadLevel();
        } catch(InvalidLevelFormatException e) {
        	System.err.print("One of the strings are off by " + e.distanceOff());
        }
        KeyboardListener key = new KeyboardListener(panel);
        frame.addKeyListener(key);
        panel.addKeyListener(key);
        panel.setFocusable(true);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // runApp
	 private void loadLevel()throws InvalidLevelFormatException {
	        Scanner scanner = null;
	        this.objects = true;
	        this.Obstacles.clear();
	        
	        try {
	            scanner = new Scanner(new File("Level"+ levelNum + ".txt"));
	        } catch (FileNotFoundException e) {
	            System.err.println("Level file not found");
	            System.exit(0);
	        } 
	        int line = 0;
	        while(scanner.hasNextLine()) {
	        	String current = scanner.nextLine();
	        	if(current.length() != TILES_ON_LEVEL) {
	        		throw new InvalidLevelFormatException(current.length() - TILES_ON_LEVEL);
	        	}
	        	for(int j = 0; j < current.length(); j++) {
	        		char currentChar = current.charAt(j);
	        	
	        	if(currentChar == 'B') {
	        		this.Obstacles.add(new Barrier(j * this.screenWidth / TILES_ON_SCREEN,
	        				line * this.screenHeight / TILES_ON_SCREEN,0, 0,
	        				this.screenWidth / TILES_ON_SCREEN,
	        				this.screenWidth / TILES_ON_SCREEN, Color.BLACK));
	        	}else if (currentChar == 'T') {
	        		// add code to add token
	        		this.Obstacles.add(new Coin(j* this.screenHeight / TILES_ON_SCREEN,
	        				line * this.screenHeight / TILES_ON_SCREEN , 0 , 0, 
	        				this.screenWidth / TILES_ON_SCREEN,
	        				this.screenWidth / TILES_ON_SCREEN, TOKEN_COLOR));
	        	}else if (currentChar == 'E') {
	        		// add code to add elec barrier
	        	}else if (currentChar == 'P') {
	        		this.player = new Player(j * this.screenWidth / TILES_ON_SCREEN,
	        				line * this.screenHeight / TILES_ON_SCREEN, 2, 0,
	        				(this.screenHeight / TILES_ON_SCREEN) / 2,
	        				this.screenHeight / TILES_ON_SCREEN, Color.RED, this.screenWidth,
	        				this.screenHeight, 0 );
	        	}
	        }
	        	line++;
	      }
	        this.objects = false;
	        scanner.close();
	 }
	 public MainApp(int panelHeight, int panelWidth, JFrame frame, int startingLevel ) {
		 this.PANEL_Height = panelHeight;
		 this.PANEL_Width = panelWidth;
		 this.Obstacles = new ArrayList<Obstacle>();
		 this.On = frame;
		 this.setLevel(startingLevel);
	 }
	        
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }
	
	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();
		
	} // main
	public Player getPlayer() {
		return this.player;
	}
	
	public class KeyboardListener implements KeyListener{
		private MainApp component;
		private static final int NUMBER_OF_LEVELS_ = 5;
		private static final int BARRY_INITIAL_Y = 0;
		private static final int BARRY_VEL = -15;
	
		
		public KeyboardListener(MainApp component) {
			this.component = component;
		}
		@Override
		public void keyPressed(KeyEvent e) { 
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				this.component.getPlayer().setVelY(BARRY_VEL);
			}
			if(e.getKeyCode() == KeyEvent.VK_U) {
//				if(this.component.getlev)
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}