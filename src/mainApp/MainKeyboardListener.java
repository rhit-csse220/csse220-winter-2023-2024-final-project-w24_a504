package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Class: MainKeyBoardListener
 * @author W24_a504
 * Purpose: checks if a user command is pressed
 */
public class MainKeyboardListener implements KeyListener {
		public Level level;
	    private Player player;
		public int vertical_speed = 10;
		public int terminal_velocity = 300;
		private static final int NUMBER_OF_LEVELS = 5;
		
		/**
		 * ensures: a KeyListener event is created 
		 * @param player
		 * @param level
		 */
		public MainKeyboardListener(Player player, Level level) {
			this.player = player;
			this.level = level;
			
		}
		@Override
		public void keyPressed(KeyEvent e) { 

			  if(!(player.isMoveable())) {
		        	return;
		        }
			int currentKey = e.getKeyCode();
		        switch (currentKey) {
		        // the code below moves the player 
		      
		            case KeyEvent.VK_UP:	         
		            	player.setY(player.getY() - 50);
		               break;
	                
		            case KeyEvent.VK_DOWN:
		            	player.setY(player.getY() + 10);
		            	
		                break;
		                
		            case KeyEvent.VK_LEFT:
		            	player.setX(player.getX() - 15);
		            	
		                break;
		                
		            case KeyEvent.VK_RIGHT:
		            	if (player.getX() <= 950) {
		            	player.setX(player.getX() + 10);
		            	break;
		            	}
		            	// this code starts the game when the spae key is pressed
		            case KeyEvent.VK_SPACE:
		            	this.level.gameState = 1;
		                
		            	break;
		     
		                
		        //the code below loads level based on user key press	
		        case KeyEvent.VK_U:
				System.out.print("U is selected");
				if(this.level.levelIndexer < NUMBER_OF_LEVELS) {
					this.level.levelIndexer++;
					String NameOfFile = "levels/level2.txt";
					try {
						this.level.readFile(NameOfFile);
					} catch (InvalidLevelFormatException e1) {
						e1.printStackTrace();
					}
					
				}
				break;
				
				
				case KeyEvent.VK_D:
					System.out.print("D is selected");
					if(this.level.levelIndexer != 0) {
						this.level.levelIndexer--;
						String NameOfFile = "levels/level1.txt";
						try {
							this.level.readFile(NameOfFile);
						} catch (InvalidLevelFormatException e1) {
							e1.printStackTrace();
						}
					}else {
						this.level.levelIndexer = 0;
						
					}
				break;
				
			}  
			}
			
	
		@Override
		public void keyReleased(KeyEvent e) {
			}
			
		@Override
		public void keyTyped(KeyEvent e) {
		}
	
}
