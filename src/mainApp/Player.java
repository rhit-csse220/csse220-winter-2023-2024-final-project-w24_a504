package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

/**
 * Class: Player 
 * @author W24_a504
 * Purpose: contains all the code that is relevant to a players functionality 
 */
public class Player {
	private final static Color PLAYER_COLOR = Color.blue;
    protected int lives = 3;
    private double x;
    private double y;
    public JFrame frame;
    private double gravity = 0;
    private double vertical_speed = .2;
    private double terminal_velocity = 5;
    public boolean isMoveable = true;
    public boolean barrierIsHit = false;
    
	/**
	 * ensures: a players parameters are set the values passed in 
	 * @param x players x coordinate
	 * @param y players y coordinate
	 * @param frame allows the player to show in frame 
	 */
	public Player(double x, double y, JFrame frame) {
		this.x = x ;
		this.y = y;
		this.frame = frame;
		
	}
	/**
	 * ensures: the player will have automatic movement once the game starts 
	 * automatic moment in both the x and y direction 
	 */
	public void playerGravity() {	
		if(this.getY() >= 900) {
			this.gravity = 0;
			setY(900);
		}else {
		
		this.gravity = this.gravity + vertical_speed;
    	if (this.gravity > terminal_velocity) {
    		this.gravity = terminal_velocity;
    	}
    	// sets the automatic movement in the y direction
    	setY(getY() + this.gravity);
    	// sets the automatic movement in the x direction
    	setX(getX() + this.gravity);
    	
	}
	}


	@Override
	public String toString() {
		return "player";
	}
	/**
	 * ensures: the player is drawn on the frame
	 * @param g
	 */
	public void drawnOn(Graphics2D g) {
		g.setColor(PLAYER_COLOR);
		Rectangle2D.Double newBox = new Rectangle.Double(this.x,this.y,60,60);
		g.fill(newBox);
		g.draw(newBox);
	}
	
	/**
	 * ensures: a hit box is created for the same dimension has the player 
	 * to allow a collision to be recognized 
	 * @return
	 */
	public Rectangle.Double playerHitBox() {		
	return new Rectangle.Double(this.x,this.y,60,60);
		
	}

	public void setX(double i) {
		this.x = i;
		
	}
	public void setY(double i) {
		this.y = i;
		
	}
	public void setLives(int life) {
		this.lives = life;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public int getLives() {
		return lives;
	}
	
	public void loseLife () {
		this.setLives(this.getLives()- 1);

	}
	/**
	 * ensures: returns if a player should move or not 
	 * @return
	 */
	public boolean isMoveable() {
		return isMoveable;
	}
	/**
	 * ensures: allows a change in state if the player should or should not be 
	 * to move.
	 * @param moveable
	 */
	public void setIsMoveable(boolean moveable) {
		this.isMoveable = moveable;
		
	}
	/**
	 * ensures: a player hit box  has come into contact with a not 
	 * electrified barrier
	 * @param objects
	 */
	public void collideWithBarrier(Obstacle objects) {
		this.barrierIsHit = true;
		if(this.getY() + 60 - objects.getY() <= 10) {
			this.setY(objects.getY() - 60);
		}
		if(this.getX() + 60 - objects.getX() <= 10) {
			this.setX(objects.getX() - 60);
		}
	}

}