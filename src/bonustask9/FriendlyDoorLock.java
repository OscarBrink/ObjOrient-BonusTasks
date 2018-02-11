package bonustask9;

import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

 /**
 * Class implements a door lock with a 4-digit PIN.
 *
 * @author Oscar Brink
 * 2018-02-11
 */
public class FriendlyDoorLock {

    public static void main(String argv[]) {
        JFrame frame = new JFrame("Friendly door lock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); // the "background"
        JLabel label = new JLabel("Enter PIN (4 digits):");

        // Field where the PIN is to be entered.
        JTextField text = new JTextField("", 4);

        // Shows if the entered PIN is correct, too high, or too low.
        JLabel resultText = new JLabel("---------------------------");

        // Adding all GUI elements to the "background".
        panel.add(label);
        panel.add(text);
        panel.add(resultText);

        frame.setContentPane(panel);

        // Creates a listener that listens for a PIN input.
        text.addActionListener(
                new InputHandler(text, generateRandomInt(0, 9999), resultText)
        );

        // Draws the GUI.
        frame.pack();
        frame.setVisible(true);
    }

    /*
    Generates a random integer between max and min.
     */
    private static int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

/**
 * This class parses and checks input for the door lock.
 *
 * @author Oscar Brink
 */
class InputHandler implements ActionListener {
    private JTextField text;
    private Integer pin;
    private JLabel resultText;

    InputHandler(JTextField text, Integer pin, JLabel resultText) {
        this.text = text;
        this.pin = pin;
        this.resultText = resultText;
    }

    /**
     * called when the return key is depressed
     */
    public void actionPerformed(ActionEvent arg0) {
        int input = Integer.parseInt(text.getText());

        if (input == pin) {
            resultText.setText("CORRECT");
        } else if (input > pin) {
            resultText.setText("WRONG (too high)");
        } else {
            resultText.setText("WRONG (too low)");
        }

        text.setText(""); // empty the text field
    }
}
