package example;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 *@author Mazin
 */
public class Controller extends MouseAdapter {

    private Field field;
    private Model model;

    /**
     * Constructor
     *
     */
    public Controller(Field field) {
        this.field = field;
    }

    /**
     * change the field
     */
    public void updateField(Field field) {
        this.field = field;
    }

    /**
     * Constructor
     *
     */
    public Controller(Model model) {
        this.model = model;
    }
    
    /**
     * Checks for Mouseclicks and class the Method in the model
     *
     * @param e the MouseEvent that just happened
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                if (this.model == null) {
                    if (!field.isFlag()) {
                        field.reveal();

                    }
                } else {
                    model.Init();
                }
                break;
            case MouseEvent.BUTTON3:
                if (this.model == null) {
                    field.changeState();
                }
                break;
            default:
                break;
        }
    }
}
