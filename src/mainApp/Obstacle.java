package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
public abstract class Obstacle {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Color color;
	protected int VelX;
	protected int VelY;
	protected Rectangle2D.Double rectangle;
	protected boolean loadNextLevel;
	protected boolean Draw;
	
	
	public Obstacle(int x, int y, int width, int height, int VelX, int VelY, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
      	this.VelX = VelX;
		this.VelY = VelY;
		this.color = color;
		this.rectangle = new Rectangle2D.Double(this.x, this.y, this.width, this.height);
		this.Draw = true;
		this.loadNextLevel = false;
	}
	
	public void drawOn(Graphics2D g) {
		g.setColor(this.color);
		g.fillRect(this.x,this.y,this.width,this.height);
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public int getVelX() {
		return this.VelX;
	}
	public int getVelY() {
		return this.VelY;
	}
	public Color getColor() {
		return this.color;
	}
	public void setVelX(int num) {
		this.VelX = num;
	}
	public void setVelY(int num) {
		this.VelY = num;
	}
	public void setX(int num) {
		this.x = num;
	}
	public void setY(int num) {
		this.y = num;
	}
	public void update() {
		// TODO Auto-generated method stub
		
	}
}