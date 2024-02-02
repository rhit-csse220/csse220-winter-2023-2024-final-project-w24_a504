package mainApp;

import java.awt.Color;

public class Player extends Obstacle {

	protected int frameWidth;
	protected int frameHeight;
	protected static int MAX_SPEED = 20;
	protected static int MIN_SPEED = 0;
	public static int ACCEL = 2;
	//TODO
//	protected int numOfCoins;
//	protected int numOfLives;
	// private boolean dead;
	
	public Player(int x, int y, int width, int height, int VelX, int VelY, Color color, int frameWidth, int frameHeight, int ACCEL) {
		super(x, y, width, height, VelX, VelY, color);
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}
	
	@Override
	public void update() {
		if(this.getVelY() >= MIN_SPEED && this.getVelY() <= MAX_SPEED) {
			this.setVelY(this.getVelY()+ this.ACCEL);
		}
		if(this.getY() < 0) {
			this.setY(0);
		}
		if(this.getVelX() + this.getWidth() > this.frameWidth) {
			this.setY(this.frameWidth - this.getWidth());
		}
		if(this.getY()+ this.getHeight() > this.frameHeight) {
			this.setY(this.frameHeight - this.getHeight());
		}
	}
	@Override
	public String toString() {
		return "player";
	}
    
}