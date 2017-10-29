import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class My_minesweeper extends JFrame {

	private JLabel labelCounter; 
	private JLabel labelRecord;
	
	private JButton buttonStart; // Button for reseting the fields
	private JButton buttonRecord; // Button for closing the window
	private JButton voiceOn; // Button for enabling voice
	private JButton voiceOff; 
	private JButton help;
	private JButton gridButton;
	private JLabel labelTimeSpent;
	private JLabel timeCounter;
	private JLabel buttonLabel;
	private JLabel flagLabel;
	private int rows = 8, cols = 6;
	
	Map<JButton, JLabel> mines = new HashMap<JButton, JLabel>();
	
	// ActionListener to process an event when a button is clicked

	private ActionListener gridButtonListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) (e.getSource());
			b.setVisible(false);
		}
	};
	
	private ItemListener difficultyListener = new ItemListener() {
	
		public void itemStateChanged(ItemEvent e) {
	        AbstractButton button = (AbstractButton) e.getItemSelectable();
	        String command = button.getActionCommand();
	        // build message

	        if (command.equals("easy")) {
	            rows = 8;
	            cols = 6;
	        } 
	        
	        else if (command.equals("medium")) {
	        	rows = 8;
	            cols = 8;
	        } 
	        
	        else if (command.equals("hard")) {
	        	rows = 12;
	            cols = 8;
	        }
		}
	};
	
	// Mouse Listener to respond to a Right-Click mouse event on the grid buttons
	
	private MouseListener mouseListener = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		  if (SwingUtilities.isRightMouseButton(e)) {
			  JButton b = (JButton) (e.getSource());
			  b.setVisible(false);
			  
	        }
	      }
	};

	//   title of the window //
	public My_minesweeper(String title) {
		super(title);
		init();
	}

	// Initialize the window //
	public void init() {
		// ...
		labelCounter = new JLabel("000");
		labelCounter.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		buttonStart = new JButton("RESET");
		labelRecord = new JLabel("Record");
		buttonRecord = new JButton("R");
		buttonRecord.setBackground(Color.lightGray);
		JPanel startPane = new JPanel();
		JPanel controlPane = new JPanel();
		
		// Splitpane to separate two parts in the top pane //
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, startPane, controlPane);
		
		startPane.setLayout(new BoxLayout(startPane, BoxLayout.X_AXIS));
		startPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		startPane.add(labelCounter);
		startPane.add(Box.createHorizontalGlue());
		startPane.add(buttonStart);
		startPane.add(Box.createHorizontalGlue());
		startPane.add(labelRecord);
		startPane.add(Box.createRigidArea(new Dimension(10,0)));
		startPane.add(buttonRecord);
		
		// Panel to house radio buttons for difficulty adjustment //
		
		JPanel gameLevelPane = new JPanel();
		JRadioButton easy = new JRadioButton("Easy", true);
		easy.setActionCommand("easy");
		JRadioButton medium = new JRadioButton("Medium");
		medium.setActionCommand("medium");
		JRadioButton hard = new JRadioButton("Hard");
		hard.setActionCommand("hard");
		
		easy.addItemListener(difficultyListener);
		medium.addItemListener(difficultyListener);
		hard.addItemListener(difficultyListener);
		
		ButtonGroup difficultyGroup = new ButtonGroup();
		difficultyGroup.add(easy);
		difficultyGroup.add(medium);
		difficultyGroup.add(hard);
		
		
		gameLevelPane.setLayout(new BoxLayout(gameLevelPane, BoxLayout.X_AXIS));
		gameLevelPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		gameLevelPane.add(easy);
		gameLevelPane.add(medium);
		gameLevelPane.add(hard);
		
		// Panel to house elements for enabling voice recognition //
		
		JPanel audioPane = new JPanel();
		
		voiceOn = new JButton("ON");
		voiceOff = new JButton("OFF");
		ButtonGroup audioGroup = new ButtonGroup();
		audioGroup.add(voiceOn);
		audioGroup.add(voiceOff);
		
		help = new JButton("?");
		
		JLabel audioLabel = new JLabel("Voice");
		audioPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		audioPane.setLayout(new BoxLayout(audioPane, BoxLayout.X_AXIS));
		audioPane.add(audioLabel);
		audioPane.add(Box.createRigidArea(new Dimension(10,0)));
		audioPane.add(voiceOn);
		audioPane.add(voiceOff);
		audioPane.add(Box.createRigidArea(new Dimension(10,0)));
		audioPane.add(Box.createHorizontalGlue());
		audioPane.add(help);
		
		controlPane.setLayout(new BorderLayout());
		controlPane.add(gameLevelPane, BorderLayout.WEST);
		controlPane.add(audioPane, BorderLayout.EAST);
		
		// Overlay layout to Create a mine grid //
		
		JPanel minePane = new JPanel();
		minePane.setLayout(new OverlayLayout(minePane));
		
		// Generate Mine //

		JPanel boomPane = new JPanel();
		int gap = 5;
		boomPane.setLayout(new GridLayout(rows, cols, gap, gap));
		boomPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		
		for (int i = 0; i < rows*cols; i++) {
			buttonLabel = new JLabel("BOOM!");
			buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
			boomPane.add(buttonLabel);
		}
		
		// Generate flags //
		
		JPanel flagPane = new JPanel();
		flagPane.setLayout(new GridLayout(rows, cols, gap, gap));
		flagPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		
		for (int i = 0; i < rows*cols; i++) {
			flagLabel = new JLabel("FLG!");
			flagLabel.setHorizontalAlignment(SwingConstants.CENTER);
			flagPane.add(flagLabel);
		}
		
		JPanel gridPane = new JPanel();
		gridPane.setLayout(new GridLayout(rows, cols, gap, gap));
		gridPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		for (int i=0; i< (rows*cols); i++) {
			gridButton = new JButton("");
			gridButton.addActionListener(gridButtonListener);
			
			gridPane.add(gridButton);
		}
		
		gridPane.setOpaque(false);
		minePane.add(gridPane, new Integer(1));
		minePane.add(boomPane, new Integer(2));
		minePane.add(flagPane, new Integer(0));
		
		// Bottom pane housing game timer //
		
		labelTimeSpent = new JLabel("Time Spent");
		timeCounter = new JLabel("00:00");
		timeCounter.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JPanel timePane = new JPanel();
		timePane.setLayout(new BoxLayout(timePane, BoxLayout.X_AXIS));
		timePane.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		timePane.add(Box.createHorizontalGlue());
		timePane.add(labelTimeSpent);
		timePane.add(Box.createRigidArea(new Dimension(10,0)));
		timePane.add(timeCounter);
		timePane.add(Box.createHorizontalGlue());
		
		Container mainPane = getContentPane();
	
		mainPane.setLayout(new BorderLayout());
		mainPane.add(splitPane, BorderLayout.NORTH);
		mainPane.add(minePane, BorderLayout.CENTER);
		mainPane.add(timePane, BorderLayout.SOUTH);
		
		// Resize window and make it visible
		pack();
		setSize(new Dimension(500, 500));
		setVisible(true);
		
		// Close the application when the user closes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new My_minesweeper("My Game");
	}
}