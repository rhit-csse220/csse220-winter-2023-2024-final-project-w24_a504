package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainAppComponent extends JPanel {
	private Player player;
	private ArrayList<Obstacle> Obstacles;	
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
	private int panelWidth;
	private int panelHeight;
	
	private static final int PANEL_HEIGHT = 800;
	private static final int PANEL_WIDTH = 800;
	public static final int startingLevel = 1;
	
	public MainAppComponent( ) {
		 //this.panelHeight = panelHeight;
		// this.panelWidth= panelWidth;
		 //this.Obstacles = new ArrayList<Obstacle>();
		 //this.On = frame;
		 this.loadLevel(levelNumber);
		 this.setLevelNum(startingLevel);
		 this.setFocusable(true);
		 this.addKeyListener(player);
		 
	 }
	public Player getPlayer() {
		return this.player;
	}
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
	public int getLevelNum() {
		return levelNum;
	}
	 public void loadLevel(int levelNumber) throws InvalidLevelFormatException {
	        Scanner scanner = null;
	        this.objects = true;
	        
	        try {
	        	File file = new File("/Users/folayaod/git/csse220-winter-2023-2024-final-project-w24_a504/src/mainApp/level1.txt/");
	            scanner = new Scanner(file);
	            
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
	        @Override
	        protected void paintComponent(Graphics g) {
	            Graphics2D g2 = (Graphics2D) g;
	            for(Obstacle object : this.Obstacles) {
	            	object.drawOn(g2);
	            }
	            try {
	            	this.player.drawOn(g2);	
	            }catch(NullPointerException e) {
	            	System.err.print("No Player added");
	            	System.exit(0);
	            }
	        }
	        public void drawScreen() {
	        	this.repaint();
	        	this.On.repaint();
	        }
			public void update() {
				// TODO Auto-generated method stub
				
			}
}
