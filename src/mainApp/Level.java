package mainApp;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * Class: Level
 * @author W24_a504
 * Purpose: runs all methods that make the game function
 */
public class Level {
	private static final int ITEM_WIDTH = 100;
	private static final int ITEM_HEIGHT = 90;
	public ArrayList<Obstacle> obstacles =  new ArrayList<>();;
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
	}
	
	/**
	 * ensures: a a .txt file is loaded in if the an invalid file is loaded 
	 * the flowing error will throw also makes sure the level is drawn on the screen
	 * @param FileName
	 * @throws InvalidLevelFormatException
	 */
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
					this.obstacles.add(newElectrifiedBarrier);
				}else if (line.charAt(j) == 'M') {
					Obstacle newMissile = new Missile(j* ITEM_WIDTH, row * ITEM_HEIGHT);
					this.obstacles.add(newMissile);
				}else if (line.charAt(j) == 'Y') {
					Obstacle newMissileY = new MissileY(j* ITEM_WIDTH, row * ITEM_HEIGHT);
					this.obstacles.add(newMissileY);

				}
			}
			row++;
		}
		scanner.close();
	}
	
	/**
	 * ensures: checks is the player has reached the far right side of the 
	 * screen on the last level and ends the game
	 * @return
	 */
	public boolean gameOver() {
		return (this.levelIndexer <= 2 && player.getX() >= 950) ;
			
	}
	
	/**
	 * ensures: the nest level is loaded when the player reaches the 
	 * far right bound of the screen
	 */
	public void nextLevel() {
		if (player.getX() >= 950 && levelIndexer == 1) {
			try {
				this.readFile("levels/level2.txt");
				levelIndexer ++ ;
			} catch (InvalidLevelFormatException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ensures: gets the number of the current level 
	 * @return
	 */
	public int getIndex() {
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
	
	/**
	 * ensures: determines what to do when the players hitBox 
	 * comes into contact with the certain type of obstacles 
	 */
	public void playerCollision() {
		int numOfObjectsOnPlayer = 0;
		for(Obstacle objects : obstacles) {
			if(player.playerHitBox().intersects(objects.obstacleHitBox())) {
				objects.onCollision(player);
				numOfObjectsOnPlayer ++;
				if(objects instanceof Coin) {
					numberOfCoins += .5;
				}
				// if the obstacle is a barrier call collideWithBarrier
				if(objects instanceof Barrier) {
					player.collideWithBarrier(objects);

				}
				// if the obstacle is not a coin player will reset and deduct a life 
				else if(!(objects instanceof Coin )){
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
		}
	}
	
	/**
	 * ensures: coin count is reset when new game is selected 
	 */
	public void resetCoins() {
		this.numberOfCoins = 0;
	}
/**
 * ensures: the level and player lives is reset when newGame is selected 
 */
public void restartGame() {
	this.levelIndexer = 1;
	this.player.lives = 3;
	this.resetCoins();
}

/**
 * ensures: each obstacle read from the text file is drawn on the screen 
 * creates a start screen when gamestate is zero and provides directions
 * when gamestate is 1 displays player lives and coin count 
 * @param g
 */
	public void drawnOn(Graphics2D g) {
		Graphics2D g2 = (Graphics2D)g;

		if(this.gameState == 0) {
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 100));
			g2.drawString("JET PACK JOY RIDE", 5, 500);
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g2.drawString("Press Space To Start", 300, 600);
			
		}else if(this.gameState == 1){
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
			g2.drawString("Number of Lives: " + player.getLives() , 50, 50);
			g2.drawString("Number of Coins: " + this.numberOfCoins , 300, 50);
		player.drawnOn(g2);
		for(Obstacle o : obstacles) {
			if(o.Draw){
				o.drawnOn(g2);
			}
		}

		}
		if(gameOver() == true) {
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 245));
			g2.drawString("WINNER!"  , 1, 500);
			gameState = 0;
		}
}
	
}