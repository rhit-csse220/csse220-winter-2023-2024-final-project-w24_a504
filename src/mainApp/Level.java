package mainApp;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class Level {
	private static final int ITEM_WIDTH = 100;
	private static final int ITEM_HEIGHT = 90;
	private ArrayList<Obstacle> obstacles =  new ArrayList<>();;
	private static final int NUMBER_OF_LEVELS = 5;
	public int levelIndexer;
	public Player player;
	private boolean isPressed;
	public JFrame frame;
	
	public Level(JFrame frame) {
		this.frame = frame;
		 player = new Player(0, 0, this.frame);
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
//					Obstacle newPlayer = new Player(j* ITEM_WIDTH, row * ITEM_HEIGHT);
//					Player newPlayer = new Player(0, 0, this.frame);
//					this.obstacles.add(newPlayer);
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
				}
			}
			row++;
		}
		scanner.close();
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

//	public void runApp() {
//		String NameOfFile = "levels/level1.txt";
//		try {
//			readFile(NameOfFile);
//		}catch (InvalidLevelFormatException e) {
//			e.printStackTrace();
//		}
//	}
	public void drawnOn(Graphics2D g) {
		Graphics2D g2 = (Graphics2D)g;
		player.drawnOn(g2);
		for(Obstacle o : obstacles) {
			o.drawnOn(g2);
		//	System.out.println("level x " + o.x + "level y " + o.y );
		}
}
}