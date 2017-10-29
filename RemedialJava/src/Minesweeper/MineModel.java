package Minesweeper;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MineModel {

	
	
	
	
	public void NewGame () {
		for (int i=0;i<100;i++){
		
			gridButtons[i].setBackground(null);
			gridButtons[i].setText(String.format(""));
		
			gridButtons[i].setEnabled(true);
		}
	}
	
	public void GameLost(){
	
		JOptionPane.showMessageDialog(new JFrame(), "I am sorry, you lost! Click New Game to play again or Help to learn more about Minesweeper.");

	}
	
	// OpenPage method to open urls on the user default browser
	public void openWebPage(String url){
		   try {         
		     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		   }
		   catch (java.io.IOException e) {
		       System.out.println(e.getMessage());
		   }
		}
	
	
	
}
