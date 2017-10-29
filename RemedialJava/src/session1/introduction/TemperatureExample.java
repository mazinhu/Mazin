package session1.introduction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TemperatureExample extends JFrame {

	private JLabel labelC; // Name of the Celsius field
	private JLabel labelF; // Name of the Fahrenheit field
	private JTextField textFieldC; // Celsius field
	private JTextField textFieldF; // Fahrenheit field
	private JButton buttonReset; // Button for reseting the fields
	private JButton buttonClose; // Button for closing the window

	/*
	 * Listener of the Celsius field: convert the data from Clesius to
	 * Fahrenheit when the "enter" keyboard button is hit (in the Clesius field)
	 */
	private ActionListener textFieldCListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String value = textFieldC.getText();
			try {
				float valC = new Float(value);
				float valF = valC * 1.8f + 32;
				textFieldF.setText(Float.toString(valF));
			} catch (Exception exp) {
				textFieldF.setText("");
				textFieldC.setText("");
			}
		}
	};

	/*
	 * Listener of the Fahreneit field: convert the data from Fahreneit to
	 * Celcius when the "enter" keyboard button is hit (in the Clesius field)
	 */
	private ActionListener textFieldFListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String value = textFieldF.getText();
			try {
				float valF = new Float(value);
				float valC = (valF - 32)/1.8f;
				textFieldC.setText(Float.toString(valC));
			} catch (Exception exp) {
				textFieldF.setText("");
				textFieldC.setText("");
			}
		}
	};
	/*
	 * Listener of the Fahrenheit field: Convert the data from Fahrenheit to
	 * Celsius when the "enter" keyboard button is hit (in the Fahrenheit field)
	 */
	// private ActionListener textFieldFListener = new ActionListener() {
	// ...
	// };

	/*
	 * Listener of the Reset button: Reset the value in the text field when the
	 * Reset button is pressed
	 */
	private ActionListener buttonResetListener = new ActionListener() {
	public void actionPerformed(ActionEvent e){
		textFieldF.setText("");
		textFieldC.setText("");	
	}
	
	
	 };

	/*
	 * Listener of the Close button: Close the program window when the Close
	 * button is pressed
	 */

	private ActionListener buttonCloseListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};

	/**
	 * Constructor of the temperature converter
	 * 
	 * @param title
	 *            title of the window
	 */
	public TemperatureExample(String title) {
		super(title);
		init();
	}

	/**
	 * Initialize the converter window
	 */
	public void init() {
		labelC = new JLabel("Celcius");
		labelF = new JLabel("Fahreneit");
		
		textFieldC = new JTextField(20);		
		textFieldF = new JTextField(20);
		
		textFieldC.addActionListener(textFieldCListener);
		textFieldF.addActionListener(textFieldFListener);
		
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(buttonResetListener);
		buttonClose = new JButton("Close");
		buttonClose.addActionListener(buttonCloseListener);
		
		// ...
		JPanel paneC = new JPanel();
		paneC.setLayout(new BoxLayout(paneC, BoxLayout.Y_AXIS));
		paneC.add(labelC);
		paneC.add(textFieldC);

	    JPanel paneF = new JPanel();
		paneF.setLayout(new BoxLayout(paneF, BoxLayout.Y_AXIS));
		paneF.add(labelF);
		paneF.add(textFieldF);

		JPanel tempPane = new JPanel();
		tempPane.add(paneC);
		tempPane.add(paneF);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(buttonReset);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(buttonClose);

		Container mainPane = getContentPane();
		mainPane.setLayout(new BorderLayout());
		mainPane.add(tempPane, BorderLayout.CENTER);
		mainPane.add(buttonPane, BorderLayout.SOUTH);

		// Resize window and make it visible
		pack();
		setVisible(true);
		// Close the application when the user closes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new TemperatureExample("Temperature converter");

		
	}

}