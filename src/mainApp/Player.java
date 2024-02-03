package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player  extends Obstacle implements KeyListener{
	private final static Color PLAYER_COLOR = Color.blue;
	private static final int MOVE_INCREMENT = 15;
	protected static int MAX_SPEED = 20;
	protected static int MIN_SPEED = 0;
	public static int ACCEL = 2;
	private int lastMoveX = 0; 
    private int lastMoveY = 0;

	
	public Player(int x, int y) {
		super(x, y,PLAYER_COLOR);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
        int currentKey = e.getKeyCode();
        switch (currentKey) {
            case KeyEvent.VK_UP:
                this.setY(this.getY() - MOVE_INCREMENT);
                lastMoveX = 0;
                lastMoveY = -1;
                break;
            case KeyEvent.VK_DOWN:
                this.setY(this.getY() + MOVE_INCREMENT);
                lastMoveX = 0;
                lastMoveY = 1;
                break;
            case KeyEvent.VK_LEFT:
                this.setX(this.getX() - MOVE_INCREMENT);
                lastMoveX = -1;
                lastMoveY = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.setX(this.getX() + MOVE_INCREMENT);
                lastMoveX = 1;
                lastMoveY = 0;
                break;
        }

        System.out.println("Player's new position: X=" + this.getX() + ", Y=" + this.getY());
    }
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	
	@Override
	public void update() {
        // Apply continuous movement based on the last direction moved
        this.setX(this.getX() + lastMoveX * MOVE_INCREMENT);
        this.setY(this.getY() + lastMoveY * MOVE_INCREMENT);

        // Log the automatic update for debugging
        System.out.println("Player auto-updated to: X=" + this.getX() + ", Y=" + this.getY());
    }
	@Override
	public String toString() {
		return "player";
	}

}