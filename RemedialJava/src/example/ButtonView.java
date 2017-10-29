package example;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

/**
 * 
 * @author Mazin
 */
public class ButtonView extends JButton  {

    private static final long serialVersionUID = 1L;
    private JButton button;
    private Field field;
    private Controller controller;

    /**
     * Creates the Buttons
     *
     * @param field 
     */
    public ButtonView(Field field) {
        this.field = field;
        this.button = new JButton("");
        this.button.setPreferredSize(new Dimension(50, 50));
        this.controller = new Controller(field);
        this.button.addMouseListener(controller);
 
    }

    public JButton getButton() {
        return this.button;
    }

    /**
     * Makes a Button Invisible
     */
    public void setUnvisible() {
        this.button.setVisible(false);
        this.field.reveal();
    }

    /**
     * Update button view
     * 
     * @param obs 
     * @param o
     */
    public void update() {
        // TODO Auto-generated method stub
        if (field.getRevealed() == true) {

            if (this.field.getField_id() == 9) {
                this.button.setBackground(Color.red);
                this.button.setText("*");
            } else {
                this.button.setBackground(Color.LIGHT_GRAY);
                if (this.field.getField_id() == 0) {
                    this.button.setText("");
                } else {
                    this.button.setText(Integer.toString(this.field.getField_id()));
                }
            }
        }
        if (field.isFlag()) {
            this.button.setText("!");
            this.button.setBackground(Color.orange);
        }
        if (!field.isFlag() && !field.getRevealed()) {
            this.button.setText("");
            this.button.setBackground(new JButton().getBackground());
        }
    }

}
