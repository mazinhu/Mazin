package Minesweeper;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class MineController {

	public  MineController (){
		
	}
	
	
	private ActionListener buttonClickListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Icon pressedIcon = new ImageIcon(					"src/images/clock.png");
			//buttonclicked.setPressedIcon(pressedIcon);
			Random generator = new Random();
			int num1 = generator.nextInt(5); 
			if( e.getSource() instanceof JButton) {
				  
			       ((JButton)e.getSource()).setBackground(Color.LIGHT_GRAY);
			     
			       if(num1==4){
			    	   
			    	   ((JButton)e.getSource()).setText(String.format("*"));
			    	   ((JButton)e.getSource()).setBackground(Color.RED);
			    	    GameLost();
			    	   ((JButton)e.getSource()).setEnabled(false);
			    	    
			       }else {
			    	   ((JButton)e.getSource()).setText(String.format(""+num1));
			    	   ((JButton)e.getSource()).setEnabled(false);
			    	    
			       }
			   }
			
		}
	};
	
	
	private ActionListener NewGameListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if( e.getSource() instanceof JButton) {  
			 
				NewGame();
		      
		
			}
			
		}
	};


	// Help Button listener, it will temporarily direct the user to online documentation
		private ActionListener HelpButtonListener = new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        openWebPage("http://www.minesweeper.info/wiki/Windows_Minesweeper");
		    }
		};


		public  ActionListener getNewGameListener() {
			return NewGameListener;
		}


		public void setNewGameListener(ActionListener newGameListener) {
			NewGameListener = newGameListener;
		}


		public ActionListener getHelpButtonListener() {
			return HelpButtonListener;
		}


		public void setHelpButtonListener(ActionListener helpButtonListener) {
			HelpButtonListener = helpButtonListener;
		}
		
		
		
}
