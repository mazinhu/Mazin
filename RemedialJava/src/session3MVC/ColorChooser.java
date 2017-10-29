package session3MVC;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ColorChooser extends JDialog {

	private JPanel sample; // Color preview box
	private JTextField colorCode; // Text field containing the color in hex
	private JTextField RedText;
	private JTextField GreenText;
	private int colorcode;

	// format

	/**
	 * Creates a modal window containing a basic RGB color chooser.
	 *  I need to create three classes, one for the Model, Viewer and one for the Controller. Check the image on your phone
	 *  to see the implementation plan. Pending: Textfield listeners and the Hex listener with get and set text values to send to the Model
	 *  model: calculate the color and send it to the Viewer.
	 * @param owner
	 *            The parent window.
	 * @param red
	 *            Red component of the RGB color.
	 * @param green
	 *            Green component of the RGB color.
	 * @param blue
	 *            Blue component of the RGB color.
	 */
	public ColorChooser(JFrame owner, Integer red, Integer green, Integer blue) {
		super(owner, "Color Chooser", true);
		// Create the color model
		// ...
		init();
	}

	private void setColor(int ColorCode) {
		this.colorcode = ColorCode;
	}

private int getColor() {
	return this.colorcode;
}
	private ChangeListener SliderListener = new ChangeListener() {
		

		public void stateChanged(ChangeEvent e) {
			// if color.equals("Red"){
            
			if (getColor() == 001) {
				RedText.setText("" + ((JSlider) e.getSource()).getValue());
			} else if (getColor()== 002){
				GreenText.setText("" + ((JSlider) e.getSource()).getValue());
			}
			// }

		}

	};

	/**
	 * Initialize the color selector window
	 */
	public void init() {
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());

		// Column 1: Sliders
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// Red
		JSlider Redslider = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
		setColor(001);
		Redslider.addChangeListener(SliderListener);
		panel.add(Redslider);
		// Green
		// ...
		JSlider Greenslider = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
		setColor(002);
		Greenslider.addChangeListener(SliderListener);
		panel.add(Greenslider);
		// Blue
		// ...
		JSlider Blueslider = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
	 
		Blueslider.addChangeListener(SliderListener);
		panel.add(Blueslider);
		// ...

		JPanel paneltext = new JPanel();
		paneltext.setLayout(new BoxLayout(paneltext, BoxLayout.Y_AXIS));

		// Column 2: Text fields (next to the sliders)
		// ...
		// Red
		// ...
		RedText = new JTextField(3);
		paneltext.add(RedText);
		// Green

		// ...
		GreenText = new JTextField(3);
		paneltext.add(GreenText);
		// Blue
		// ...
		JTextField BlueText = new JTextField(3);
		paneltext.add(BlueText);
		// Add to window
		// ...

		// Column 3: Hex color field and color sample
		// ...
		JPanel panelHex = new JPanel();
		panelHex.setLayout(new BoxLayout(panelHex, BoxLayout.Y_AXIS));
		// Color text field in hex format
		// ...
		JTextField HexText = new JTextField(6);
		panelHex.add(HexText);
		// Color preview panel
		// ...
		JPanel panelColor = new JPanel();
		panelColor.setLayout(new BoxLayout(panelColor, BoxLayout.PAGE_AXIS));
		panelColor.setBackground(Color.BLACK);
		panelColor.setPreferredSize(new Dimension(50, 50));
		panelColor.setMaximumSize(panelColor.getPreferredSize());
		panelColor.setMinimumSize(panelColor.getPreferredSize());
		panelHex.add(panelColor);
		// Add to window
		// ...

		// Add to window
		pane.add(panel);
		pane.add(paneltext);
		pane.add(panelHex);
		// Resize window and make it visible
		pack();
		setVisible(true);
	}

	static public void main(String args[]) {
		ColorChooser rgb = new ColorChooser(null, 79, 178, 255);
		System.exit(1);
	}

}