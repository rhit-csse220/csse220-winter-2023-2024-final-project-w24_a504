
package mainApp;
import java.awt.Color;
import java.awt.Graphics2D;
public class Barrier extends Obstacle {
	private final static Color BARRIER_COLOR = Color.red;
	public Barrier(int x, int y) {
		super(x, y, BARRIER_COLOR);
	}

}
