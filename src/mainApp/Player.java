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
    private double x;
    private double y;
    private int playerMovement = 10;
    public JFrame frame;
    private double gravity = 0;
    private double vertical_speed = 1;
    private double terminal_velocity = 300;
	
	public Player(double x, double y, JFrame frame) {
//		super(x, y,PLAYER_COLOR);
		this.x = x ;
		this.y = y;
		this.frame = frame;
		
	}
	public void playerGravity() {		
		this.gravity = this.gravity + vertical_speed;
    	if (this.gravity > terminal_velocity) {
    		this.gravity = terminal_velocity;
    	}
    	setY(getY() + this.gravity);
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

	public void setX(double i) {
		// TODO Auto-generated method stub
		this.x = i;
		
	}
	public void setY(double i) {
		// TODO Auto-generated method stub
		this.y = i;
		
	}
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

}