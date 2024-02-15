package mainApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.JFrame;

public class Level {
	private static final int ITEM_WIDTH = 100;
	private static final int ITEM_HEIGHT = 90;
	public ArrayList<Obstacle> obstacles =  new ArrayList<>();;
//	private static final int NUMBER_OF_LEVELS = 5;
	public int levelIndexer = 1;
	public Player player;
	private boolean isPressed;
	public JFrame frame;
	public int gameState = 0;
	private double numberOfCoins = 0;
	public Level(JFrame frame) {
		this.frame = frame;
		 player = new Player(0, 0, this.frame);
		 System.out.println(player.getLives());
		 
//		 obstacles = new Obstacle(0,0, Color.BLACK);
//		 missile = new Missile(0,0, this.frame);
	}
	public void readFile(String FileName) throws InvalidLevelFormatException {
		Scanner scanner = null;
		File file = null;
		try {
			file = new File(FileName);
			scanner = new Scanner(file);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			File Folder = file.getParentFile();
			System.out.print("error");
			System.exit(0);
		}
		String name = scanner.nextLine();
		int row = 0;
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			for(int j = 0; j < line.length(); j++) {
				if(line.charAt(j) == 'B') {
					Obstacle newBarrier = new Barrier((j * ITEM_WIDTH), row * ITEM_HEIGHT);
				    this.obstacles.add(newBarrier);
				    
				  //  System.out.println("Barrier at X: " + newBarrier.getX() + " Y: " + newBarrier.getY());
				}
				else if (line.charAt(j) == 'P') {
					player.setX(j* ITEM_WIDTH);
					player.setY(row* ITEM_HEIGHT);
				}
				else if (line.charAt(j) == 'C') {
					Obstacle newCoin = new Coin(j* ITEM_WIDTH, row * ITEM_HEIGHT);
					this.obstacles.add(newCoin);
					
				}else if (line.charAt(j) == 'E') {
					Obstacle newElectrifiedBarrier = new ElectrifiedBarrier(j* ITEM_WIDTH, row * ITEM_HEIGHT);
					//System.out.println("E");
					this.obstacles.add(newElectrifiedBarrier);
					
				}else if (line.charAt(j) == 'M') {
					Obstacle newMissile = new Missile(j* ITEM_WIDTH, row * ITEM_HEIGHT);
					//System.out.println("E");
					this.obstacles.add(newMissile);
//					missile.setX(j* ITEM_WIDTH);
//					missile.setY(row* ITEM_HEIGHT);
				}else if (line.charAt(j) == 'Y') {
					Obstacle newMissileY = new MissileY(j* ITEM_WIDTH, row * ITEM_HEIGHT);
					//System.out.println("E");
					this.obstacles.add(newMissileY);
//					missile.setX(j* ITEM_WIDTH);
//					missile.setY(row* ITEM_HEIGHT);
				}
			}
			row++;
		}
		scanner.close();
	}
	public boolean gameOver() {
		return (this.levelIndexer <= 2 && player.getX() >= 800) ;
			
	}
	public void nextLevel() {
		if (player.getX() >= 800 && levelIndexer == 1) {
			try {
				this.readFile("levels/level2.txt");
				levelIndexer++;
				System.out.println(levelIndexer);
			} catch (InvalidLevelFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getIndex() {
		System.out.println(levelIndexer);
		return this.levelIndexer;
	}
	public boolean getIsPressed() {
		return this.isPressed;
	}
	public Player getPlayer() {
	return this.player;
}
	public ArrayList<Obstacle> createLevel(){
		return this.obstacles;
	}
	
	public void playerCollision() {
		int numOfObjectsOnPlayer = 0;
		for(Obstacle objects : obstacles) {
			if(player.playerHitBox().intersects(objects.obstacleHitBox())) {
				objects.onCollision(player);
				numOfObjectsOnPlayer ++;
//				obstacles.remove(objects);
				if(objects instanceof Coin) {
					numberOfCoins += .5;
//					obstacles.remove(objects);
//					System.out.println("I've hit a coin");
				}
				if(objects instanceof Barrier) {
					player.collideWithBarrier(objects);
//					System.out.println("I've hit a barrier");

				}
				else if(!(objects instanceof Coin )){
//					System.out.println("I've been hit");
					player.loseLife();
					if(player.lives == 0) {
						System.exit(0);
					}
					
					player.setX(0);
					player.setY(800);
					
				}
			}
			
		}
		if(numOfObjectsOnPlayer == 0) {
			player.setIsMoveable(true);
//			System.out.println("Should set to true");
		}
	}
	public void resetCoins() {
		// TODO Auto-generated method stub
		this.numberOfCoins = 0;
	}
	
public void restartGame() {
	this.levelIndexer = 1;
	this.player.lives = 3;
	this.resetCoins();
}
	public void drawnOn(Graphics2D g) {
		Graphics2D g2 = (Graphics2D)g;
//		player.drawnOn(g2);
		if(this.gameState == 0) {
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 100));
			g2.drawString("JET PACK JOY RIDE", 5, 500);
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g2.drawString("Press Space To Start", 300, 600);
			
		}else if (this.gameState == 1){
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
			g2.drawString("Number of Lives: " + player.getLives() , 50, 50);
			g2.drawString("Number of Coins: " + this.numberOfCoins , 300, 50);
		player.drawnOn(g2);
		for(Obstacle o : obstacles) {
			if(o.Draw){
				o.drawnOn(g2);
			}
		//	System.out.println("level x " + o.x + "level y " + o.y );
		}
	
		}
		if(gameOver() == true) {
			System.out.println("This works");
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g2.drawString("Winner!"  , 100, 100);
			System.out.println("gameOver");
			gameState = 0;
		}
}
	
}