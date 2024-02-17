package mainApp;

import java.awt.Color;

public class MissileY extends Obstacle  {
	private final static Color MISSILE_COLOR = Color.GREEN;
	private double accel = 0;
	private double horizontal_speed = .2;
	private double terminal_velocity  = 5;
	public double dy;

	public MissileY(double x, double y) {
		super(x, y, MISSILE_COLOR);
	}

	public void toggleMissileDirection() {
		this.dy *= -1;
	}

	@Override
	public void missileMovement() {
		if ( getY() > 1000 - 50 ) {
			setY(this.dy*(1000-50));
	} else if (getY() < 0 ) {
		setY(0);
	}
		this.accel = this.accel + horizontal_speed;
    	if (this.accel > terminal_velocity) {
    		this.accel = terminal_velocity;
    	}
    	if (getX() <= 970) {
    	setY(getY() + this.accel);
    	}
	}



	@Override
	public boolean onCollision(Player player) {
		return false;
	}

}
