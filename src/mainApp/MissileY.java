package mainApp;

import java.awt.Color;

public class MissileY extends Obstacle  {
	private final static Color MISSILE_COLOR = Color.GREEN;
	private double accel = 0;
	private double horizontal_speed = 10;
	private double terminal_velocity  = 10;

	public MissileY(double x, double y) {
		super(x, y, MISSILE_COLOR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void missileMovement() {
		// TODO Auto-generated method stub
		this.accel = this.accel + horizontal_speed;
    	if (this.accel > terminal_velocity) {
    		this.accel = terminal_velocity;
    	}
    	if (getX() <= 970) {
    	setY(getY() + this.accel);
    	}
	}

}
