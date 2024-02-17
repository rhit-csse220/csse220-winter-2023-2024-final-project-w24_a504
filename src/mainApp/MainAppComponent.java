package mainApp;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MainAppComponent extends JComponent {
	public Level level;
	private int levelNum;
	private JFrame frame;
	public static final int SCREEN_HEIGHT = 800;
	public static final int SCREEN_WIDTH = 800;
	public static final int startingLevel = 1;
	
	public MainAppComponent(JFrame frame) throws InvalidLevelFormatException {
		this.frame = frame;
		level = new Level(frame);
		 this.setLevelNum(startingLevel);
		String NameOfFile = "levels/level1.txt";
		this.level.readFile(NameOfFile);		 
	 }
	
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
	public int getLevelNum() {
		return levelNum;
	}
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	        	Graphics2D g2 = (Graphics2D) g;
	        	level.drawnOn(g2);
	        }
			public void update() {
				this.repaint();
			}
}
