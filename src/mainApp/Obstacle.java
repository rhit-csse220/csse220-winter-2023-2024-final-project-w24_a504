package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Obstacle {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Color color;
	
	public void Barrier(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

}
	
	public void drawOn(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect(10,5,10,10);
	}
}