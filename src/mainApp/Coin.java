package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Coin extends Obstacle {

	public Coin(int x, int y, int width, int height, int velX, int velY, Color color) {
		super(x, y, width, height, velX, velY, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drawOn(Graphics2D g) {
		g.setColor(this.getColor());
		g.fillOval(this.getX(),this.getY(), this.getWidth(), this.getHeight());
	}

}
