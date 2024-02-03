package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
public abstract class Obstacle {
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected Color color;
	protected double VelX;
	protected double VelY;
	protected Rectangle2D.Double rectangle;
	protected boolean loadNextLevel;
	protected boolean Draw;
	private int size;

	
	
	public Obstacle(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.VelY = 0;
		this.VelX = 0;
		this.size = 25;
		this.color = color;		
	
	}
	
	public void drawnOn(Graphics2D g) {
		g.setColor(this.color);
		Rectangle2D.Double newBox = new Rectangle.Double(x,y,50,50);
		g.fill(newBox);
		g.draw(newBox);
		
//		g.setColor(this.color);
//		Ellipse2D.Double newCoin = new Ellipse2D.Double(x, y, 10,10);
//		g.fill(newCoin);
	}
	
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public double getVelX() {
		return this.VelX;
	}
	public double getVelY() {
		return this.VelY;
	}
	public Color getColor() {
		return this.color;
	}
	public void setVelX(double num) {
		this.VelX = num;
	}
	public void setVelY(double num) {
		this.VelY = num;
	}
	public void setX(double d) {
		this.x = d;
	}
	public void setY(double d) {
		this.y = d;
	}
	protected int getSize() {
		return size;
	}
	protected void setSize(int size) {
		this.size = size;
	}
	public void update() {
		// TODO Auto-generated method stub
		this.x += VelX;
		this.y += VelY;
		
	}
}