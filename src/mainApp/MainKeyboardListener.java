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
		
		
		public MainKeyboardListener(int x, Player player) {
//			barrier = new ArrayList<Barrier>();
		//	obstacles = new ArrayList<Obstacle>();
			this.levelIndexer = x;
			this.isPressed = false;
			this.player = player;
		}
		@Override
		public void keyPressed(KeyEvent e) { 	
			int currentKey = e.getKeyCode();
		        switch (currentKey) {
		        // the code below moves the player 
		            case KeyEvent.VK_UP:
		               player.setY(player.getY() - 10);
		               System.out.println(" up Player's new position: X=" + player.getX() + ", Y=" + player.getY());
		               
		                break;
		                
		            case KeyEvent.VK_DOWN:
		            	player.setY(player.getY() + 10);
		            	System.out.println(" down Player's new position: X=" + player.getX() + ", Y=" + player.getY());
		                break;
		                
		            case KeyEvent.VK_LEFT:
		            	player.setX(player.getX() - 10);
		            	System.out.println(" left Player's new position: X=" + player.getX() + ", Y=" + player.getY());
		                break;
		                
		            case KeyEvent.VK_RIGHT:
		            	player.setX(player.getX() + 10);
		            	System.out.println(" right Player's new position: X=" + player.getX() + ", Y=" + player.getY());
		                break;
		        	
		     
		                
		        //the code below loads level 		
		        case KeyEvent.VK_U:
				System.out.print("U is selected");
				if(this.levelIndexer < NUMBER_OF_LEVELS) {
					this.levelIndexer++;
					//break;
				}
				break;
				
				
				case KeyEvent.VK_D:
					if(this.levelIndexer != 1) {
						this.levelIndexer--;
					}else {
						this.levelIndexer = 1;
					}
				break;
				
			}  
			}
			
	
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

			}
			
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
}
