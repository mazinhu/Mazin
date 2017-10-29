package Minesweeper;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MineView {

	static MineController controller = new MineController ();

	public static void View (){
Container mainpane = getContentPane();
		

		JButton NewGameButton = new JButton("New Game");
		NewGameButton.addActionListener(controller.getNewGameListener());
		JButton LogGameButton = new JButton ("Log Game");
		//LogGameButton.addActionListener(LogListener);
		JButton HelpButton = new JButton("Help");
		HelpButton.addActionListener(controller.getHelpButtonListener());
		// Labels creation
		//---------------------------------Icons--------------------------//
		ImageIcon icon = new ImageIcon(
				"src/images/walker.png");
		ImageIcon iconLevel = new ImageIcon("src/images/level.png");
		ImageIcon iconCellsOpened = new ImageIcon(
				"src/images/open.png");
		ImageIcon iconTimeSpend = new ImageIcon(
				"src/images/clock.png");
		// labels
		JLabel image1L = new JLabel(icon, JLabel.CENTER);
		JLabel level = new JLabel("Level", iconLevel, JLabel.CENTER);
		JLabel boxesLeft = new JLabel("Cells Opened", iconCellsOpened, JLabel.CENTER);
		JLabel time = new JLabel("Time Spend", iconTimeSpend, JLabel.CENTER);
// -----------------------------------------Panel setup------------------------------------- // 
		// Left Panel buttons
		JPanel panelL = new JPanel();
		panelL.setLayout(new GridLayout(10, 10));
			
		for (int i = 0; i < gridButtons.length; i++) {			
			gridButtons[i]= new JButton("");
			gridButtons[i].setPreferredSize(new Dimension(50, 50));

		}
		
		for (int i=0;i<100;i++){
			panelL.add(gridButtons[i]);
			gridButtons[i].addActionListener(buttonClickListener);
		}
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
		panelLeft.add(panelL);
		panelLeft.setBorder(BorderFactory.createTitledBorder("Play"));
		
		
		//panelL.add(buttonclicked);

		// Right Panel box 1 that includes the label, image, and first three X
		// Axis buttons

		JPanel panelR1 = new JPanel();
		panelR1.setSize(20, 20);
		panelR1.setLayout(new BoxLayout(panelR1, BoxLayout.Y_AXIS));
		panelR1.setBorder(BorderFactory.createTitledBorder("The Mine"));
		panelR1.add(image1L, BorderLayout.PAGE_START);
		

		JPanel panelR2 = new JPanel();
		panelR2.setLayout(new BoxLayout(panelR2, BoxLayout.X_AXIS));
		panelR2.add(level);
		panelR2.add(LevelRadio());
		panelR2.add(new JSeparator(SwingConstants.VERTICAL) );
		panelR2.add(boxesLeft);
		panelR2.add(new JSeparator(SwingConstants.VERTICAL) );
		panelR2.add(time);		
		panelR2.setBorder(BorderFactory.createTitledBorder("Your status"));
		

		// Right Panel box 2 that includes all settings buttons
		JPanel panelR3 = new JPanel();
		panelR3.setLayout(new FlowLayout());
		panelR3.add(NewGameButton);
		panelR3.add(LogGameButton);
		panelR3.add(HelpButton);
		panelR3.setBorder(BorderFactory.createTitledBorder("Settings"));
		panelR3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		// final Right Panel
		JPanel panelR = new JPanel();
		panelR.setLayout(new BorderLayout());
		panelR.add(panelR1, BorderLayout.NORTH);
		panelR.add(Box.createRigidArea(new Dimension(10, 0)));
		panelR.add(panelR2, BorderLayout.CENTER);
		panelR.add(panelR3, BorderLayout.SOUTH);
		
		//panelR.setSize(new Dimension(200,400));

		mainpane.setLayout(new BorderLayout());
		mainpane.add(panelLeft, BorderLayout.WEST);
		mainpane.add(panelR, BorderLayout.CENTER);
	

	}
	
	 
	 
}
