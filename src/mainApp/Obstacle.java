package mainApp;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * Class: Abstract class for Obstacle
 * @author W24_a504
 * Purpose: holds most of the code for each obstacle 
 * to limit code duplication since all obstacles share 
 * similar code 
 */
public abstract class Obstacle {
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected Color color;
	protected Rectangle2D.Double rectangle;
	protected boolean loadNextLevel;
	protected boolean Draw;

	
	/**
	 * ensures: initializes the bounding rectangle used for each game obstacle
	 * @param x used to initialize the obstacle's x position
	 * @param y used to initialize the obstacle's y position
	 * @param color used to initialize the obstacle's unique color
	 */
	public Obstacle(double x, double y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;	
		this.Draw = true;
	
	}
	/**
	 * Abstract methods for collision detecting and missile movement 
	 */
	public abstract void missileMovement(); 
	public abstract void toggleMissileDirection(); 	
	public abstract boolean onCollision(Player player);
	
	/**
	 * ensures: the obstacles are drawn on the frame
	 * @param g
	 */
	public void drawnOn(Graphics2D g) {
		g.setColor(this.color);
		Rectangle2D.Double newBox = new Rectangle.Double(x,y,60,30);
		g.fill(newBox);
		g.draw(newBox);
		
	}
	/**
	 * ensures: the hit box is of the same size as the obstacle 
	 * @return
	 */
	public Rectangle2D.Double obstacleHitBox() {
		return new Rectangle2D.Double(this.x,this.y,60,30);
			
		}
	
	public boolean getDraw() {
		return this.Draw;
	}
	/**
	 * ensures: gets the obstacles x position and returns it
	 * @return
	 */
	public double getX() {
		return this.x;
	}
	/**
	 * ensures: gets the obstacles Y position and returns it
	 * @return
	 */
	public double getY() {
		return this.y;
	}
	/**
	 * ensures: gets the obstacles width
	 * @return
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * ensures: gets the obstacles height
	 * @return
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * ensures: gets the obstacles unique color
	 * @return
	 */
	public Color getColor() {
		return this.color;
	}
	/**
	 * ensures: sets the obstacles x position this is passed in
	 * @param d
	 */
	public void setX(double d) {
		this.x = d;
	}
	/**
	 * ensures: sets the obstacles y position this is passed in
	 * @param d
	 */
	public void setY(double d) {
		this.y = d;
	}
	/** 
	 * ensures: negates the draw method for the obstacle so a coin
	 * will be removed from the frame after collection
	 */
	public void toggleDraw() {
		this.Draw = !this.Draw;

	}	
}