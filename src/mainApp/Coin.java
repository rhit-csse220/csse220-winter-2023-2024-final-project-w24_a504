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
	}
	@Override
	public void missileMovement() {	
	}
	@Override
	public void toggleMissileDirection() {	
	}
	@Override
	public boolean onCollision(Player player) {
		if(!this.isCollected) {
			this.toggleDraw();
			this.isCollected = true;
		}
		return false;
	}
	

}

