package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainKeyboardListener implements KeyListener {
	    private Player player;
		private static final int ITEM_WIDTH = 100;
		private static final int ITEM_HEIGHT = 90;
		private int levelIndexer;
		private boolean isPressed;
//		private ArrayList<Barrier> barrier;
//		private ArrayList<Player> player;
		private ArrayList<Obstacle> obstacles =  new ArrayList<>();;
		private static final int NUMBER_OF_LEVELS = 5;
		
		
		public MainKeyboardListener(int x) {
//			barrier = new ArrayList<Barrier>();
			obstacles = new ArrayList<Obstacle>();
			this.levelIndexer = x;
			this.isPressed = false;
		}
		@Override
		public void keyPressed(KeyEvent e) { 
			int currentKey = e.getKeyCode();
			if(currentKey == KeyEvent.VK_U) {
				System.out.print("U is selected");
				if(this.levelIndexer < NUMBER_OF_LEVELS) {
					this.levelIndexer++;
				}
			}
			runApp();
			this.isPressed = true;
			if(currentKey == KeyEvent.VK_D) {
				if(this.levelIndexer != 1) {
					this.levelIndexer--;
				}else {
					this.levelIndexer = 1;
				}
			}
			runApp();
			this.isPressed = false;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

			}
			
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
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
					    
					    System.out.println("Barrier at X: " + newBarrier.getX() + " Y: " + newBarrier.getY());
					}
					else if (line.charAt(j) == 'P') {
						Obstacle newPlayer = new Player(j* ITEM_WIDTH, row * ITEM_HEIGHT);
						this.obstacles.add(newPlayer);
					}
					else if (line.charAt(j) == 'C') {
						Obstacle newCoin = new Coin(j* ITEM_WIDTH, row * ITEM_HEIGHT);
						this.obstacles.add(newCoin);
						
					}else if (line.charAt(j) == 'E') {
						Obstacle newElectrifiedBarrier = new ElectrifiedBarrier(j* ITEM_WIDTH, row * ITEM_HEIGHT);
						System.out.println("E");
						this.obstacles.add(newElectrifiedBarrier);
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
//		public ArrayList<Player> createLevel(){
//			return this.player;
//		}
		public void runApp() {
			String NameOfFile = "levels/level1.txt";
			try {
				readFile(NameOfFile);
			}catch (InvalidLevelFormatException e) {
				e.printStackTrace();
			}
		}
}
