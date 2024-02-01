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
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

}
	
	public void drawOn(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect(10,5,10,10);
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
	public void update() {
		// TODO Auto-generated method stub
		
	}
}