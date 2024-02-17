package mainApp;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Missile extends Obstacle  {
	private final static Color MISSILE_COLOR = Color.darkGray;
	private double accel = 0;
	private double horizontal_speed = .2;
	private double terminal_velocity  = 5;
	public double dx;
	public Missile(double x, double y) {
		super(x, y, MISSILE_COLOR);
	}
	public void toggleMissileDirection() {
		this.dx *= -1;
	}
	public void missileMovement() {		
		
		if (getX() > 1000 - 50 ) {
				setX(this.dx*(1000-50));
		} else if (getX() < 0 ) {
			setX(900);
		}
		
		this.accel = this.accel + horizontal_speed;
    	if (this.accel > terminal_velocity) {
    		this.accel = terminal_velocity;
    	}
    	if (getX() <= 970) {
    	setX(getX() - this.accel);
    	}
	}
	@Override
	public boolean onCollision(Player player) {
		return false;
	}
}
