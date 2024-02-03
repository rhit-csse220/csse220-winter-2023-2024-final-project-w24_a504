package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainAppComponent extends JComponent {
//	public Player player = new Player(0, 0);
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();	
	public Level level;
	
	private int levelNum;
	private int screenHeight;
	private int screenWidth;
	private JFrame frame;
	private int Lives = 3;
	private boolean objects = false;
	private static final int TILES_ON_SCREEN = 16;
	private static final int TILES_ON_LEVEL = 64;
	private static final Color TOKEN_COLOR = (Color.YELLOW);
	private int tokens = 0;
	private int panelWidth;
	private int panelHeight;
	
	public static final int SCREEN_HEIGHT = 800;
	public static final int SCREEN_WIDTH = 800;
	public static final int startingLevel = 1;
	
	public MainAppComponent(JFrame frame) throws InvalidLevelFormatException {
		this.frame = frame;
		level = new Level(frame);
		 this.setLevelNum(startingLevel);
//		obstacles.add(new Player(800,0));
		String NameOfFile = "levels/level1.txt";
		this.level.readFile(NameOfFile);

		 
	 }
	
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
	public int getLevelNum() {
		return levelNum;
	}

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	        	Graphics2D g2 = (Graphics2D) g;
	        	level.drawnOn(g2);
//	        	for(int i = 0; i < this.level.createLevel().size(); i++) {
//	        		this.level.createLevel().get(i).drawnOn(g2);	        	
//	        		}
//	        	frame.repaint();
	        

	        }

			public void update() {
				// TODO Auto-generated method stub
				
				
				this.repaint();
			}
}
