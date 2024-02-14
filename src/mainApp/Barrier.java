
package mainApp;
import java.awt.Color;
import java.awt.Graphics2D;
public class Barrier extends Obstacle {
	private final static Color BARRIER_COLOR = Color.red;
	public Barrier(int x, int y) {
		super(x, y, BARRIER_COLOR);
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
		player.setIsMoveable(false);
		player.collideWithBarrier(this);
		return false;
	}

}
