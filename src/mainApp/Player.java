package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

public class Player {
	private final static Color PLAYER_COLOR = Color.blue;
	private static final int MOVE_INCREMENT = 15;
	protected static int MAX_SPEED = 20;
	protected static int MIN_SPEED = 0;
	public static int ACCEL = 3;
	private int lastMoveX = 0; 
    private int lastMoveY = 0;
    private int x;
    private int y;
    public JFrame frame;
    

	
	public Player(int x, int y, JFrame frame) {
//		super(x, y,PLAYER_COLOR);
		this.x = x;
		this.y = y;
		this.frame = frame;
		
	}


	@Override
	public String toString() {
		return "player";
	}

	public void drawnOn(Graphics2D g) {
		g.setColor(PLAYER_COLOR);
		Rectangle2D.Double newBox = new Rectangle.Double(this.x,this.y,60,60);
		//System.out.println("Obstacle x " + x + "Obstacle y" + y);
		g.fill(newBox);
		g.draw(newBox);
		
	}

	public void setX(int i) {
		// TODO Auto-generated method stub
		this.x = i;
		
	}
	public void setY(int i) {
		// TODO Auto-generated method stub
		this.y = i;
		
	}
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

}