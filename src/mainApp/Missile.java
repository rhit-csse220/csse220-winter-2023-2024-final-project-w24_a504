package mainApp;

import java.awt.Color;

import javax.swing.JFrame;

public class Missile extends Obstacle  {
	private final static Color MISSILE_COLOR = Color.darkGray;
	private double accel = 0;
	private double horizontal_speed = 10;
	private double terminal_velocity  = 10;
	private double y;
	private double x;
	private JFrame frame;
	public Missile(double x, double y) {
		super(x, y, MISSILE_COLOR);
//		this.x = x;
//		this.y = y;
//		this.frame = frame;
		// TODO Auto-generated constructor stub
	}
	
	public void missileMovement() {		
		this.accel = this.accel + horizontal_speed;
    	if (this.accel > terminal_velocity) {
    		this.accel = terminal_velocity;
    	}
    	if (getX() <= 970) {
    	setX(getX() - this.accel);
    	}
	}

//	public void setX(double i) {
//		// TODO Auto-generated method stub
//		this.x = i;
//		
//	}
//	public void setY(double i) {
//		// TODO Auto-generated method stub
//		this.y = i;
//		
//	}
//	public double getX() {
//		// TODO Auto-generated method stub
//		return x;
//	}
//	public double getY() {
//		// TODO Auto-generated method stub
//		return y;
//	}
}
