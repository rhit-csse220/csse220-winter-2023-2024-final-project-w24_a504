package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainKeyboardListener implements KeyListener {
		private MainAppComponent element;
		private static final int NUMBER_OF_LEVELS = 5;
		private static final int BARRY_INITIAL_Y = 0;
		private static final int BARRY_VEL = -15;
	
		
		public MainKeyboardListener(MainAppComponent element) {
			this.element = element;
		}
		@Override
		public void keyPressed(KeyEvent e) { 
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				this.element.getPlayer().setVelY(BARRY_VEL);
			}
			if(e.getKeyCode() == KeyEvent.VK_U) {			
				if(this.element.getLevelNum()< NUMBER_OF_LEVELS) {
					this.element.setLevelNum(this.element.getLevelNum() + 1);
					try {
						this.element.loadLevel();
					} catch(InvalidLevelFormatException eCheck) {
						System.err.println(eCheck.distanceOff());
					}
				}
		}
			if(e.getKeyCode()== KeyEvent.VK_D) {
				if(this.element.getLevelNum() > MainApp.startingLevel) {
					this.element.setLevelNum(this.element.getLevelNum() - 1);
				}
				try {
					this.element.loadLevel();
				} catch (InvalidLevelFormatException eCheck) {
					System.err.println(eCheck.distanceOff());
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				this.element.getPlayer().setVelY(BARRY_INITIAL_Y);
			}
			
	}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
