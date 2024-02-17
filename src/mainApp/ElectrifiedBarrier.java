
package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class ElectrifiedBarrier extends Obstacle {
	private final static Color ELECTRICBARRIER_COLOR = Color.CYAN;
	public ElectrifiedBarrier(int x, int y) {
		super(x, y,ELECTRICBARRIER_COLOR );	
	}
	@Override
	public void missileMovement() {
	}
	@Override
	public void toggleMissileDirection() {		
	}
	@Override
	public boolean onCollision(Player player) {
		return false;
	}
}

