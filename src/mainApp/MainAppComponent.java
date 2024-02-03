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
//	private Player player;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();	
	private MainKeyboardListener level = new MainKeyboardListener(1);
	
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
	
	public static final int SCREEN_HEIGHT = 800;
	public static final int SCREEN_WIDTH = 800;
	public static final int startingLevel = 1;
	
	public MainAppComponent( ) {

		 this.setLevelNum(startingLevel);
		obstacles.add(new Player(800,0));
		 this.level.runApp();
		 setFocusable(true);
		 this.addKeyListener((Player)obstacles.get(0));
		 this.levelNum = startingLevel;
		 addKeyListener(this.level);
		 
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
	        	for(int i = 0; i < this.level.createLevel().size(); i++) {
	        		this.level.createLevel().get(i).drawnOn(g2);	        	
	        		}
	        	repaint();
	        

	        }

			public void update() {
				// TODO Auto-generated method stub
				for(int i = 0; i <obstacles.size(); i++) {
					this.obstacles.get(i).update();
				}
				this.repaint();
			}
}
