package mainApp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateActionListener implements ActionListener {
 public MainAppComponent component;
 
 public UpdateActionListener( MainAppComponent component) {
	 this.component = component; 
	 
 }
	@Override
	public void actionPerformed(ActionEvent e) {
//		if(component.level.player.getY() <= 980) {
		component.level.player.playerGravity();
//		}
//		component.level.missile.missileMovement();
 		component.update();
		
	}

	
	
}
