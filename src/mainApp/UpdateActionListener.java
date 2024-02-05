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
		component.level.player.playerGravity();
 		component.update();
		
	}

	
	
}
