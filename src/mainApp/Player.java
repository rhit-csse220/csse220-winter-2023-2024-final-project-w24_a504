package mainApp;

import java.awt.Color;

public class Player extends Obstacle {

	protected int frameWidth;
	protected int frameHeight;
	protected static int MAX_SPEED = 20;
	protected static int MIN_SPEED = 0;
	//TODO
//	protected int numOfCoins;
//	protected int numOfLives;
	// private boolean dead;
	
	public Player(int x, int y, int width, int height, int velX, int velY, Color color, int frameWidth, int frameHeight) {
		super(x, y, width, height, velX, velY, color);
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}
    
}