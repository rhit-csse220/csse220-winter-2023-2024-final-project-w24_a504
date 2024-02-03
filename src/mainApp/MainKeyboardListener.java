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
		private ArrayList<Barrier> barrier;
		private static final int NUMBER_OF_LEVELS = 5;
		
		
		public MainKeyboardListener(int x) {
			barrier = new ArrayList<Barrier>();
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
						Barrier newBarrier = new Barrier(j * ITEM_WIDTH, row * ITEM_HEIGHT);
					    this.barrier.add(newBarrier);
					    
					    System.out.println("Barrier at X: " + newBarrier.getX() + " Y: " + newBarrier.getY());
					}
					else if (line.charAt(j) == 'P') {
						Barrier newPlayer = new Barrier(j* ITEM_WIDTH, row * ITEM_HEIGHT);
						this.barrier.add(newPlayer);
					}
					else if (line.charAt(j) == 'C') {
//						this.barrier.add(new Coin(j,j));
					}
				}
				row++;
			}
			scanner.close();
		}
		public int getIndex() {
			return this.levelIndexer;
		}
		public boolean getIsPressed() {
			return this.isPressed;
		}
		public Player getPlayer() {
		return this.player;
	}
		public ArrayList<Barrier> createLevel(){
			return this.barrier;
		}
		public void runApp() {
			String NameOfFile = "levels/level1.txt";
			try {
				readFile(NameOfFile);
			}catch (InvalidLevelFormatException e) {
				e.printStackTrace();
			}
		}
}
