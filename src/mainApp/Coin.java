package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class Coin extends Obstacle {
	public boolean isCollected;
	private final static Color COIN_COLOR = Color.yellow;
	public Coin(int x, int y) {
		super(x, y, COIN_COLOR);
		this.isCollected = false;
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public void drawOn(Graphics2D g) {
//		// TODO Auto-generated method stub
//		
//	}
	@Override
	public void missileMovement() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void toggleMissileDirection() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onCollision(Player player) {
		// TODO Auto-generated method stub
		if(!this.isCollected) {
			this.toggleDraw();
			this.isCollected = true;
		}
		return false;
	}
	

}
